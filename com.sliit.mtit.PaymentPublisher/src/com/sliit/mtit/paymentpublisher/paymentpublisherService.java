package com.sliit.mtit.paymentpublisher;

import java.util.List;

import com.sliit.mtit.paymentDatabase.payment;

public interface paymentpublisherService {
	public String Insert(payment p);
	public payment find(String id);
	public String delete(String id);
	public String update(payment p);
}
