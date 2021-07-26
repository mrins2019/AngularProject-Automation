package com.projectAngularAppTests;

import org.testng.annotations.Test;
import com.genericLib.BaseLib;

public class ValidateRemoveImportantTask extends BaseLib {

	/*Test to validate the different pages in angular application after removing important task*/
	
	@Test(description="Scenario3: This test validates all pages after removing an important task")
	public void validateRemoveImportantTaskTest() throws Exception{

		try{
			baseLogin();

			projectLib.validateLandingPage();
			projectLib.validateAddImportantTask(2, false);
			int numberOfLeftTasks = projectLib.validateRemoveExistingImportantTask(2);
			projectLib.validateAllTasksPage(numberOfLeftTasks);
			projectLib.validateImportantTasksPage(0);

			baseLogout();

		}catch(Exception e){

			e.printStackTrace();
			throw new Exception("The test failed, please check the logs...");

		}
	}
}

