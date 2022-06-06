package com.qa.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CsvHelper {

	private static String[][] numbers = new String[1000][1000];

	public static String readStringData(int cellRow,int cellColumn,String path) throws IOException
	{
		File file = new File(path);
		
		if(file.exists()){
		 System.out.println("File Exists");
		}
		
		BufferedReader bufRdr;
		bufRdr = new BufferedReader(new FileReader(file));
		String line = null;

		int row = 0;
		while((line = bufRdr.readLine()) != null){
		    StringTokenizer st = new StringTokenizer(line,",");
		    int col=0;

		    while (st.hasMoreTokens()){
				try {
					numbers[row][col] = st.nextToken();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	col++;
		    }
		    System.out.println();
		    row++;
		    }
		bufRdr.close();
		
		return numbers[cellRow][cellColumn];
	}
}
