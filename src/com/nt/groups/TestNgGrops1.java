package com.nt.groups;

import org.testng.annotations.Test;

public class TestNgGrops1 {
	@Test(groups= {"regrssion"})
	public void logoutEmail() {
	 System.out.println("logout to email");
	}
	@Test(groups= {"regrssion"})
	public void logoutFaceBook() {
		System.out.println("logout to facebook");
	}
	@Test(groups= {"regrssion"})
	public void twitterlogout() {
		System.out.println("logout to twitter");
	}
}
