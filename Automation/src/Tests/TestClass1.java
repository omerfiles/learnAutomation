package Tests;

import org.junit.Test;
import org.openqa.selenium.By;

import Interfaces.TestCaseParams;

public class TestClass1 extends BasicTest{
	
	
	
	@Test
	@TestCaseParams(testCaseID = "1",browser="chrome")
	public void testOpenBrowserChrome()throws Exception{
		webDriver.openUrl("http://www.israelpost.co.il");
		
	}
	
	@Test
	@TestCaseParams(testCaseID = "2",browser="firefox")
	public void testOpenBrowserFirefox()throws Exception{
		webDriver.openUrl("http://www.israelpost.co.il");
		
	}

}
