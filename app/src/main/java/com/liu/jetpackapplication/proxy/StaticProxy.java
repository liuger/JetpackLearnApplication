package com.liu.jetpackapplication.proxy;

public class StaticProxy implements ProxyInterface {
    private Petter petter;

    public StaticProxy(Petter petter) {
        this.petter = petter;
    }

    @Override
    public void choiceBetterHouse() {
        petter.choiceBetterHouse();
    }

    @Override
    public void buyHouse() {
        petter.buyHouse();

    }
}
