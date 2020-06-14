package jira;

import org.testng.annotations.Test;

import utility.Util;


public class TestJira extends Base {

	@Test(priority=1)
	public void createAndDeleteIssue() {
		CreateIssue.createNewIssue(Util.readFile(SessionID));
		DeleteIssue.deleteIssue(Util.readFile(SessionID), Util.readFile(IssueID));
	}
	
	@Test(priority=2)
	public void endToEndFlow() {
		CreateIssue.createNewIssue(Util.readFile(SessionID));
		AddComments.addComments(SessionID, IssueID);
		GetIssue.getIssue(SessionID, IssueID);
		EditIssue.addDescription(SessionID, IssueID);
		AssignIssue.assignIssue(SessionID, IssueID);
		AddComments.addComments(SessionID, IssueID);
		GetComment.getComment(SessionID, IssueID, CommentID);
		UpdateComment.updateComment(SessionID, IssueID, CommentID);
		DeleteComment.deleteComment(SessionID, IssueID, CommentID);
		AddAttachment.addAttachment(SessionID, IssueID);
		DeleteIssue.deleteIssue(Util.readFile(SessionID), Util.readFile(IssueID));
	}
}