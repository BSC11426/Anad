package com.pro;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browser {
	
	WebDriver d = new FirefoxDriver();
	
	Datapro M1 = new Datapro();
	    //Login - user_name, Password & click on login		
		/*d.findElement(By.xpath("//input[@id='c2']")).sendKeys(C1);
		d.findElement(By.xpath("//input[@id='c3']")).sendKeys(C2);
		d.findElement(By.xpath("//html[@dir='LTR']/body/center/table/tbody/tr[3]/td/font/input[1]")).click();*/
	
	
	@Test(dataProvider="DP")
	public void login( String C1, String C2,String C3, String C4) throws Exception
	{  
  
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    	d.get("http://boon.mps.spscommerce.net:7777/sso/jsp/login.jsp?site2pstoretoken=v1.4~E1CED8E6~0DF4820B2A4E340FF9FB4B8614098E29C5991BF6BF374FBD3AA8D0E43CFB52370A41494874921FE16FA0E0E95EAC47188E2BAA3859FACF45CFC0F4FDBB054160A42227D80DA3245328B77B3FAB9E164B4E208E162C78DDCA859CB01B982D0108E01E91B6DCB6B30261A52E618FA48EB581015FB96C81FDC1B0D7D0595EE53465B3DB8614EAE9DA1028778AFD419A205FD20E578A3D736947371F8BA2C361DF3D035DE1E9986047AD16F4BF8154C381FC55042FFF9C4AA53739FD6E3E68EF575755BF4B945B58DFD3&p_error_code=&p_submit_url=http%3A%2F%2Fboon.mps.spscommerce.net%3A7777%2Fsso%2Fauth&p_cancel_url=http%3A%2F%2Fdc4ui.p01.ppd%3A7777&ssousername=");
    	d.findElement(By.xpath("//input[@id='c2']")).sendKeys(C1);
		d.findElement(By.xpath("//input[@id='c3']")).sendKeys(C2);
		d.findElement(By.xpath("//html[@dir='LTR']/body/center/table/tbody/tr[3]/td/font/input[1]")).click();
		
		//BrowseCust
		 d.findElement(By.xpath("//a[@id='form1:commandLink1']")).click();
		 
		 //Search_Copmany
		 d.findElement(By.xpath("//input[@id='inputText41']")).sendKeys(C3+"%");
			d.findElement(By.xpath("//button[@id='commandButton12']")).click();	
			Thread.sleep(3000);
			List<WebElement> ele = d.findElements(By.xpath(".//*[@id='table1']/table/tbody/tr[2]/td/table/tbody/tr/td[1]"));
			for(int i=0 ;i<ele.size();i++){
			int a = ele.size();
			
			System.out.println(a);
			                                               
			for(WebElement eles : ele){
				
				Thread.sleep(2000);
				
		String str= eles.getText();
		
		if (str.equals(C4)){
			
			System.out.println("MATCHED");
		    d.findElement(By.linkText(C4)).click(); 
	        	}
		
		else{
			
			System.out.println("Not matched");
		}
				
				System.out.println(eles.getText());
				
			}	
			}

	    }
    	
}
