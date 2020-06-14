package jira;

import java.util.ArrayList;

import org.testng.annotations.Test;

import utility.Util;


public class TestJira extends Base {

	@Test(priority=1)
	public void createAndDeleteIssue() {
		ArrayList<String> sessionid = Util.getData(excelPath, sheetname, "SessionID");		
		CreateIssue.createNewIssue(sessionid.get(1));

		ArrayList<String> issueid = Util.getData(excelPath, sheetname, "IssueID");
		DeleteIssue.deleteIssue(sessionid.get(1), issueid.get(1));
	}
	
	@Test(priority=2)
	public void endToEndFlow() {
		ArrayList<String> sessionid = Util.getData(excelPath, sheetname, "SessionID");
		CreateIssue.createNewIssue(sessionid.get(1));
		
		ArrayList<String> issueid = Util.getData(excelPath, sheetname, "IssueID");
		AddComments.addComments(sessionid.get(1), issueid.get(1));
		
		GetIssue.getIssue(sessionid.get(1), issueid.get(1));
		
		EditIssue.addDescription(sessionid.get(1), issueid.get(1));
		
		AssignIssue.assignIssue(sessionid.get(1), issueid.get(1));
		
		AddComments.addComments(sessionid.get(1), issueid.get(1));
		
		ArrayList<String> commentid = Util.getData(excelPath, sheetname, "CommentID");
		GetComment.getComment(sessionid.get(1), issueid.get(1), commentid.get(1));
		
		UpdateComment.updateComment(sessionid.get(1), issueid.get(1), commentid.get(1));
		
		DeleteComment.deleteComment(sessionid.get(1), issueid.get(1), commentid.get(1));
		
		AddAttachment.addAttachment(sessionid.get(1), issueid.get(1));
		
		DeleteIssue.deleteIssue(sessionid.get(1), issueid.get(1));
	}
}