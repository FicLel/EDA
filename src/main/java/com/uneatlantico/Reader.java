package com.uneatlantico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Reader {
	public static final String SEPARATOR=",";
	public static final String QUOTE="\"";
	public void readFile() throws IOException {
		BufferedReader lector = null; 
		try { 
			lector =new BufferedReader(new FileReader("Resources/airports.csv")); 
			String line = lector.readLine(); 
			while (null != line) { 
				String [] fields = line.split(SEPARATOR); 
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
	}
	
}

