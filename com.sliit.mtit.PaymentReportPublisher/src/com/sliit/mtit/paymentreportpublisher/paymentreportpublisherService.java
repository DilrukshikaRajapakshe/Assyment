package com.sliit.mtit.paymentreportpublisher;

import java.util.List;

import com.sliit.mtit.paymentDatabase.payment;

public interface paymentreportpublisherService {
	public payment find(String id);
	public List<payment> findAll();
}	

