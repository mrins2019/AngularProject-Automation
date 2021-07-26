package com.projectAngularAppTests;

import org.testng.annotations.Test;
import com.genericLib.BaseLib;

public class ValidateAddNonImportantTask extends BaseLib {

	/*Test to validate the different pages in angular application after adding non-important task*/
	
	@Test(description="Scenario2: This test validates all pages after adding a non important task")
	public void validateAddNonImportantTaskTest() throws Exception{
		
		try{
			baseLogin();
			
			projectLib.validateLandingPage();
			int numberOfTasks = projectLib.validateAddNonImportantTask(2, false);
			projectLib.validateAllTasksPage(numberOfTasks);
			projectLib.validateImportantTasksPage(0);
			
			baseLogout();			
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception("The test failed, please check the logs...");
			
		}
	}
}

