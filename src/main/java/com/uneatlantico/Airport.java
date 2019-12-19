package com.uneatlantico;

import java.util.ArrayList;

public class Airport {
	private String id;
  private String name;
	private String country;
	private String city;
	private String oaciCode;
	private String iataCode;
	private double latitude;
	private double longitude;
	private double altitude;
	private double timeZone;
	public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getOaciCode() {
    return oaciCode;
  }
  public void setOaciCode(String oaciCode) {
    this.oaciCode = oaciCode;
  }
  public String getIataCode() {
    return iataCode;
  }
  public void setIataCode(String iataCode) {
    this.iataCode = iataCode;
  }
  public double getLatitude() {
    return latitude;
  }
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
  public double getLongitude() {
    return longitude;
  }
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
  public double getAltitude() {
    return altitude;
  }
  public void setAltitude(double altitude) {
    this.altitude = altitude;
  }
  public double getTimeZone() {
    return timeZone;
  }
  public void setTimeZone(double timeZone) {
    this.timeZone = timeZone;
  }
}
