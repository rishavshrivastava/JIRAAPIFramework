package jira;

import static io.restassured.RestAssured.given;

import payload.PayLoad;

public class AssignIssue {

	public static void assignIssue(String session, String issueid) {
		given().header("Cookie", session).header("Content-Type", "application/json")
		.body(PayLoad.assignIssuePayload())
		.when().put("/rest/api/2/issue/"+issueid+"/assignee")
		.then().log().all().statusCode(204);
	}
}
