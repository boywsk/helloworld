package com.osgi.helloworld;

import com.osgi.helloworld.service.Hello;
import com.osgi.helloworld.service.HelloImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshikai on 17/3/29.
 */
public class Activator implements BundleActivator {
    private List<ServiceRegistration> registrations = new ArrayList<ServiceRegistration>();

    private static BundleContext context;

    static BundleContext getContext() {
        return context;
    }
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        System.out.println("----------------hello server start---------------------");
        //注册hello接口中的服务
        registrations.add(bundleContext
                .registerService(Hello.class.getName(), new HelloImpl("Hello, OSGi"), null));
        System.out.println("----------------hello server start---------------------");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;

        for (ServiceRegistration registration : registrations) {
            System.out.println("unregistering: " + registration);
            registration.unregister();
        }
    }
}
