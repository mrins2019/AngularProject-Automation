package com.objectPageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingHomePage {

	@FindBy(className="mat-drawer-inner-container")
	private WebElement SolnetLogoContainer;
	
	@FindBy(className="sidenav-logo-container")
	private WebElement SolnetLogo;
		
	public WebElement solnetLogoContainer() {
		return SolnetLogoContainer;
	}
	
	public WebElement solnetLogo(){
		return SolnetLogo;
	}
}
