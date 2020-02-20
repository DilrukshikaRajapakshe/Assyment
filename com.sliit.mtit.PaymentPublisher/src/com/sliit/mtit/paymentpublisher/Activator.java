package com.sliit.mtit.paymentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.sliit.mtit.paymentDatabase.DBService;
import com.sliit.mtit.paymentDatabase.dbServiceImpl;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReference;
	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Payment Publisher Started");
		serviceReference = bundleContext.getServiceReference(DBService.class.getName());
		DBService database = (DBService) bundleContext.getService(serviceReference);

		paymentpublisherService service = new paymentpublisherServiceImpl();
		serviceRegistration = bundleContext.registerService(paymentpublisherService.class.getName(), service, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(serviceReference);
		serviceRegistration.unregister();
		System.out.println("Payment Publisher Stopped");
	}

}
