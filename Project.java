package projectsAndTeamMembersProgram;

public class Project implements Comparable<Project> {
	
	private String title;
	private String startDate;
	private String endDate;
	
	public String toString() {
		String projectDetails = new String();
		projectDetails += "Project Title" + "\t" + "\t" + "\t" + this.title + "\n"
				+ "Expected start/end dates" + "\t" + this.startDate + " - "
				+ this.endDate;
		return projectDetails;
	}
	
	public int compareTo(Project project) {
		return Integer.compare(this.title.compareTo(project.title), 0);
	}
	
	public Project (String title, String startDate, String endDate) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	}
