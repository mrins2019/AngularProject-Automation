package com.projectAngularAppTests;

import org.testng.annotations.Test;
import com.genericLib.BaseLib;

public class ValidateRemoveImportantAndNonImportantTask extends BaseLib {

	/*Test to validate the different pages in angular application after removing both a non-important and important task*/
	
	@Test(description="Scenario6: This test validates all pages after removing both a non important and important task")
	public void validateRemoveImportantAndNonImportantTaskTest() throws Exception{

		try{
			baseLogin();

			projectLib.validateLandingPage();
			projectLib.validateAddNonImportantTask(2, false);
			projectLib.validateAddImportantTask(3, false);
			projectLib.validateRemoveExistingNonImportantTask(1);
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

