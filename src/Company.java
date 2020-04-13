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
		Project project = new Project(title, "", "");
		try {
			return projects.find(project);
		} catch (Exception exception) {
			return null;
		}
	}

	public void addTeamMember(Project project, TeamMember teamMember) {
		project.addTeamMember(teamMember);
	}

	public void removeTeamMember(Project project, TeamMember teamMember) {
		project.removeTeamMember(teamMember);
	}

//    public void displayTeamMembers(Project project) {
//        for (TeamMember teamMember: project.getTeamMembers()) {
//            System.out.println(teamMember.toString());
//        }
//    }

	public void displayAllProjects() {
		String string = projects.toString();
		if (string != null) {
			System.out.println("PROJECT DETAILS\t\t\t\t\tMEMBER DETAILS\n" + string);
		} else {
			System.out.println("Project list is empty");
		}
	}

//    public void displayAll() {
//        projects.inOrderTraversal();
//    }

}
