package projectsAndTeamMembersProgram;

public class Company {
	private String name;
	private Tree<Project> projects = new Tree<>();
	
	public Company(String name) {
		this.name = name;
	}
	
	public void addProject (Project project) {
		this.projects.add(project);
	}
	
	public void removeProject(TreeNode project) {
		this.projects.remove(project);
	}
	
	public void addTeamMember(Project project, TeamMember teamMember) {
		project.addTeamMember(teamMember);
	}
	
	public void removeTeamMember(Project project, TeamMember teamMember) {
		project.removeTeamMember(teamMember);
	}
	
	public void displayTeamMembers(Project project) {
		for (TeamMember teamMember: project.getTeamMembers()) {
			System.out.println(teamMember.toString());
		}
	}
	
	public void displayAll() {
		projects.inOrderTraversal();
	}

}
