package testNGDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	@BeforeClass
	public void Abc() {
		System.out.println("Before Class ");
	}
	@AfterClass
	public void Ab() {
		System.out.println("after Class ");
	}
	@BeforeMethod
	public void A() {
		System.out.println("BeforeMethod ");
	}
	@AfterMethod
	public void b() {
		System.out.println("After Method");
	}
	@Test
	public void Ac() {
		System.out.println("Test Method ");
	}
	@Test
	public void cb() {
		System.out.println("Test Method ");
	}
	
	

}
