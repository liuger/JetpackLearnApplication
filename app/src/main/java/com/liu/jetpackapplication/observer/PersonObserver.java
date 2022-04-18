package com.liu.jetpackapplication.observer;

import android.util.Log;


import java.util.Observable;
import java.util.Observer;

public class PersonObserver implements Observer {
    static final String TAG = PersonObserver.class.getSimpleName();
    String name;

    public void PersonObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.d(TAG, name + " 接收到通知啦 " + o);
    }
}
