package by.it.dorostchenok.jd02_01;

import by.it.dorostchenok.jd02_01.implementation.CashDesk;
import by.it.dorostchenok.jd02_01.implementation.Customer;
import by.it.dorostchenok.jd02_01.implementation.CustomerLine;
import by.it.dorostchenok.jd02_01.utils.Helper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private static int customerCount = 0;
    private static final int maxNumberOfCashDesk = 5;
    public void run() throws InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(maxNumberOfCashDesk);

        while (customerCount < CustomerLine.customersToServe){
            Thread.sleep(1000);
            if (CustomerLine.getCustomerLineSize() > 5 && CustomerLine.getCashDeskcount() < maxNumberOfCashDesk){
                exec.execute(new CashDesk(CustomerLine.getCashDeskcount() + 1));
            }
            for (int j = 0; j < Helper.getRandomIntegerInRange(0, 2); j++){
                customerCount++;
                if (customerCount < CustomerLine.customersToServe + 1){
                    System.out.println("New Customer " + customerCount);
                    new Thread(new Customer(customerCount)).start();
                }
            }
        }

        exec.shutdown();
    }
}
