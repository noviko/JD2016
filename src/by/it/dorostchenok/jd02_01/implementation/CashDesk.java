package by.it.dorostchenok.jd02_01.implementation;

import by.it.dorostchenok.jd02_01.utils.Helper;

public class CashDesk implements Runnable{

    private String cashDeskName = "";

    public CashDesk(String name){
        this.cashDeskName = name;
        System.out.println("Cash Desk #" + name + " is opened");
    }

    private Customer getCustomerFromLine(){
        return CustomerLine.getCustomerFromLine();
    }

    private void serveCustomer(Customer customer){
        try {
            System.out.println("Cash Desk " + cashDeskName + " is serving customer " + customer.toString());
            Thread.sleep(Helper.getRandomIntegerInRange(2000, 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!CustomerLine.closeTheMarket()) {
                Customer customer = getCustomerFromLine();
                if (customer != null) {
                    serveCustomer(customer);
                    customer.setReadyToGoOut(true);
                } else {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
