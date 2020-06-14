package jira;

import static io.restassured.RestAssured.given;

public class GetIssue {

	public static void getIssue(String session, String issueid) {
		given().header("cookie", session).header("content-type", "application/json")
		.when().get("/rest/api/2/issue/"+issueid)
		.then().log().all().statusCode(200).extract().response();
	}
}
