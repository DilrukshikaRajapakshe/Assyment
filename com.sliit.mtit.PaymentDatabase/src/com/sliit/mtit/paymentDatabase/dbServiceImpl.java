package com.sliit.mtit.paymentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dbServiceImpl implements DBService {
	
	private static final List<payment> paymentList = new ArrayList<>();
	
	
	public void add() {
		paymentList.add(new payment("P001", "S001", 10.12, 2, 20.24));
		paymentList.add(new payment("P002", "S002", 20.00, 2, 40.00));
		paymentList.add(new payment("P003", "S003", 30.10, 2, 60.20));
		paymentList.add(new payment("P004", "S004", 40.00, 2, 80.00));
		paymentList.add(new payment("P005", "S005", 50.00, 2, 100.00));
	}

	//insert
	@Override
	public String addPayament(payment p) {
		add();
		int size = paymentList.size();
		paymentList.add(p);
		if(paymentList.size() == size)
			return "Payment Data Insert not successful";
		return "Payment Data Insert successful";
	}

	//delete
	@Override
	public String deletePayament(String id) {
		add();
		if (paymentList.removeIf(payment -> payment.getId().equals(id))) {
			return "Deleted Successfully";
		} else {
			return "Delete Not Successfully. Payment ID : " + id;
		}
	}

	//All
	@Override
	public List<payment> findAllPayament() {
		add();
		return paymentList;
	}

	//Search
	@Override
	public payment findPayament(String id) {
		add();
		payment p1 = new payment();
		paymentList
				  .stream()
				  .forEach(p -> {
				      if( p.getId().equals(id)) {
				    	p1.setId(id);
				    	p1.setStockeID(p.getStockeID());
				    	p1.setPrice(p.getPrice());
				    	p1.setAmount(p.getAmount());
				    	p1.setTot(p.getTot());
				    		  
				      }
		});
		return p1;
	}

	//update
	@Override
	public String updatePayment(payment p) {
		add();
		String result = null;
		for(int a=0; a < paymentList.size(); a++ ) {
			payment pay = paymentList.get(a);
//			System.out.println(pay);
			if(pay.getId().equals(p.getId())) {
				pay.setPrice(p.getPrice());
				pay.setStockeID(p.getStockeID());
				pay.setTot(p.getTot());
				pay.setAmount(p.getAmount());
				result = "Update successful";
			}
        }
		return result;
	}

}
