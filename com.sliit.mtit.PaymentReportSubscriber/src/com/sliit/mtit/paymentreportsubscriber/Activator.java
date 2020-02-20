package com.sliit.mtit.paymentreportsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.mtit.paymentDatabase.payment;
import com.sliit.mtit.paymentreportpublisher.paymentreportpublisherService;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started payment Subcriber");
		serviceReference = bundleContext.getServiceReference(paymentreportpublisherService.class.getName());
		paymentreportpublisherService service = (paymentreportpublisherService) bundleContext.getService(serviceReference);
		int choice = 0;
		
			System.out.println("-----------------------------------------");
			System.out.println("*****************************************\n");
			System.out.println("~~~~~~~~~~ Report Payment Service ~~~~~~~\n");
			System.out.println("*****************************************\n");
			
			System.out.println("-1 - Exit the service");
			System.out.println("1 - Find All payment");
			System.out.println("2 - Find One Payment\n");
			
			System.out.println("*****************************************");
			System.out.println("-----------------------------------------");
			System.out.println("Select one of the service :");
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();
			switch(choice) {
			  case 1:
				   service.findAll();  
			       break;
			  case 2:
				    System.out.println("Payment ID :");
					String pid = scan.next();
					service.find(pid);
					break;
			  case -1:
				  	return;
			  default:
				    System.out.println("Plese select correct choice");
				    System.out.println("-1 - Exit the service");
					System.out.println("1 - Find All payment");
					System.out.println("2 - Find One Payment\n");
					choice = scan.nextInt();
			  }			
	}

	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(serviceReference);
		System.out.println("Report Payment Subscriber Ended");
	}

}
