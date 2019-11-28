package com.uneatlantico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Reader {
	public static final String SEPARATOR=",";
	public static final String QUOTE="\"";
	
	//Read the airports file
	public String[] readFileAirports() throws IOException {
		BufferedReader lector = null; 
		String [] fields =null;
		
		try { 
			lector =new BufferedReader(new FileReader("Resources/airports.csv"));
			String line;
			int count = 0;
			while ((line = lector.readLine()) !=null) {  //while there are lines
				fields = line.split(SEPARATOR);  //slip every line with a ,
				System.out.println(fields[1]); //prints only the first column of each row
				count = count +1; //counter that for each iteration adds 1
				if (count >=10 ) {
					break;  //stops on the tenth time 
				}
				// System.out.println(Arrays.toString(fields));  
				// line = lector.readLine(); 
			} 
		} catch (Exception e) { 
			System.out.println(e); 
		} finally { 
			if (null!=lector) { 
				try {
					lector.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} 
		}
		return fields;
	}
	
	//Reed the routes file
	public String[] readFileRoutes() throws IOException {
		BufferedReader lector = null; 
		String [] fields = null;
		
		try { 
			lector =new BufferedReader(new FileReader("Resources/routes.csv")); 
			String line = lector.readLine(); 
			while (null != line) { 
				fields = line.split(SEPARATOR); 
				System.out.println(Arrays.toString(fields));  
				line = lector.readLine(); 
			} 
		} catch (Exception e) { 
			System.out.println(e); 
		} finally { 
			if (null!=lector) { 
				try {
					lector.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} 
		}
		return fields;
	}
	
}

