package com.sliit.mtit.paymentDatabase;

import java.util.List;

public interface DBService {

	public void addPayament(payment p);
	public List<payment> deletePayament(String id);
	public List<payment> findAllPayament();
	public payment findPayament(String id);
	public List<payment> updatePayment(payment p);
}