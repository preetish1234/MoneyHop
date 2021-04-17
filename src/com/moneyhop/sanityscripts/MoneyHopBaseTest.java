package com.moneyhop.sanityscripts;


import com.moneyhop.utils.MoneyHopConstants;


public class MoneyHopBaseTest extends BaseTestWeb {

	public static String browserName = "";


	public static void lunchBrowsersetUp(String br) throws Exception {

		browserName = "";
		browserName = browserName + br;

		if (br.contains("chrome") || br.contains("firefox")) {

			launchWeb(MoneyHopConstants.OS, br);


		}

	}

}
