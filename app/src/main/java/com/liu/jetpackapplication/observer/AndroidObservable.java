package com.liu.jetpackapplication.observer;

import android.text.TextUtils;
import android.view.ViewGroup;

import java.util.Observable;

public class AndroidObservable extends Observable {
    public void postNewVersion(String version) {
        setChanged();//标示内容发生改变
        notifyObservers(version);//通知所有观察者
    }
}

