package by.it.dorostchenok.jd02_01.implementation;

import by.it.dorostchenok.jd02_01.utils.Helper;

public class CashDesk implements Runnable{

    private int cashDeskName;

    public CashDesk(int name){
        this.cashDeskName = name;
        CustomerLine.incrementCashDeskcount();
        System.out.println("Cash Desk #" + cashDeskName + " is opened");
    }

    private Customer getCustomerFromLine(){
        return CustomerLine.getCustomerFromLine();
    }

    private void serveCustomer(Customer customer){
        try {
            System.out.println("Cash Desk " + cashDeskName + " is serving customer " + customer.toString());
            Thread.sleep(Helper.getRandomIntegerInRange(10000, 11000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!CustomerLine.closeTheMarket()) {
                int customerInLine = CustomerLine.getCustomerLineSize();
                int openedCashDesksCount = CustomerLine.getCashDeskcount();
                if (customerInLine != 0 && openedCashDesksCount > 2){
                    if (customerInLine - openedCashDesksCount * 5 + 5 < 0){
                        CustomerLine.decrementCashDeskcount();
                        System.out.println("Cash Desk #" + cashDeskName + " is closed");
                        return;
                    }
                }
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
