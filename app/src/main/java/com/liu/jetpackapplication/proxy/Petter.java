package com.liu.jetpackapplication.proxy;

import android.util.Log;

public class Petter implements ProxyInterface {
    private static final String TAG = Petter.class.getSimpleName();


    @Override
    public void choiceBetterHouse() {
        Log.d(TAG, "挑选优质房子");
    }

    @Override
    public void buyHouse() {
        Log.d(TAG, "买房子");
    }
}
