package com.sliit.mtit.paymentpublisher;

import java.util.ArrayList;
import java.util.List;

import com.sliit.mtit.paymentDatabase.DBService;
import com.sliit.mtit.paymentDatabase.dbServiceImpl;
import com.sliit.mtit.paymentDatabase.payment;

public class paymentpublisherServiceImpl implements paymentpublisherService {

	DBService service = new dbServiceImpl();
	
	@Override
	public String Insert(payment p) {
		System.out.println("----------------------------------");
		System.out.println(service.addPayament(p));
		System.out.println("----------------------------------");
		return service.addPayament(p);
	}

	@Override
	public payment find(String id) {
		payment p = new payment();
		p = service.findPayament(id);
		System.out.println("----------------------------------");
		System.out.println("Payment ID :" + p.getId());
		System.out.println("Stock ID :" + p.getStockeID());
		System.out.println("Price :" + p.getPrice() + "/RS");
		System.out.println("Amount :" + p.getAmount());
		System.out.println("Total :" + p.getTot());
		System.out.println("----------------------------------");
		return p;
	}

	@Override
	public String delete(String id) {
		System.out.println("----------------------------------");
		System.out.println(service.deletePayament(id));
		System.out.println("----------------------------------");
		return service.deletePayament(id);
	}

	@Override
	public String update(payment p) {
		System.out.println("----------------------------------");
		System.out.println(service.updatePayment(p));
		System.out.println("----------------------------------");
		return service.updatePayment(p);
	}

}
