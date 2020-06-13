package jira;

import org.testng.annotations.Test;

import utility.Util;


public class TestJira {

	@Test(priority=1)
	public void createIssue() {
		CreateIssue.createNewIssue(Util.readFile());
	}
	
	@Test(priority=2)
	public void deleteIssue() {
		System.out.println(Util.readFile());
	}
}