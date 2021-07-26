package com.genericLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class GenericMethods {

	/*This method performs the key enter operation*/
	public void PressingEnter() throws AWTException{

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	/*This method performs the post key enter operation*/
	public void ReleasingEnter() throws AWTException{

		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
