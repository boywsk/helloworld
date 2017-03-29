package com.osgi.helloworld.client;

import com.osgi.helloworld.service.Hello;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created by wangshikai on 17/3/29.
 */
public class Activator implements BundleActivator{
    public void start(BundleContext ctx) {
        System.out.println("----------------hello client start---------------------");
        ServiceReference ref = ctx.getServiceReference(Hello.class.getName());
        if (ref != null) {
            Hello hello = null;
            try {
                hello = (Hello) ctx.getService(ref);
                if (hello != null){
                    String say = hello.sayHello();
                    System.out.println(say);
                }
                else{
                    System.out.println("Service:Hello---object null");
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            } finally {
                ctx.ungetService(ref);
                hello = null;
            }
        } else {
            System.out.println("Service:Hello---not exists");
        }
        System.out.println("----------------hello client start---------------------");
    }

    public void stop(BundleContext ctx) throws Exception {

    }
}
