package com.objectWidgetRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTaskWidget {
	
	@FindBy(id="addTask")
	private WebElement AddTaskButton;
	
	@FindBy(id="mat-input-2")
	private WebElement TaskTitle;
	
	@FindBy(id="mat-input-3")
	private WebElement TaskDescription;
	
	@FindBy(id="mat-input-4")
	private WebElement TaskDueDate;
	
	@FindBy(className="mat-datepicker-toggle")
	private WebElement DateIcon;
	
	@FindBy(id="mat-checkbox-1-input")
	private WebElement ImportantCheckBox;
	
	@FindBy(className="mat-checkbox-label")
	private WebElement ImportantCheckBoxForClicking;
	

	public WebElement AddTaskButton() {
		return AddTaskButton;
	}
	
	public WebElement TaskTitle(){
		return TaskTitle;
	}
	
	public WebElement TaskDescription(){
		return TaskDescription;
	}
	
	public WebElement TaskDueDate(){
		return TaskDueDate;
	}
	
	public WebElement DateIcon(){
		return DateIcon;
	}
	
	public WebElement ImportantCheckBox(){
		return ImportantCheckBox;
	}
	
	public WebElement ImportantCheckBoxForClicking(){
		return ImportantCheckBoxForClicking;
	}
}
