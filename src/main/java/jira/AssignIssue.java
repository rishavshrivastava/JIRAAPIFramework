package jira;

import static io.restassured.RestAssured.given;

public class AssignIssue {

	public void assignIssue(String session, String issueid) {
		given().header("Cookie", session).header("Content-Type", "application/json")
		.body("{\r\n" + 
				"    \"name\": \"rishav.beee\"\r\n" + 
				"}")
		.when().put("/rest/api/2/issue/"+issueid+"/assignee")
		.then().log().all().statusCode(204);
	}
}
