package com.businessLib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.genericLib.Driver;
import com.genericLib.GenericMethods;
import com.genericLib.PropertiesLib;
import com.objectPageRepository.LandingHomePage;
import com.objectPageRepository.LoginPage;
import com.objectWidgetRepository.AddTaskWidget;

public class ProjectAngularAppCommonLib{

	LoginPage loginPage = null;
	LandingHomePage homePage = null;
	AddTaskWidget addTask = null;

	PropertiesLib propertiesLib = new PropertiesLib();
	GenericMethods genericLib = new GenericMethods();
	
	/*This method launches the chrome browser and navigates to the build angular application URL*/
	public void launchApplication() throws Exception{

		String chromeDriverPath = propertiesLib.getPropertiesData("ChromeDriverPath");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		String searchedText = propertiesLib.getPropertiesData("URL");
		Driver.driver.navigate().to(searchedText);
		Driver.driver.manage().window().fullscreen();
	}
	
	/*This method implicitly waits for certain time limit for the page to load*/
	public void loadPage() throws Exception{
		
		Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	/*This method retrieves the current system date*/
	public String getCurrentDate() throws Exception{
		
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
	    
	    return dateFormat.format(date);
	}

	/*This method performs application login operation*/
	public void loginToApplication() throws Exception{

		String userName = propertiesLib.getPropertiesData("Username");
		String passWord = propertiesLib.getPropertiesData("Password");

		loginPage = PageFactory.initElements(Driver.driver, LoginPage.class);

		loadPage();
		boolean isUserNameFieldDisplayed = loginPage.loginUserName().isDisplayed();
		Assert.assertTrue(isUserNameFieldDisplayed, "The username field is not displayed in the login page");
		loginPage.loginUserName().sendKeys(userName);

		boolean isPassWordFieldDisplayed = loginPage.loginPassWord().isDisplayed();	
		Assert.assertTrue(isPassWordFieldDisplayed, "The password field is not displayed in the login page");		
		loginPage.loginPassWord().sendKeys(passWord);

		genericLib.PressingEnter();
		genericLib.ReleasingEnter();
	}

	/*This method validates the landing page after application login operation*/
	public void validateLandingPage() throws Exception{

		homePage = PageFactory.initElements(Driver.driver, LandingHomePage.class);

		loadPage();
		boolean isLogoDisplayed = homePage.solnetLogo().isDisplayed();
		boolean isLogoContainerDisplayed = homePage.solnetLogoContainer().isDisplayed();

		Assert.assertTrue(isLogoDisplayed, "The solnet logo is not displayed in the landing home page");
		Assert.assertTrue(isLogoContainerDisplayed, "The solnet logo container is not displayed in the landing home page");
	}

	/*This method validates the 'My Day' page widgets for addition of non important task*/
	public int validateAddNonImportantTask(int expectedTaskCount, boolean isDueDateRequired) throws Exception{

		addTask = PageFactory.initElements(Driver.driver, AddTaskWidget.class);

		String testTitle = propertiesLib.getPropertiesData("Nonimp_test_title");
		String testDesc = propertiesLib.getPropertiesData("Nonimp_test_desc");

		loadPage();
		boolean isTaskTitleFieldDisplayed = addTask.TaskTitle().isDisplayed();
		Assert.assertTrue(isTaskTitleFieldDisplayed, "The Task Title field is not displayed in the landing home page");
		addTask.TaskTitle().sendKeys(testTitle);

		boolean isTaskDescFieldDisplayed = addTask.TaskDescription().isDisplayed();
		Assert.assertTrue(isTaskDescFieldDisplayed, "The Task Description field is not displayed in the landing home page");
		addTask.TaskDescription().sendKeys(testDesc);

		boolean isTaskDueDateFieldDisplayed = addTask.TaskDueDate().isDisplayed();
		boolean isDateIconDisplayed = addTask.DateIcon().isDisplayed();
		Assert.assertTrue(isTaskDueDateFieldDisplayed, "The Task Due Date field is not displayed in the landing home page");
		Assert.assertTrue(isDateIconDisplayed, "The Date Icon is not displayed in the landing home page");		
		
		boolean isImportantCheckboxDisplayed = addTask.ImportantCheckBox().isDisplayed();
		Assert.assertTrue(isImportantCheckboxDisplayed, "The Important check box is not displayed in the landing home page");
		String isImportantCheckboxChecked = addTask.ImportantCheckBox().getAttribute("aria-checked");
		Assert.assertEquals(isImportantCheckboxChecked, "false");

		boolean isAddTaskButtonDisplayed = addTask.AddTaskButton().isDisplayed();
		Assert.assertTrue(isAddTaskButtonDisplayed, "The Add Task Button is not displayed in the landing home page");
		
		if (isDueDateRequired){
			addTask.DateIcon().click();
			genericLib.PressingEnter();
			genericLib.ReleasingEnter();
		}else{
			addTask.AddTaskButton().click();
		}
		
		int numberOfTasksInMyDayPage = Driver.driver.findElements(By.className("mat-card-content")).size() - 1;
		Assert.assertEquals(numberOfTasksInMyDayPage, expectedTaskCount, "The count of number of tasks available is incorrect");
		
		Thread.sleep(3000);

		return numberOfTasksInMyDayPage;
	}

	/*This method validates the 'My Day' page widgets for addition of important task*/
	public int validateAddImportantTask(int expectedTaskCount, boolean isDueDateRequired) throws Exception{

		addTask = PageFactory.initElements(Driver.driver, AddTaskWidget.class);

		String testTitle = propertiesLib.getPropertiesData("Imp_test_title");
		String testDesc = propertiesLib.getPropertiesData("Imp_test_desc");

		loadPage();
		boolean isTaskTitleFieldDisplayed = addTask.TaskTitle().isDisplayed();
		Assert.assertTrue(isTaskTitleFieldDisplayed, "The Task Title field is not displayed in the landing home page");
		addTask.TaskTitle().sendKeys(testTitle);

		boolean isTaskDescFieldDisplayed = addTask.TaskDescription().isDisplayed();
		Assert.assertTrue(isTaskDescFieldDisplayed, "The Task Description field is not displayed in the landing home page");
		addTask.TaskDescription().sendKeys(testDesc);

		boolean isTaskDueDateFieldDisplayed = addTask.TaskDueDate().isDisplayed();
		boolean isDateIconDisplayed = addTask.DateIcon().isDisplayed();
		Assert.assertTrue(isTaskDueDateFieldDisplayed, "The Task Due Date field is not displayed in the landing home page");
		Assert.assertTrue(isDateIconDisplayed, "The Date Icon is not displayed in the landing home page");

		boolean isImportantCheckboxDisplayed = addTask.ImportantCheckBox().isDisplayed();
		Assert.assertTrue(isImportantCheckboxDisplayed, "The Important check box is not displayed in the landing home page");
		String isImportantCheckboxChecked = addTask.ImportantCheckBox().getAttribute("aria-checked");
		Assert.assertEquals(isImportantCheckboxChecked, "false");
		addTask.ImportantCheckBoxForClicking().click();

		boolean isAddTaskButtonDisplayed = addTask.AddTaskButton().isDisplayed();
		Assert.assertTrue(isAddTaskButtonDisplayed, "The Add Task Button is not displayed in the landing home page");
		
		if (isDueDateRequired){
			addTask.DateIcon().click();
			genericLib.PressingEnter();
			genericLib.ReleasingEnter();
		}else{
			addTask.AddTaskButton().click();
		}
		
		int numberOfTasksInMyDayPage = Driver.driver.findElements(By.className("mat-card-content")).size() - 1;
		Assert.assertEquals(numberOfTasksInMyDayPage, expectedTaskCount, "The count of number of tasks available is incorrect");

		Thread.sleep(3000);
		
		return numberOfTasksInMyDayPage;
	}

	/*This method validates the 'My Day' page widgets for removal of important task*/
	public int validateRemoveExistingImportantTask(int index) throws Exception{

		Driver.driver.findElements(By.className("mat-card-content")).get(index).findElement(By.cssSelector("mat-icon")).click();	
		Thread.sleep(5000);	
		loadPage();
		int numberOfLeftTasks = Driver.driver.findElements(By.className("mat-card-content")).size() - 1;

		return numberOfLeftTasks;
	}

	/*This method validates the 'My Day' page widgets for removal of non important task*/
	public int validateRemoveExistingNonImportantTask(int index) throws Exception{

		Driver.driver.findElements(By.className("mat-card-content")).get(index).findElement(By.cssSelector("mat-icon")).click();		
		Thread.sleep(5000);	
		loadPage();
		int numberOfLeftTasks = Driver.driver.findElements(By.className("mat-card-content")).size() - 1;

		return numberOfLeftTasks;
	}

	/*This method validates the 'All Tasks' page tasks*/
	public void validateAllTasksPage(int numberOfTasksInAllDayPage) throws Exception{

		Driver.driver.findElements(By.className("mat-list-item-content")).get(1).click();
		Thread.sleep(5000);
		loadPage();
		int numberOfTasks = Driver.driver.findElements(By.className("mat-card-content")).size();
		Assert.assertEquals(numberOfTasks, numberOfTasksInAllDayPage, "The count of tasks in 'All Tasks' page is incorrect");
	}

	/*This method validates the 'Important Tasks' page tasks*/
	public void validateImportantTasksPage(int numberOfTasksInImportantTasksPage) throws Exception{

		Driver.driver.findElements(By.className("mat-list-item-content")).get(2).click();
		Thread.sleep(5000);
		loadPage();
		int numberOfTasks = Driver.driver.findElements(By.className("mat-card-content")).size();
		Assert.assertEquals(numberOfTasks, numberOfTasksInImportantTasksPage, "The count of tasks in 'Important Tasks' page is incorrect");
		Driver.driver.findElements(By.className("mat-list-item-content")).get(0).click();
	}
}



