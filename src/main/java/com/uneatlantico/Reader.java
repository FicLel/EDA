package com.uneatlantico;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;


public class Reader {
	public static final String SEPARATOR=",";
	public static final String QUOTE="\"";
	
	//lee el archivo de los aeropuertos
	public ArrayList<Airport> readFileAirports() throws IOException {
		BufferedReader lector = null; 
		String [] fields =null;
		ArrayList<Airport> airports = new ArrayList<Airport>();
		Airport newAirport = null;
		String str = null;
		try { 
			lector =new BufferedReader(new FileReader("Resources/airports.csv")); 
			String line = lector.readLine(); 
			while (null != line) { 
				fields = line.split(SEPARATOR); 
				
				newAirport = new Airport();
				newAirport.setId(fields[0]);
				newAirport.setName(fields[1]);
				newAirport.setCity(fields[2]);
				newAirport.setCountry(fields[3]);
				newAirport.setIataCode(fields[4]);
				newAirport.setOaciCode(fields[5]);
				str=fields[6];
  		   try {
  		     newAirport.setLatitude(Double.parseDouble(str));
  		        
  		   }catch (NumberFormatException e){
  		       
  		   } 
			   str=fields[7];
			   try {
           newAirport.setLongitude(Double.parseDouble(str));
           
         }catch (NumberFormatException e){
              
         }
			   str=fields[8];
			   try {
           newAirport.setAltitude(Double.parseDouble(str));
           
         }catch (NumberFormatException e){
              
         }
			   if(newAirport != null) {
			     airports.add(newAirport);
			   }
			   
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
		return airports;
	}
	
	//Reed the routes file
	public ArrayList<Route> readFileRoutes(ArrayList<Airport> airports) throws IOException {
		BufferedReader lector = null; 
		String [] fields = null;
		ArrayList<Route> routes = new ArrayList<Route>();
		Route newRoute = null;
		Airport newAirport = null;
		Airport newAirport2 = null;
		try { 
			lector =new BufferedReader(new FileReader("Resources/routes.csv")); 
			String line = lector.readLine(); 
			while (null != line) { 
				fields = line.split(SEPARATOR);
				newRoute = new Route();
				
				for(Airport airport : airports) {
			    if(fields[2].equals(airport.getIataCode())) {
            newAirport = airport;
            break;
          }
				}
				newRoute.setSourceAirport(newAirport);
        newRoute.setDestinationAirportID(newAirport.getId());
				for(Airport airport : airports) {
          if(fields[4].equals(airport.getIataCode())) {
            newAirport2 = airport;
            break;
          }
        }
				newRoute.setSourceAirport(newAirport2);
        newRoute.setDestinationAirportID(newAirport2.getId());
				newRoute.setPathWeight(newRoute.getSourceAirport().getLatitude(), newRoute.getDestinationAirport().getLatitude(), newRoute.getSourceAirport().getLongitude(), newRoute.getDestinationAirport().getLongitude());
				System.out.println(newRoute.getWeight());
				routes.add(newRoute);
				line = lector.readLine(); 
			} 
		} catch (Exception e) { 
		  e.printStackTrace();
		  System.out.println(e.getMessage());
		} finally { 
			if (null!=lector) { 
				try {
					lector.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				} 
			} 
		}
		return routes;
	}
}
