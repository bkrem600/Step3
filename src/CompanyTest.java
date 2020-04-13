
public class CompanyTest {

	public static void main(String[] args) {
		Company company = new Company("Test");
		String projectTitle, startDate, endDate, memberName, memberDivision;
		Integer memberNumber, option;

		while (true) {
			while (true) {
				try {
					option = Input.getInteger("\n-----Menu-----\n" +
							"1) Add a project\n" +
							"2) Remove a project\n" +
							"3) Add a team member\n" +
							"4) Remove a team member\n" +
							"5) Display all team members of a project\n" +
							"6) Display all project details\n" +
							"7) Display the number of team members in each project\n" +
							"0) Quit\n" +
							"Option: ");
					break;
				} catch (Exception exception) {
					System.out.println("Invalid value entered");
				}
			}
			switch (option) {
				case 0:
					if (Input.getString("Are you sure? (Y/N): ").equalsIgnoreCase("y")) {
						System.out.println("Confirmed. Quitting program.");
						System.exit(0);
					} else {
						break;
					}
				case 1:
					projectTitle = Input.getString("Project title: ");
					if (company.findProject(projectTitle) == null) {
						startDate = Input.getString("Project start date: ");
						endDate = Input.getString("Project end date: ");
						company.addProject(new Project(projectTitle, startDate, endDate));
						System.out.println("The project " + '"' + projectTitle + '"' + " has been added");
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " already exists");
					}
					break;
				case 2:
					projectTitle = Input.getString("Project title: ");
					if (company.findProject(projectTitle) != null) {
						company.removeProject(company.findProject(projectTitle));
						System.out.println("The project " + '"' + projectTitle + '"' + " has been removed");
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
					}
					break;
				case 3:
					projectTitle = Input.getString("Project title: ");
					if (company.findProject(projectTitle) != null) {
						memberName = Input.getString("Team Member Name: ");
						memberNumber = Input.getInteger("Team Member Number: ");
						memberDivision = Input.getString("Team Member Division: ");
						company.addTeamMember(company.findProject(projectTitle), new TeamMember(memberName, memberNumber, memberDivision));
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
					}
					break;
				case 4:
					projectTitle = Input.getString("Project title: ");
					if (company.findProject(projectTitle) != null) {
						memberName = Input.getString("Team Member Name: ");
						company.removeTeamMember(company.findProject(projectTitle), new TeamMember(memberName, 0, ""));
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
					}
					break;
				case 5:
					projectTitle = Input.getString("Project title: ");
					Project project = company.findProject(projectTitle);
					if (project != null) {
						System.out.println("PROJECT DETAILS\t\t\t\t\tMEMBER DETAILS\n" + project.toString());
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
					}
					break;
				case 6:
					company.displayAllProjects();
					break;
				case 7:
					// Code here
					break;
				case 8:
					Project project1 = new Project("Web site creation", "01/01/18", "21/01/18");
					Project project2 = new Project("Database stuff", "03/06/19", "22/06/19");
					Project project3 = new Project("Structures class", "06/09/20", "23/09/20");
					TeamMember member1 = new TeamMember("Joe Bloggs", 1111, "Web Development");
					TeamMember member2 = new TeamMember("Chris Douglas", 2222, "Database");
					TeamMember member3 = new TeamMember("Boryana Kremakova", 3333, "Programming");
					company.addProject(project1);
					company.addProject(project2);
					company.addProject(project3);
					company.addTeamMember(project1, member1);
					company.addTeamMember(project1, member2);
					company.addTeamMember(project2, member3);
					break;
				default:
					System.out.println("Please enter valid option from the menu");
			}
		}
	}
}

