import java.util.ArrayList;
import java.util.Arrays;

public class Project implements Comparable<Project> {

	private String title, startDate, endDate;
	private ArrayList<TeamMember> teamMembers = new ArrayList<>();

	public Project(String title, String startDate, String endDate) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		StringBuilder projectDetails = new StringBuilder(title + " (" + startDate + " - " + endDate + ")");
		if (teamMembers.isEmpty()) {
			projectDetails.append("\t\t No Members");
		} else {
			projectDetails.append("\t\t");
			for (TeamMember teamMember : teamMembers) {
				projectDetails.append(" ").append(teamMember.toString());
			}
		}
		return projectDetails.toString();
	}

	@Override
	public int compareTo(Project project) {
		return this.title.compareTo(project.title);
	}

	@Override
	public boolean equals(Object object) {
		try {
			return this.title.equals(((Project) object).title);
		} catch (Exception exception) {
			return false;
		}
	}

	public void addTeamMember(TeamMember teamMember) {
		this.teamMembers.add(teamMember);
	}

	public void removeTeamMember(TeamMember teamMember) {
		if (this.teamMembers.remove(teamMember)) {
			System.out.println("The team member " + '"' + teamMember.getName() + '"' + " has been removed");
		} else {
			System.out.println("The team member " + '"' + teamMember.getName() + '"' + " could not be found");
		}
	}

	public void displayTeamMembers() {
		Arrays.sort(teamMembers.toArray());
		for (TeamMember teamMember: teamMembers) {
			System.out.println(teamMember.toString());
		}
	}

}
