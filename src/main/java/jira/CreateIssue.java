package jira;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import utility.PathVariables;
import utility.Util;

public class CreateIssue implements PathVariables{

	public static void createNewIssue(String session) {
		String createissueresponse = given()
		.header("cookie", "JSESSIONID="+session)
		.header("content-type", "application/json")
		.body("{\r\n" + 
				"	\"fields\":{\r\n" + 
				"		\"project\":{\r\n" + 
				"			\"key\": \"RES\"\r\n" + 
				"		},\r\n" + 
				"		\"summary\": \"Debit Card Defect\",\r\n" + 
				"		\"issuetype\":{\r\n" + 
				"			\"name\": \"Bug\"\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"}")
		.when().post("/rest/api/2/issue").then().log().all().statusCode(201).extract().asString();
		JsonPath jsonpath2 = new JsonPath(createissueresponse);
		String issueid = jsonpath2.getString("id");
		Util.writeFile(issueid, IssueID);
	}
}
