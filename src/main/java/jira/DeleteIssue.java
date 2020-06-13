package jira;

import static io.restassured.RestAssured.given;

public class DeleteIssue {

	public static void deleteIssue(String session, String issueid) {
		given().header("cookie", session)
		.when().delete("rest/api/2/issue/"+issueid)
		.then().log().all().statusCode(204);
	}
}
