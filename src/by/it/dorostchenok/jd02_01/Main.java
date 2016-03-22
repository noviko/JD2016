package by.it.dorostchenok.jd02_01;

import by.it.dorostchenok.jd02_01.implementation.Customer;

public class Main {
    public static void main(String[] args) {
//        for (int j = 1; j <= 100; j++){
//            if (j % 4 == 0){
//                new Thread(new Customer(j, true)).start();
//            } else {
//                new Thread(new Customer(j)).start();
//            }
            //System.out.println(Helper.getRandomIntegerInRange(0, 3));
            //CustomerImpl cust = new CustomerImpl(4);

        Runner runner = new Runner();
        try {
            runner.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
