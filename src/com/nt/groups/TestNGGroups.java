package com.nt.groups;

import org.testng.annotations.Test;

public class TestNGGroups {
	@Test(groups={"sanity"})
	public void loginEmail() {
		System.out.println("login to email");
	}
	@Test(groups={"sanity"})
	public void loginFaceBook() {
		System.out.println("login to facebook");
	}
	@Test(groups={"sanity"})
	public void twitterloin() {
		System.out.println("login to twitter");
	}

}
