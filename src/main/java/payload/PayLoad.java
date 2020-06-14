package payload;

public class PayLoad {

	public static String createSessionPayload() {
		String createsessionpayload = "{ \"username\": \"rishav.beee\", \"password\": \"Pa$$w0rd1947\" }";
		return createsessionpayload;
	}
	
	public static String createIssuePayload() {
		String createissuepayload = "{\r\n" + 
				"	\"fields\":{\r\n" + 
				"		\"project\":{\r\n" + 
				"			\"key\": \"RES\"\r\n" + 
				"		},\r\n" + 
				"		\"summary\": \"Debit Card Defect\",\r\n" + 
				"		\"issuetype\":{\r\n" + 
				"			\"name\": \"Bug\"\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"}";
		return createissuepayload;
	}
	
	public static String assignIssuePayload() {
		String assignissuepayload = "{\r\n" + 
				"    \"name\": \"rishav.beee\"\r\n" + 
				"}";
		return assignissuepayload;
	}
	
	public static String deleteCommentPayload() {
		String deletecommentpayload = "{\r\n" + 
				"    \"body\": \"I am updating the comment from API request\"\r\n" + 
				"}";
		return deletecommentpayload;
	}
	
	public static String editIssuePayload() {
		String editissuepayload = "{\r\n" + 
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
				"}";
		return editissuepayload;
	}
	
	public static String updateCommentPayload() {
		String updatecommentpayload = "{\r\n" + 
				"    \"body\": \"I am updating the comment from API request\"\r\n" + 
				"}";
		return updatecommentpayload;
	}
}
