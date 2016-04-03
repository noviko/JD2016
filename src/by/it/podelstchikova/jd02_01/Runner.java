package by.it.podelstchikova.jd02_01;

import by.it.podelstchikova.jd02_01.implementation.CashDesk;
import by.it.podelstchikova.jd02_01.implementation.Customer;
import by.it.podelstchikova.jd02_01.implementation.Market;
import by.it.podelstchikova.jd02_01.utils.Helper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner{

    private static int customerCount = 0;
    private static final int maxNumberOfCashDesk = 5;

    public void run() {

        ExecutorService exec = Executors.newFixedThreadPool(maxNumberOfCashDesk);

        while (customerCount < Market.customersToServe){

            if (Market.getCustomerLineSize() > 5 && Market.getCashDeskcount() < maxNumberOfCashDesk){
                exec.execute(new CashDesk(Market.getCashDeskcount() + 1));
            }
            for (int j = 0; j < Helper.getRandomIntegerInRange(0, 2); j++){
                customerCount++;
                if (customerCount < Market.customersToServe + 1){
                    System.out.println("New Customer " + customerCount);
                    new Thread(new Customer(customerCount)).start();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        exec.shutdown();


    }
}
