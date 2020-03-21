package projectsAndTeamMembersProgram;

import java.util.LinkedList;

public class Company {
	TreeNode masterTree;
	TreeNode projectTree;
	private LinkedList<Project> projects = new LinkedList<>();
	
	public Company() {
		masterTree = new TreeNode("Test");
		projectTree = new TreeNode("Test");
	}
	
	public void addProject (Project project) {
		this.projects.add(project);
	}
	
	public Project findProject (String s) {
		for (Project project: projects) {
			if (project.getTitle().equalsIgnoreCase(s)) {
				return project;
			}
		}
		return null;
	}

}
