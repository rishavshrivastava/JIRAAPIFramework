package jira;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class GetComment {

	public static void getComment(String sessionid, String issueid, String commentid) {
		String commentresponse = given().header("Cookie", sessionid)
				.when().get("/rest/api/2/issue/"+issueid+"/comment/"+commentid)
				.then().statusCode(200).extract().response().asString();
				JsonPath jsonpath4 = new JsonPath(commentresponse);
				System.out.println("Getting Comment: "+jsonpath4.getString("body"));
	}
}
