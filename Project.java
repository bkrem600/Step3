package projectsAndTeamMembersProgram;

import java.util.ArrayList;
import java.util.Arrays;

public class Project implements Comparable<Project> {
	
	private String title;
	private String startDate;
	private String endDate;
	private ArrayList<TeamMember> teamMembers = new ArrayList<>();
	
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
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public int getNumberMembers() {
		return this.teamMembers.size();
	}
	
	public void addTeamMember(TeamMember teamMember) {
		this.teamMembers.add(teamMember);
	}
	
	public Boolean removeTeamMember (TeamMember teamMember) {
		if (this.teamMembers.remove(teamMember)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void displayTeamMembers() {
		Arrays.sort(teamMembers.toArray());
		for (TeamMember teamMember: teamMembers) {
			System.out.println(teamMember.toString());
		}
	}
	
	public ArrayList<TeamMember> getTeamMembers() {
		return this.teamMembers;
	}
	}
