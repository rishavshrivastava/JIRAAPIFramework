package jira;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import utility.PathVariables;
import utility.Util;

public class AddComments implements PathVariables{
	
	public static void addComments(String session, String issueid) {
		String addcommentresponse = given().header("Cookie", session).header("Content-Type", "application/json")
		.body("{\r\n" + 
				"    \"body\": \"I have comment from API request\"\r\n" + 
				"}")
		.when().post("/rest/api/2/issue/"+issueid+"/comment")
		.then().log().all().statusCode(201).extract().asString();
		JsonPath jsonpath3 = new JsonPath(addcommentresponse);
		String commentid = jsonpath3.getString("id");
		Util.writeFile(commentid, CommentID);
	}
}
