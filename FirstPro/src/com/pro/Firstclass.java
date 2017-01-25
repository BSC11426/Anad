package com.pro;

import java.io.File;
import java.io.IOException;



import jxl.Sheet;
import jxl.Workbook;

public class Firstclass {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
	
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
	
	}
}

