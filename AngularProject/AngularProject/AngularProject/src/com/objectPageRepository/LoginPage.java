package com.objectPageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id="mat-input-0")
	private WebElement userName;
	
	@FindBy(id="mat-input-1")
	private WebElement passWord;

	public WebElement loginUserName() {
		return userName;
	}
	
	public WebElement loginPassWord(){
		return passWord;
	}
}
