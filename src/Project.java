import java.util.ArrayList;

public class Project implements Comparable<Project> {

	private String title, startDate, endDate;
	private ArrayList<TeamMember> teamMembers = new ArrayList<>();

	public Project(String title, String startDate, String endDate) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String toString() {
		return title + " (" + startDate + " - " + endDate + ")";
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
		this.teamMembers.remove(teamMember);
	}

	public TeamMember findTeamMember(String name) {
		for (TeamMember teamMember: teamMembers) {
			if (teamMember.getName().equalsIgnoreCase(name))
				return teamMember;
		}
		return null;
	}

	public String getTitle() {
		return title;
	}

	public int getTeamSize(){
		return this.teamMembers.size();
	}

	public ArrayList<TeamMember> getTeamMembers() {
		return teamMembers;
	}

}
