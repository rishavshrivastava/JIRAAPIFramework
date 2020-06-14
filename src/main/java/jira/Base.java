package jira;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utility.PathVariables;
import utility.Util;

public class Base implements PathVariables {
    
	@BeforeTest
	public void initializeURL() {
		RestAssured.baseURI="http://localhost:8080";
		
		Response response = given().body("{ \"username\": \"rishav.beee\", \"password\": \"Pa$$w0rd1947\" }")
		.relaxedHTTPSValidation()
		.header("content-type", "application/json")
		.when().post("/rest/auth/1/session")
		.then().log().all().statusCode(200).extract().response();
		Util.writeFile(response.getSessionId(), SessionID);
	}
}
