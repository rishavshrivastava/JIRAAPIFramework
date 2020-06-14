package jira;

import static io.restassured.RestAssured.given;

import java.io.File;

public class AddAttachment {

	public static void addAttachment(String sessionid, String issueid) {
		given().header("cookie", sessionid).header("X-Atlassian-Token", "no-check")
		.multiPart("file", new File("data//APIInputs.xlsx"))
		.when().post("rest/api/2/issue/"+issueid+"/attachments")
		.then().log().all().statusCode(200);
	}
}
