package by.it.dorostchenok.jd02_01;

import by.it.dorostchenok.jd02_01.implementation.CashDesk;
import by.it.dorostchenok.jd02_01.implementation.Customer;
import by.it.dorostchenok.jd02_01.implementation.CustomerLine;
import by.it.dorostchenok.jd02_01.utils.Helper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private static int customerCount = 0;

    public void run() throws InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(5);
            for (int j = 1; j <= 5; j++){
                exec.execute(new CashDesk(String.valueOf(j)));
            }
        System.out.println("All desk started");
        while (customerCount < CustomerLine.customersToServe){
            Thread.sleep(1000);
            for (int j = 0; j < Helper.getRandomIntegerInRange(0, 2); j++){
                customerCount++;
                if (customerCount < CustomerLine.customersToServe + 1){
                    //queue.add(new Customer(customerCount));
                    //new Thread(new Customer(customerCount)).start();
                    System.out.println("New Customer " + customerCount);
                    new Thread(new Customer(customerCount)).start();
                }
            }
        }

        exec.shutdown();
    }
}
