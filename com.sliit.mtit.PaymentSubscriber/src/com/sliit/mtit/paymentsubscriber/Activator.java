package com.sliit.mtit.paymentsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.mtit.paymentDatabase.payment;
import com.sliit.mtit.paymentpublisher.paymentpublisherService;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Payment Subcriber");
		serviceReference = bundleContext.getServiceReference(paymentpublisherService.class.getName());
		paymentpublisherService service = (paymentpublisherService) bundleContext.getService(serviceReference);
		int choice = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("-----------------------------------------");
		System.out.println("*****************************************\n");
		System.out.println("~~~~~~~~~~~~~~Payment Service~~~~~~~~~~~~\n");
		System.out.println("*****************************************\n");

		System.out.println("-1 - Exit the service");
		System.out.println("1 - Insert payment");
		System.out.println("2 - Search Payment");
		System.out.println("3 - Update payment");
		System.out.println("4 - Delete Payment\n");

		System.out.println("*****************************************");
		System.out.println("-----------------------------------------");
		System.out.println("Select one of the service :");
		choice = scan.nextInt();
		try {
			switch (choice) {
			case 1:
				System.out.println("---------- Enter Details -----------\n");

				System.out.println("Payment ID :");
				String id = scan.next();
				System.out.println("Test" + id);

				System.out.println("Stock ID :");
				String sid = scan.next();

				System.out.println("Price :");
				double price = scan.nextDouble();

				System.out.println("Amount :");
				int amount = scan.nextInt();

				System.out.println("Total :");
				double tot = scan.nextDouble();

				System.out.println("\n");
				System.out.println("----------------------------------");
				payment p = new payment(id, sid, price, amount, tot);
				service.Insert(p);
				break;
			case 2:
				System.out.println("Payment ID :");
				String pid = scan.next();
				service.find(pid);
				break;
			case 3:
				System.out.println("---------- Enter Update Details -----------\n");

				System.out.println("Payment ID :");
				String Uid = scan.next();

				System.out.println("Stock ID :");
				String Usid = scan.next();

				System.out.println("Price :");
				double Uprice = scan.nextDouble();

				System.out.println("Amount :");
				int Uamount = scan.nextInt();

				System.out.println("Total :");
				double Utot = scan.nextDouble();

				System.out.println("\n");
				System.out.println("----------------------------------");
				payment Up = new payment(Uid, Usid, Uprice, Uamount, Utot);
				service.update(Up);
				break;
			case 4:
				System.out.println("Payment ID :");
				String paid = scan.next();
				service.delete(paid);
				break;
			case -1:

				return;
			default:
				System.out.println("Plese select correct choice");
				System.out.println("-1 - Exit the service");
				System.out.println("1 - Insert payment");
				System.out.println("2 - Search Payment");
				System.out.println("3 - Update payment");
				System.out.println("4 - Delete Payment\n");
				choice = scan.nextInt();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(serviceReference);
		System.out.println("Payment Subscriber Ended");
	}

}
