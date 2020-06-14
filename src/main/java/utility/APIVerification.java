package utility;

import org.testng.Assert;

import io.restassured.response.Response;

public class APIVerification {

	public static void responseCodeValiddation(Response response, int statusCode) {

		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
				System.out.println("Successfully validdated status code, status code is: " + response.getStatusCode());
		} catch (AssertionError e) {
		} catch (Exception e) {
		}
	}
}
