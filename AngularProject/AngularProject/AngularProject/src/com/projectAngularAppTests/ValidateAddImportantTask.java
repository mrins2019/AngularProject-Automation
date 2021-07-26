package com.projectAngularAppTests;

import org.testng.annotations.Test;
import com.genericLib.BaseLib;

public class ValidateAddImportantTask extends BaseLib {

	/*Test to validate the different pages in the angular application after adding important task*/
	
	@Test(description="Scenario1: This test validates all pages after adding an important task")
	public void validateAddImportantTaskTest() throws Exception{

		try{
			baseLogin();

			projectLib.validateLandingPage();
			int numberOfTasks = projectLib.validateAddImportantTask(2, false);
			projectLib.validateAllTasksPage(numberOfTasks);
			projectLib.validateImportantTasksPage(1);

			baseLogout();

		}catch(Exception e){

			e.printStackTrace();
			throw new Exception("The test failed, please check the logs...");

		}
	}
}

