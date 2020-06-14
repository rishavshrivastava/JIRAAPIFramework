package jira;

import org.testng.annotations.Test;

import utility.Util;


public class TestJira extends Base {

	@Test(priority=1)
	public void createIssue() {
		CreateIssue.createNewIssue(Util.readFile(SessionID));
	}
	
	@Test(priority=2)
	public void deleteIssue() {
		DeleteIssue.deleteIssue(Util.readFile(SessionID), Util.readFile(IssueID));
	}
}