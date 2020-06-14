package jira;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import payload.PayLoad;
import utility.PathVariables;
import utility.Util;

public class CreateIssue implements PathVariables{

	public static void createNewIssue(String sessionid) {
		String createissueresponse = given()
		.header("cookie", sessionid)
		.header("content-type", "application/json")
		.body(PayLoad.createIssuePayload())
		.when().post("/rest/api/2/issue").then().log().all().statusCode(201).extract().asString();
		JsonPath jsonpath = new JsonPath(createissueresponse);
		String issueid = jsonpath.getString("id");
		Util.putData(excelPath, sheetname, 2, 1, issueid);
	}
}
