package tests;

import org.testng.annotations.Test;

import pages.OrangeHRMPage.OrangeHRMPage;

public class SampleHRMTest extends TestBase{
		OrangeHRMPage orangeHRMPage = new OrangeHRMPage();
				
		@Test(groups = "Regression")
	    public void TC01() {
	            //loger("Step #1: ");
				orangeHRMPage.openHome();

				//loger("Step #2: ");
				orangeHRMPage.enterUserName("TestData1");

	            //("Step #3: Check for result");
				orangeHRMPage.verifyErrorMessageVisible();
	        }
}
