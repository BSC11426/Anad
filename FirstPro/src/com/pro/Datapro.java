package com.pro;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class Datapro {
	WebDriver d;
	Screen screen = new Screen();
	Pattern image_SearchByTextBox = new Pattern("D:\\BUSINESS DATA\\Sikuli Images\\Create Capability\\Service.PNG");
	Pattern image_SearchByTorch = new Pattern("D:\\BUSINESS DATA\\Sikuli Images\\Create Capability\\SelectDatatype.PNG");
	Pattern image_DatatypeName = new Pattern("D:\\BUSINESS DATA\\Sikuli Images\\Create Capability\\DatatypeName.PNG");
	Pattern image_Search = new Pattern("D:\\BUSINESS DATA\\Sikuli Images\\Create Capability\\Search.PNG");
	Pattern image_SelectCap = new Pattern("D:\\BUSINESS DATA\\Sikuli Images\\Create Capability\\selectCapability.PNG");
	Pattern image_Choose = new Pattern("D:\\BUSINESS DATA\\Sikuli Images\\Create Capability\\Choose.PNG");
	
	@Test(dataProvider="DP")
    public void Excelwrite(String C1, String C2, String C3, String C4) throws Exception{
    	System.out.println(C1+ "\t" +C2+ "\t" +C3+ "\t" +C4);
    	//System.out.println(C1+ "\t" +C2+ "\t" +C);
    	 
    	 d= new FirefoxDriver();
    			d.get("URL");
    			
    			//Login - user_name, Password & click on login		
    			d.findElement(By.xpath("//input[@id='c2']")).sendKeys(C1);
    			d.findElement(By.xpath("//input[@id='c3']")).sendKeys(C2);
    			d.findElement(By.xpath("//html[@dir='LTR']/body/center/table/tbody/tr[3]/td/font/input[1]")).click();
    			
    			//Browse Customers
    			d.findElement(By.xpath("//a[@id='form1:commandLink1']")).click();
    			
    			//Search company
    			d.findElement(By.xpath("//input[@id='inputText41']")).sendKeys(C3+"%");
    			d.findElement(By.xpath("//button[@id='commandButton12']")).click();
    			
    			Thread.sleep(3000);
    			//String Comp = d.findElement(By.xpath("//th[@id='table1:column4']")).getText();
    			
//    			for(int i=0;i<=10;i++){
    			
    			//String exp = "Bristlecone Atul";
    				
    				List<WebElement> ele = d.findElements(By.xpath(".//*[@id='table1']/table/tbody/tr[2]/td/table/tbody/tr/td[1]"));
    				for(int i=0 ;i<ele.size();i++){
    				int a = ele.size();
    				
    				System.out.println(a);
    				                                               
    				for(WebElement eles : ele){
    					
    					Thread.sleep(2000);
    					
    			String str= eles.getText();
    			
    			if (str.equals(C4)){
    				
    				System.out.println("MATCHED");
    			   
    				//Click on the desire company
    				d.findElement(By.linkText(C4)).click(); 
    	            d.findElement(By.xpath(".//*[@id='form1:panelPage1']/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr/td[7]/a")).click();
    	            String Parent_Window = d.getWindowHandle();
    	            System.out.println("Get handle" +Parent_Window);
    	            d.findElement(By.xpath("//button[@id='form1:table1:commandButton3']")).click();
    	            
    	            //switch to child window
    	            for (String Child_Window : d.getWindowHandles())  
    	            {  
    	            Thread.sleep(6000);	
    	            d.switchTo().window(Child_Window); 
    	            System.out.println("switch to child");
    	            Thread.sleep(6000);	
    	  
    	            
    	           
    	            
    	            
    	            System.out.println("child window " +Child_Window);
    	            //d.findElement(By.xpath(".//*[@id='form1:findService__xc_']/tbody/tr/td[3]/a/img")).click();
    	            screen.wait(image_SearchByTextBox,15).click();
    	        	screen.type("1007");
    	        	screen.wait(image_SearchByTorch,15).click();
    	        	screen.type("856");
    	        	screen.wait(image_DatatypeName,15).click();
    	        	screen.type("Standard NetSuite ASN > RSX ASN v7.6 (LEGACY SIP)");
    	        	screen.wait(image_Search,15).click();
    	        	screen.click();
    	        	screen.wait(image_SelectCap,15).click();
    	        	//screen.click();
    	        	screen.wait(image_Choose,15).click();
    	        	screen.click();
    	        	
    	        	
    			}
    			}
    			
    			else{
    				
    				System.out.println("Not matched");
    			}
    					
    					System.out.println(eles.getText());
    					
    				}
    				}
    				}
    			//	}
    				
    				
    		//	}
    			
    			
    			//System.out.println(Comp);
    			//System.out.println("matched");
    			//String Comname = C3;
    			//if(Comname.equals("//th[@id='table1:column4']"))
    		
	
	@DataProvider
	public Object[][] DP() throws Exception {
		
		File f = new File("D:\\PERSONAL DATA\\Book1.xls");
		Workbook wb = Workbook.getWorkbook(f);
	    Sheet s = wb.getSheet(0);
		int row = s.getRows();
		int col = s.getColumns();
		System.out.println(row);
		System.out.println(col);
		Object [][] data = new Object [row][col];
		for (int a=0 ; a<row ; a++){
			
			for (int b=0 ; b<col ; b++){
				
				data [a][b] = s.getCell(b,a).getContents();
			}
		}
		
		
		return data;	

	}
}
