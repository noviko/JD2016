package by.it.podelstchikova.jd02_01.implementation;

import by.it.podelstchikova.jd02_01.utils.Helper;

public class CashDesk implements Runnable{

    private int cashDeskName;

    public CashDesk(int name){
        this.cashDeskName = name;
        Market.incrementCashDeskcount();
        System.out.println("Cash Desk #" + cashDeskName + " is opened");
    }

    private Customer getCustomerFromLine(){
        return Market.getCustomerFromLine();
    }

    private void serveCustomer(Customer customer){
        try {
            System.out.println("Cash Desk " + cashDeskName + " is serving customer " + customer);
            Thread.sleep(Helper.getRandomIntegerInRange(2000, 5000));

            System.out.println(customer + " bought the the following:");
            int totalAmount = 0;
            for (Good g : customer.getCart().getAllGoods()){
                System.out.println(g.getName() + " by price " + g.getPrice());
                totalAmount += g.getPrice();
            }
            Market.addRevenue(totalAmount);
            System.out.println("Total amount of " + customer + ": " + totalAmount);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!Market.closeTheMarket()) {
                int customerInLine = Market.getCustomerLineSize();
                int openedCashDesksCount = Market.getCashDeskcount();
                if (openedCashDesksCount > 1){
                    if (customerInLine / openedCashDesksCount < 5 ){
                        Market.decrementCashDeskcount();
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
