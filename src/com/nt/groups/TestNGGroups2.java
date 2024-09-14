package com.nt.groups;

import org.testng.annotations.Test;

public class TestNGGroups2 {
	@Test(groups= {"sanity","regrssion"})
	public void paymentRupay() {
		System.out.println("payment to rupeay");
	}
	@Test(groups= {"sanity","regrssion"})
	public void paymentVisa() {
		System.out.println("payment to visa");
	}
	
}
