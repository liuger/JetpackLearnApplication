package com.liu.jetpackapplication.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private static final String TAG = DynamicProxy.class.getSimpleName();
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.d(TAG,"invoke");
        Object result = method.invoke(object,args);
        Petter petter = new Petter();
        // 返回一个代理对象
        ProxyInterface proxyPetter = (ProxyInterface) Proxy.newProxyInstance(
                petter.getClass().getClassLoader(),
                petter.getClass().getInterfaces(),
                new DynamicProxy(petter));
        proxyPetter.choiceBetterHouse();
        proxyPetter.buyHouse();
        return result;
    }

}
