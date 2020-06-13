package pojo;

public class CreateIssueFields {

	private CreateIssueFieldsProjects project;
	private String summary;
	private String description;
	private CreateIssueFieldsIssueTypes issuetype;
	
	public CreateIssueFieldsProjects getProject() {
		return project;
	}
	public void setProject(CreateIssueFieldsProjects project) {
		this.project = project;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CreateIssueFieldsIssueTypes getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(CreateIssueFieldsIssueTypes issuetype) {
		this.issuetype = issuetype;
	}
}
