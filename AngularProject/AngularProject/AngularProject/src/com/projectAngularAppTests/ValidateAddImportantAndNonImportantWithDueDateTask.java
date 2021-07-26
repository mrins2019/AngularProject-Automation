package com.projectAngularAppTests;

import org.testng.annotations.Test;
import com.genericLib.BaseLib;

public class ValidateAddImportantAndNonImportantWithDueDateTask extends BaseLib{
	
/*Test to validate the different pages in angular application after removing both a non-important and important task with due date*/
	
	@Test(description="Scenario7: This test validates all pages after adding both a non important and important task with due dates")
	public void validateAddImportantAndNonImportantTaskWithDueDateTest() throws Exception{

		try{
			baseLogin();

			projectLib.validateLandingPage();
			projectLib.validateAddNonImportantTask(2, true);
			int numberOfTasks = projectLib.validateAddImportantTask(3, true);
			projectLib.validateAllTasksPage(numberOfTasks);
			projectLib.validateImportantTasksPage(1);

			baseLogout();

		}catch(Exception e){

			e.printStackTrace();
			throw new Exception("The test failed, please check the logs...");
			
		}
	}
}
