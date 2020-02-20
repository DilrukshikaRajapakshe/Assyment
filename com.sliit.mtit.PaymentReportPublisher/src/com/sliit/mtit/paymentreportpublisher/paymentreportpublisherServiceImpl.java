package com.sliit.mtit.paymentreportpublisher;

import java.util.ArrayList;
import java.util.List;

import com.sliit.mtit.paymentDatabase.DBService;
import com.sliit.mtit.paymentDatabase.dbServiceImpl;
import com.sliit.mtit.paymentDatabase.payment;

public class paymentreportpublisherServiceImpl implements paymentreportpublisherService {
	
	DBService service = new dbServiceImpl();
	
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
	public void findAll() {
		ArrayList<payment> list = (ArrayList<payment>) service.findAllPayament();
		list.stream().forEach(p ->{
			System.out.println("----------------------------------");
			System.out.println("Payment ID :" + p.getId());
			System.out.println("Stock ID :" + p.getStockeID());
			System.out.println("Price :" + p.getPrice() + "/RS");
			System.out.println("Amount :" + p.getAmount());
			System.out.println("Total :" + p.getTot());
			System.out.println("----------------------------------");
		});
	}
	

}
