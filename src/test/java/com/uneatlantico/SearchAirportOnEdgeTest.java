package com.uneatlantico;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import junit.framework.TestCase;


public class SearchAirportOnEdgeTest {
  
  
  @Test
  public void comparingAirportsWithAnSelectedIATACode()  {
    Reader r = new Reader();
    ArrayList<Airport> airportes = null;
    try {
      airportes = r.readFileAirports();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    double latitude = 0.0;
    for(Airport a :  airportes) {
      if(a.getIataCode().contentEquals("VQS")) {
        latitude = a.getLatitude();
        break;
      }
    }
    
    assertEquals(18.115800857500002,latitude,0);
  }
  @Test 
  public void searchingAiportsInRouteByIATA() {
    Reader r = new Reader();
    ArrayList<Route> routes = null;
    String data = "";
    try {
      routes = r.readFileRoutes();
    }catch( IOException e) {
      e.printStackTrace();
    }
    for(Route ro : routes) {
      if(ro.getSourceAirportIATA().contentEquals("VQS")){
        data = ro.getSourceAirportID();
      }
    }
    
    assertEquals(data,"6788");
  }
  @Test
  public void searchingAirportInRouteByID() {
    Reader r = new Reader();
    ArrayList<Route> routes = null;
    String data = "";
    try {
      routes = r.readFileRoutes();
    }catch( IOException e) {
      e.printStackTrace();
    }
    for(Route ro : routes) {
      if(ro.getSourceAirportID().contentEquals("897")){
        data = ro.getSourceAirportIATA();
      }
    }
    
    assertEquals(data,"DLA");
  }
  @Test
  public void SearchAiportInRouteByAirportID() {
    Reader r = new Reader();
    ArrayList<Route> routes = null;
    ArrayList<Airport> airports = null;
    String data = "";
    try {
      routes = r.readFileRoutes();
      airports = r.readFileAirports();
    }catch( IOException e) {
      e.printStackTrace();
    }
    for(Airport a : airports) {
      if(a.getId().contentEquals(routes.get(0).getSourceAirportID())) {
        data = a.getIataCode();
      }
    }
    assertEquals(data,"AER");
  }
  @Test
  public void searchAirportInRoutesWhenIdIsNull() {
    Reader r = new Reader();
    ArrayList<Route> routes = null;
    ArrayList<Airport> airports = null;
    String data = "";
    try {
      routes = r.readFileRoutes();
      airports = r.readFileAirports();
    }catch( IOException e) {
      e.printStackTrace();
    }
    
    if(routes.get(38).getSourceAirportID().contentEquals("")) {
      for(Airport a:  airports) {
        if(a.getIataCode().contentEquals(routes.get(38).getSourceAirportIATA())) {
          data = a.getId();
        }
      }
    }
    
    assertEquals("6932", data);
  }
  @Test
  public void fillRoutesWithAirportsArrayList() {
    try {
      Reader r = new Reader();
      ArrayList<Route> routes = null;
      ArrayList<Airport> airports = null;
      airports = r.readFileAirports();
      routes = r.readFileRoutes(airports);
    }catch(IOException e) {
      e.printStackTrace();
    }
  }
}
