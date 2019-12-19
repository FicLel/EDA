package com.uneatlantico;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		r.readFileAirports();
		// System.out.println(r.readFileAirports());

//        Reader routes = new Reader();
//        System.out.println(routes.readFileRoutes());

	}
}
