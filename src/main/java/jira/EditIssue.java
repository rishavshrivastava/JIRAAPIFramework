package jira;

import static io.restassured.RestAssured.given;

public class EditIssue {

	public void addDescription(String session, String issueid) {
		given().header("Content-Type", "application/json").header("Cookie", session)
		.body("{\r\n" + 
				"  \"update\": {\r\n" + 
				"    \"summary\": [\r\n" + 
				"      {\r\n" + 
				"        \"set\": \"Bug in business logic\"\r\n" + 
				"      }\r\n" + 
				"    ],\r\n" + 
				"    \"description\": [\r\n" + 
				"      {\r\n" + 
				"        \"set\": \"It's a severe issue. Please fix it ASAP. You will need to pull or push the latest code and start the execution.\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"}")
		.when().put("/rest/api/2/issue/"+issueid)
		.then().log().all().statusCode(204);
	}
}
