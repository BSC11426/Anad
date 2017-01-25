package com.pro;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class Sikulic {

	Screen screen = new Screen();
	Pattern image_SearchByTextBox = new Pattern("D:\\BUSINESS DATA\\Sikuli Images\\Create Capability\\Service.PNG");
	public void images() throws SikuliException{
	
	screen.wait(image_SearchByTextBox,15).click();
	screen.type("1007");
	}
	
	
	
}
