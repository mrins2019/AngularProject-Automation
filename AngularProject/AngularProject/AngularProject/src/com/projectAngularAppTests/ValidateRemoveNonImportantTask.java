package com.projectAngularAppTests;

import org.testng.annotations.Test;
import com.genericLib.BaseLib;

public class ValidateRemoveNonImportantTask extends BaseLib {

	/*Test to validate the different pages in angular application after removing non-important task*/
	
	@Test(description="Scenario4: This test validates all pages after removing a non important task")
	public void validateRemoveNonImportantTaskTest() throws Exception{

		try{
			baseLogin();

			projectLib.validateLandingPage();
			projectLib.validateAddNonImportantTask(2, false);
			int numberOfLeftTasks = projectLib.validateRemoveExistingNonImportantTask(1);
			projectLib.validateAllTasksPage(numberOfLeftTasks);
			projectLib.validateImportantTasksPage(0);

			baseLogout();

		}catch(Exception e){

			e.printStackTrace();
			throw new Exception("The test failed, please check the logs...");
			
		}
	}
}

