package com.osgi.helloworld.service;

/**
 * Created by wangshikai on 17/3/29.
 */
public class HelloImpl implements Hello{
    private String what;
    public HelloImpl(String what) {
        this.what = what;
    }

    public String sayHello() {
        return "say:"+this.what;
    }
}
