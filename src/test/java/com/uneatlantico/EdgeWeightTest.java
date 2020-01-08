package com.uneatlantico;

import org.junit.Test;
import junit.framework.TestCase;

public class EdgeWeightTest extends TestCase {
  @Test
  public void testEdgeWeight() {
    double lat1 = 43.462390;
    double lat2 = 40.416798;
    double long1 = -3.809984;
    double long2 = -3.703788;
    Route r = new Route();
    r.setPathWeight(lat1, lat2, long1, long2);
    double distance = r.getWeight();
    
    assertEquals(338.8, distance);
  }
}
