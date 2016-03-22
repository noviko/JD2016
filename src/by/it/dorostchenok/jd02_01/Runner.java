package by.it.dorostchenok.jd02_01;

import by.it.dorostchenok.jd02_01.implementation.Customer;
import by.it.dorostchenok.jd02_01.utils.Helper;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {

    private static int customerCount = 0;

    public void run() throws InterruptedException {
        Queue<Customer> queue = new ArrayDeque<>();
        while (customerCount < 10){
            Thread.sleep(1000);
            for (int j = 0; j < Helper.getRandomIntegerInRange(0, 2); j++){
                customerCount++;
                if (customerCount < 11){
                    //queue.add(new Customer(customerCount));
                    new Thread(new Customer(customerCount)).start();
                }
            }
        }


    }
}
