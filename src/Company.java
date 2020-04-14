import java.util.ArrayList;

public class Company {

	private String name;
	private BinaryTree<Project> projects = new BinaryTree<>();

	public Company(String name) {
		this.name = name;
	}

	public void addProject(Project project) {
		this.projects.add(project);
	}

	public void removeProject(Project project) {
		this.projects.remove(project);
	}

	public Project findProject(String title) {
		ArrayList<Project> inOrder = projects.inOrderTraversal();
		if (inOrder.size() > 0) {
			for (Project project : inOrder) {
				if (project.getTitle().equalsIgnoreCase(title)) {
					return project;
				}
			}
		}
		return null;
	}

	public void addTeamMember(Project project, TeamMember teamMember) {
		project.addTeamMember(teamMember);
	}

	public void removeTeamMember(Project project, TeamMember teamMember) {
		project.removeTeamMember(teamMember);
	}

    public void displayTeamMembers(Project project) {
		ArrayList<TeamMember> members = project.getTeamMembers();
		if (members.size() > 0) {
			for (TeamMember teamMember: project.getTeamMembers()) {
				System.out.println("- " + teamMember.toString());
			}
		} else {
			System.out.println("- The project " + '"' + project.getTitle()+ '"' + " has no team members");
		}
    }

	public void displayAll() {
		ArrayList<Project> inOrder = projects.inOrderTraversal();
		if (inOrder.size() > 0) {
			for (Project project : inOrder) {
				System.out.println("\n" + project.toString());
				displayTeamMembers(project);
			}
		} else {
			System.out.println("The tree is empty");
		}
	}

	public void displayAllNumbers() {
		ArrayList<Project> inOrder = projects.inOrderTraversal();
		if (inOrder.size() > 0) {
			for (Project project : inOrder) {
				System.out.println("\n" + project.toString() + "\n- " + project.getTeamSize() + " Members");
			}
		} else {
			System.out.println("The tree is empty");
		}
	}

}
