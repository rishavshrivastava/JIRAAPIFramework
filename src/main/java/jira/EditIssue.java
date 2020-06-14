package jira;

import static io.restassured.RestAssured.given;

import payload.PayLoad;

public class EditIssue {

	public static void addDescription(String sessionid, String issueid) {
		given().header("Content-Type", "application/json").header("Cookie", sessionid)
		.body(PayLoad.editIssuePayload())
		.when().put("/rest/api/2/issue/"+issueid)
		.then().log().all().statusCode(204);
	}
}
