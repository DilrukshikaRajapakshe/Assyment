package com.sliit.mtit.paymentDatabase;

import java.util.List;

public interface DBService {

	public String addPayament(payment p);
	public String deletePayament(String id);
	public List<payment> findAllPayament();
	public payment findPayament(String id);
	public String updatePayment(payment p);
}
