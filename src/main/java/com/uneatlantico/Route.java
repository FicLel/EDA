package com.uneatlantico;

import java.math.BigDecimal;
import java.math.MathContext;

public class Route {
  
  private Airport sourceAirport;
  private String sourceAirportID;
  private Airport destinationAirport;
  private String destinationAirportID;
  private double weight;
  
  public Airport getSourceAirport() {
    return sourceAirport;
  }

  public void setSourceAirport(Airport sourceAirport) {
    this.sourceAirport = sourceAirport;
  }

  public String getSourceAirportID() {
    return sourceAirportID;
  }

  public void setSourceAirportID(String sourceAirportID) {
    this.sourceAirportID = sourceAirportID;
  }

  public Airport getDestinationAirport() {
    return destinationAirport;
  }

  public void setDestinationAirport(Airport destinationAirport) {
    this.destinationAirport = destinationAirport;
  }

  public String getDestinationAirportID() {
    return destinationAirportID;
  }

  public void setDestinationAirportID(String destinationAirportID) {
    this.destinationAirportID = destinationAirportID;
  }



  
  /**
   * a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
   * c = 2 ⋅ atan2( √a, √(1−a) )
   * d = R (Diametro de la tierra en metros). * c
   * @param lat1 - Latitud del punto 1.
   * @param lat2 - Latitud del punto 2.
   * @param long1 - Longitud del punto 1.
   * @param long2 - Longitud del punto 2.
   * @return distance - La distancia entre los dos puntos.
   */
	public void setPathWeight(double lat1, double lat2, double long1, double long2) {
	  lat1 = Math.toRadians(lat1);
	  lat2 = Math.toRadians(lat2);
	  long1 = Math.toRadians(long1);
	  long2 = Math.toRadians(long2);
	  double deltaLat = lat2 - lat1;
	  double deltaLong = long2 - long1;

	  double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(deltaLong / 2) * Math.sin(deltaLong / 2);
	  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	  
	  double distance = 6371e3 * c;
	  
	  BigDecimal bd = new BigDecimal(distance);
    bd = bd.round(new MathContext(4));
	  
	  this.weight = (bd.doubleValue() / 1000);
	}
	public double getWeight() {
	  return this.weight;
	}
}
