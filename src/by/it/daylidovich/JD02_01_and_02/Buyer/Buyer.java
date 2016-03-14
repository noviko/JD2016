package by.it.daylidovich.JD02_01_and_02.Buyer;

import by.it.daylidovich.JD02_01_and_02.Goods.Goods;
import by.it.daylidovich.JD02_01_and_02.Queue.QueueBuyer;
import by.it.daylidovich.JD02_01_and_02.Utils.SleepTime;

import java.util.ArrayList;

import static by.it.daylidovich.JD02_01_and_02.Utils.RandomFromInterval.randomInterval;

public class Buyer extends Thread implements IBuyer, Runnable, IUseBacket {

    int numberBuyer;
    ArrayList<String> backet = new ArrayList<>();
    boolean pensioneer = false;
    public static boolean iWait = false;

    public ArrayList<String> getBacket() {
        return backet;
    }

    public Buyer(int numberBuyer){
        this.numberBuyer = numberBuyer;
        this.setName("Покупатель №" + numberBuyer);
        if (3 == randomInterval(1,4))
            pensioneer = true;
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goToExit();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин.");
    }

    @Override
    public void chooseGoods() {
        int countGoods = randomInterval(1,4);
        for (int i = 0; i < countGoods; i++) {
            String goods = Goods.randomGoods();
            backet.add(goods);
            putGoodsToBacket();
        }
        System.out.println(this + " совершил покупки.");
    }

    @Override
    public void takeBacket() {
        int timing = randomInterval(100,200);
        if (pensioneer)
            timing = (int)(timing *1.5);
        SleepTime.sleepTime(timing);
    }

    @Override
    public void putGoodsToBacket() {
        int timing = randomInterval(100,200);
        if (pensioneer)
            timing = (int)(timing *1.5);
        SleepTime.sleepTime(timing);
    }

    public synchronized void goToQueue(){
        QueueBuyer.addBuyer(this);
        iWait = true;
        while (iWait)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void goToExit() {
        System.out.println(this + " вышел из магазина.");
    }

    public String toString(){
        return this.getName();
    }
}
