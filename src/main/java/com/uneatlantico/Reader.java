package com.uneatlantico;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;


public class Reader {
	public static final String SEPARATOR=",";
	public static final String QUOTE="\"";
	/*
	 * While reading the CSV we found an issue in strings that contains a coma in between
	 * and we realized that replacing those separators without those extra coma we needed something more specific than
	 * just a "," and the best solution we've found was a Regular expression, We do not know how to built it, but there's a lot of
	 * crazy people on the Internet and there it is
	 * 
	 * */
	public static final String REGSEPARATOR = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
	
	//lee el archivo de los aeropuertos
	public ArrayList<Airport> readFileAirports() throws IOException {
		BufferedReader lector = null; 
		String [] fields = null;
		ArrayList<Airport> airports = new ArrayList<Airport>();
		Airport newAirport = null;
		String str = null;
		try { 
			lector = new BufferedReader(new FileReader("Resources/airports.csv")); 
			String line = lector.readLine(); 
			while (null != line) { 
				fields = line.split(REGSEPARATOR); 
				
				newAirport = new Airport();
				newAirport.setId(fields[0]);
				newAirport.setName(fields[1].replace("\"","").replaceAll("\\\\N",""));
				newAirport.setCity(fields[2].replace("\"","").replaceAll("\\\\N",""));
				newAirport.setCountry(fields[3].replace("\"","").replaceAll("\\\\N",""));
				newAirport.setIataCode(fields[4].replace("\"","").replaceAll("\\\\N",""));
				newAirport.setOaciCode(fields[5].replace("\"","").replaceAll("\\\\N",""));
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
	
	//Read route file without Airports 
	public ArrayList<Route> readFileRoutes() throws IOException{
	  BufferedReader lector = null; 
    String [] fields = null;
    ArrayList<Route> routes = new ArrayList<Route>();
    Route newRoute = null;
    Airport airport = null;
    try { 
      lector =new BufferedReader(new FileReader("Resources/routes.csv")); 
      String line = lector.readLine(); 
      while (null != line) { 
        fields = line.split(SEPARATOR);
        newRoute = new Route();
        newRoute.setSourceAirportIATA(fields[2].replace("\"","").replaceAll("\\\\N",""));
        newRoute.setSourceAirportID(fields[3].replace("\"","").replaceAll("\\\\N",""));
        newRoute.setDestinationAirportIATA(fields[4].replace("\"","").replaceAll("\\\\N",""));
        newRoute.setDestinationAirportID(fields[5].replace("\"","").replaceAll("\\\\N",""));
        
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
	
	
	/*
	 * We read routes and assign Aiports in base of an arraylist by bring
	 * @param ArrayList<Airport>
	 * 
	 * return ArrayList<Route>
	 */
	public ArrayList<Route> readFileRoutes(ArrayList<Airport> airports) throws IOException {
		BufferedReader lector = null; 
		String [] fields = null;
		ArrayList<Route> routes = new ArrayList<Route>();
		Route newRoute = null;
		Airport newAirport = null;
		try { 
			lector =new BufferedReader(new FileReader("Resources/routes.csv")); 
			String line = lector.readLine(); 
			while (null != line) { 
				fields = line.split(SEPARATOR);
				newRoute = new Route();
				
				newRoute.setSourceAirportIATA(fields[2].replace("\"","").replaceAll("\\\\N",""));
				newRoute.setSourceAirportID(fields[3].replace("\"","").replaceAll("\\\\N",""));
				
				if(newRoute.getSourceAirportID().equals("")) {
				  for(Airport airport : airports) {
	          if(newRoute.getSourceAirportIATA().equals(airport.getIataCode())) {
	            newRoute.setSourceAirport(airport);
	            System.out.println("Origen: "+newRoute.getSourceAirport().getId());
	            break;
	          }
	        }
				}
				else {
				  for(Airport airport : airports) {
            if(newRoute.getSourceAirportID().equals(airport.getId())) {
              newRoute.setSourceAirport(airport);
              System.out.println("Origen: "+newRoute.getSourceAirport().getId());
              break;
            }
          }
				}
				newRoute.setDestinationAirportIATA(fields[4].replace("\"","").replaceAll("\\\\N",""));
        newRoute.setDestinationAirportID(fields[5].replace("\"","").replaceAll("\\\\N",""));
        if(newRoute.getDestinationAirportID().equals("")) {
          for(Airport airport : airports) {
            if(newRoute.getDestinationAirportIATA().equals(airport.getIataCode())) {
              newRoute.setDestinationAirport(airport);
              System.out.println("Destino: "+newRoute.getDestinationAirport().getId());
              break;
            }
          }
        }else {
          for(Airport airport : airports) {
            if(newRoute.getDestinationAirportID().equals(airport.getId())) {
              newRoute.setDestinationAirport(airport);
              System.out.println("Destino: "+newRoute.getDestinationAirport().getId());
              break;
            }
          }
        }
				
        if(newRoute.getDestinationAirport() != null && newRoute.getSourceAirport() != null) {
          newRoute.setPathWeight(newRoute.getSourceAirport().getLatitude(), newRoute.getDestinationAirport().getLatitude(), newRoute.getSourceAirport().getLongitude(), newRoute.getDestinationAirport().getLongitude());
          //System.out.println("destino: "+newRoute.getSourceAirportIATA() + " " + newRoute.getSourceAirportID()+" Final: "+newRoute.getDestinationAirportIATA() + " " + newRoute.getDestinationAirportID());
          System.out.println(newRoute.getWeight());
          routes.add(newRoute);
        }
				
				
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
