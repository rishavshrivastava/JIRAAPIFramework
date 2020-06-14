package jira;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.PayLoad;
import utility.PathVariables;
import utility.Util;

public class Base implements PathVariables {
    
	@BeforeTest
	public void initializeURL() {
		RestAssured.baseURI=BaseURI;
		String response = given().body(PayLoad.createSessionPayload())
		.relaxedHTTPSValidation()
		.header("content-type", "application/json")
		.when().post("/rest/auth/1/session")
		.then().log().all().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(response);
		String str1 = js.getString("session.name");
		String str2 = js.getString("session.value");
		Util.putData(excelPath, sheetname, 1, 1, str1+"="+str2);
	}
}
