package com.projectAngularAppTests;

import org.testng.annotations.Test;
import com.genericLib.BaseLib;

public class ValidateAddImportantAndNonImportantTask extends BaseLib {

	/*Test to validate the different pages in the angular application after adding both an important and non-important task*/
	
	@Test(description="Scenario5: This test validates all pages after adding both an important and non important task")
	public void validateAddImportantAndNonImportantTaskTest() throws Exception{

		try{
			baseLogin();

			projectLib.validateLandingPage();
			projectLib.validateAddImportantTask(2, false);
			int numberOfTasks = projectLib.validateAddNonImportantTask(3, false);
			projectLib.validateAllTasksPage(numberOfTasks);
			projectLib.validateImportantTasksPage(1);

			baseLogout();		

		}catch(Exception e){

			e.printStackTrace();
			throw new Exception("The test failed, please check the logs...");

		}
	}
}

