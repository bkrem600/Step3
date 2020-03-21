package projectsAndTeamMembersProgram;

public class CompanyTest {
	
	public static void main(String[] args) throws Exception {
	Company company = new Company();
	TreeNode teamMemberTree = company.masterTree;
	TreeNode projectTree = company.projectTree;
	String projectTitle, startDate = null, endDate = null, nameMember, division;
	Integer employeeNo, option;
	
	do {
		while (true) {
			try {
				option = Input.getInteger("1) Add a project\n" +
						"2) Remove a project\n" + 
						"3) Add a team member to a project\n" +
						"4) Remove a team member from a project\n" + 
						"5) Display all team members of a project\n" + 
						"6) Display all team members and projects\n" + 
						"7) Display the number of team members in each project team\n" +
						"0) Quit\n" + "Option: ");
				break;
						} catch (Exception e) {
							System.out.println("Invalid value entered");
						}
		}
		switch (option) {
		case 0:
			if (Input.getString("Are you sure? (Y/N): ").equalsIgnoreCase("Y")) {
				System.out.println("Confirmed. Quitting program.");
				break;
			}
			option = 99;
			continue;
		case 1:
			projectTitle = Input.getString("Project title: ");
			if (projectTree.findProject(projectTitle) == null) {
				startDate = Input.getString("Project start date: ");
				endDate = Input.getString("Project end date: ");
			} else {
				Project project = new Project(projectTitle, startDate, endDate);
				projectTree.insertNode(project);
				System.out.println("The project " + '"' + projectTitle + '"' + " has been added");
			}
			break;
			
		case 2:
			projectTitle = Input.getString("Project title: ").toLowerCase();
			if (projectTree.removeProject(projectTree.findProject(projectTitle))) {
				Project project = new Project(projectTitle, "no data", "no data");
				projectTitle = (projectTree.removeNode(project) ? "The project " + '"' + projectTitle + '"' + " has been removed": "Unexpected error");
				System.out.println(projectTitle);
			} else {
				System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
			}
			break;
			
		case 3:
			boolean added = false;
			projectTitle = Input.getString("Project title: ");
			boolean projectExist = projectTree.findProject(projectTitle) == null;
			if (projectExist) {
				nameMember = Input.getString("Team member name: ");
				boolean nameExist = teamMemberTree.findTeamMember(nameMember) == null;
				if (!nameExist) {
					employeeNo = Input.getInteger("Team member employee number: ");
					division = Input.getString("Team member division: ");
					TeamMember teamMember = new TeamMember(nameMember, employeeNo, division);
					teamMemberTree.insertNode(teamMember);
					added = true;
				} else {
					System.out.println("The team member " + nameMember + " already exists");
				}
				if (added) {
					System.out.println("The team member " + nameMember + " has been added");
				} else {
					System.out.println("Some of the team member data was wrong. Please try again.");
				}
				break;					
			}
		case 4:
			nameMember = Input.getString("Team member name: ").toLowerCase();
			boolean nameExist = teamMemberTree.removeTeamMember(teamMemberTree.findTeamMember(nameMember));
			if (nameExist) {
				TeamMember teamMember = new TeamMember(nameMember, 0, "no data");
				nameMember = (teamMemberTree.removeNode(teamMember)) ? "The team member " + nameMember + " has been removed": "Something went wrong"; 
			} else {
				System.out.println("The team member " + nameMember + " could not be found");
			}
			break;
		case 5:
			projectTitle = Input.getString("Project title: ");
			if (teamMemberTree.getRoot() == null) {
				System.out.println("No team members found");
			} else {
				teamMemberTree.inOrderTraversal();
			}
			break;
		case 6:
			if (projectTree.getRoot() == null || teamMemberTree.getRoot() == null) 
				System.out.println("No data found");
			else {
				projectTree.inOrderTraversal();
				teamMemberTree.inOrderTraversal();
			}
			break;
		case 7:
			projectTitle = Input.getString("Project title: ");
			Project projectFound = new Project(projectTitle, "no data", "no data");
			Integer numberFound = teamMemberTree.findNumberOf(projectFound);
			projectTitle = (numberFound == 0) ? "No team members found": "Number of team members: " + numberFound.toString();
			System.out.println(projectTitle);
			break;
		} 
	} while (option != 0);
}
}

