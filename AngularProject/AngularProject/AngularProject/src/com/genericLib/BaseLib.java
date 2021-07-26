package com.genericLib;

import org.openqa.selenium.By;
import com.businessLib.ProjectAngularAppCommonLib;

public abstract class BaseLib {

	protected ProjectAngularAppCommonLib projectLib = new ProjectAngularAppCommonLib();

	/*This method performs application launch and login operations*/
	public void baseLogin() throws Exception{

		projectLib.launchApplication();
		projectLib.loginToApplication();		
	}

	/*This method performs logout from the application landing page*/
	public void baseLogout() throws Exception{

		Driver.driver.findElements(By.className("mat-button-wrapper")).get(1).click();
	}

	/*This method kills the driver objects*/
	public void closeDriver() throws Exception{

		Driver.driver.close();
		Driver.driver.quit();
	}
}
