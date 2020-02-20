package com.sliit.mtit.paymentreportpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.sliit.mtit.paymentDatabase.DBService;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Payment Report Publisher Started");
		serviceReference = bundleContext.getServiceReference(DBService.class.getName());
		DBService database = (DBService) bundleContext.getService(serviceReference);

		paymentreportpublisherService service = new paymentreportpublisherServiceImpl();
		serviceRegistration = bundleContext.registerService(paymentreportpublisherService.class.getName(), service, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(serviceReference);
		serviceRegistration.unregister();
		System.out.println("Payment Report Publisher Stopped");
	}

}
