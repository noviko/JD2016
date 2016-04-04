package by.it.podelstchikova.jd02_01.implementation;

import by.it.podelstchikova.jd02_01.interfaces.CustomerInterface;
import by.it.podelstchikova.jd02_01.interfaces.UseShoppingCart;
import by.it.podelstchikova.jd02_01.utils.Helper;

import java.util.concurrent.TimeUnit;

public class Customer implements Runnable, CustomerInterface, UseShoppingCart {

    private int customerNumber;
    private Cart cart;
    private boolean isPensioner = false;
    private int minChooseTime = 500;
    private int maxChooseTime = 2000;
    private int minPutTime = 100;
    private int maxPutTime = 200;
    private boolean readyToCheckout = false;
    private boolean readyToGoOut = false;

    synchronized void setReadyToGoOut(boolean readyToGoOut) {
        this.readyToGoOut = readyToGoOut;
        notifyAll();
    }

    public Customer(int customerNumber){
        this.customerNumber = customerNumber;
        this.cart = new Cart();
    }

    public Customer(int customerNumber, boolean isPensioner){
        this(customerNumber);
        this.isPensioner = isPensioner;
        this.maxChooseTime *= 1.5;
        this.minChooseTime *= 1.5;
        this.minPutTime *= 1.5;
        this.maxPutTime *= 1.5;
    }

    public Cart getCart(){
        return this.cart;
    }

    @Override
    public void enterToMarket() {
        String pensioner = "";
        if (isPensioner)
            pensioner = "pensioner";
        System.out.println("Customer " + pensioner + " " + customerNumber + " has entered to the market");
    }

    @Override
    public void chooseGoods() {
        try {
            TimeUnit.MILLISECONDS.sleep(Helper.getRandomIntegerInRange(minChooseTime, maxChooseTime));
            System.out.println("Customer " + customerNumber + " is choosing goods");
            this.putGoodsToCart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goOut() {
        Market.incrementServedCustomers();
        System.out.println("Customer " + customerNumber + " has left the market");
    }

    @Override
    public void takeTheCart() {
        try{
            TimeUnit.MILLISECONDS.sleep(Helper.getRandomIntegerInRange(minPutTime, maxPutTime));
            System.out.println("Customer " + customerNumber + " has taken a cart");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToCart() {
        try{
            for (int j = Helper.getRandomIntegerInRange(1, 3); j < 4; j++){
                int goodNumber = Helper.getRandomIntegerInRange(0, 4);
                Good good = Good.fixedListOfGoods.get(goodNumber);
                cart.addGoods(good);
                TimeUnit.MILLISECONDS.sleep(Helper.getRandomIntegerInRange(minPutTime, maxPutTime));
                System.out.println("Customer " + customerNumber + " has put "
                        + good.getName() + " into the cart");
            }
            readyToCheckout = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToLine(){
        synchronized (this){
            System.out.println("Customer " + customerNumber + " made all purchases and going to the line");
            Market.addCustomerToLine(this);
        }
    }

    private synchronized void waitForService(){
        while (!readyToGoOut){
            //System.out.println("Customer " + customerNumber + " ждет выхода");
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString(){
        return "Customer " + customerNumber;
    }

    @Override
    public void run() {
        this.enterToMarket();
        Thread.yield();
        this.takeTheCart();
        Thread.yield();
        this.chooseGoods();
        Thread.yield();
        goToLine();
        waitForService();

        this.goOut();
    }
}
