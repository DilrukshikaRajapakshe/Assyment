package com.sliit.mtit.paymentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class dbServiceImpl implements DBService {
	
	private static final List<payment> paymentList = new ArrayList<>();
	
	public dbServiceImpl() {
		//payment data
		paymentList.add(new payment("P001", "S001", 10.12, 2, 20.24));
		paymentList.add(new payment("P002", "S002", 20.00, 2, 40.00));
		paymentList.add(new payment("P003", "S003", 30.10, 2, 60.20));
		paymentList.add(new payment("P004", "S004", 40.00, 2, 80.00));
		paymentList.add(new payment("P005", "S005", 50.00, 2, 100.00));
	}

	//insert
	@Override
	public void addPayament(payment p) {
		paymentList.add(p);
	}

	//delete
	@Override
	public List<payment> deletePayament(String id) {
		return paymentList.stream().map(p -> {
			if(p.getId().equals(id))
				paymentList.remove(p);
            return p;
        }).collect(Collectors.toList());
	}

	//All
	@Override
	public List<payment> findAllPayament() {
		
		return paymentList;
	}

	//Search
	@Override
	public payment findPayament(String id) {
		return (payment) paymentList.stream().filter(p -> p.getId().equals(id));
	}

	//update
	@Override
	public List<payment> updatePayment(payment p) {
		return paymentList.stream().map(pay -> {
			if(pay.getId().equals(p.getId()))
				pay.setPrice(p.getPrice());
				pay.setStockeID(p.getStockeID());
				pay.setTot(p.getTot());
				pay.setAmount(p.getAmount());
            return p;
        }).collect(Collectors.toList());
	}

}
