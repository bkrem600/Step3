
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
					Project project = company.findProject(projectTitle);
					if (project == null) {
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
					project = company.findProject(projectTitle);
					if (project != null) {
						company.removeProject(project);
						System.out.println("The project " + '"' + projectTitle + '"' + " has been removed");
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
					}
					break;
				case 3:
					projectTitle = Input.getString("Project title: ");
					project = company.findProject(projectTitle);
					if (project != null) {
						memberName = Input.getString("Team Member Name: ");
						TeamMember member = project.findTeamMember(memberName);
						if (member == null) {
							try {
								memberNumber = Input.getInteger("Team Member Number: ");
								memberDivision = Input.getString("Team Member Division: ");
								company.addTeamMember(project, new TeamMember(memberName, memberNumber, memberDivision));
								System.out.println("The team member " + '"' + memberName + '"' + " has been added");
							} catch (Exception exception) {
								System.out.println("Invalid value entered");
							}
						} else {
							System.out.println("The team member " + '"' + memberName + '"' + " already exists");
						}
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
					}
					break;
				case 4:
					projectTitle = Input.getString("Project title: ");
					project = company.findProject(projectTitle);
					if (project != null) {
						memberName = Input.getString("Team Member Name: ");
						TeamMember member = project.findTeamMember(memberName);
						if (member != null) {
							company.removeTeamMember(project, member);
							System.out.println("The team member " + '"' + memberName + '"' + " has been removed");
						} else {
							System.out.println("The team member " + '"' + memberName + '"' + " could not be found");
						}
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
					}
					break;
				case 5:
					projectTitle = Input.getString("Project title: ");
					project = company.findProject(projectTitle);
					if (project != null) {
						System.out.println("\n" + project.toString());
						company.displayTeamMembers(project);
					} else {
						System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
					}
					break;
				case 6:
					company.displayAll();
					break;
				case 7:
					company.displayAllNumbers();
					break;
				case 8:
					System.out.println("Populated with data for testing purposes");
					Project project1 = new Project("test1", "01/01/18", "21/01/18");
					Project project2 = new Project("test2", "03/06/19", "22/06/19");
					Project project3 = new Project("test3", "06/09/20", "23/09/20");
					Project project4 = new Project("test4", "03/01/20", "25/03/20");
					TeamMember member1 = new TeamMember("Joe Bloggs", 1111, "Web Development");
					TeamMember member2 = new TeamMember("Chris Douglas", 2222, "Database");
					TeamMember member3 = new TeamMember("Boryana Kremakova", 3333, "Programming");
					TeamMember member4 = new TeamMember("Connor Dillon", 4444, "Uml shite");
					TeamMember member5 = new TeamMember("Benjamin Cattermole", 5555, "Please stop");
					TeamMember member6 = new TeamMember("Finlay Ross", 6666, "I hate java");
					company.addProject(project3);
					company.addProject(project2);
					company.addProject(project1);
					company.addProject(project4);
					company.addTeamMember(project1, member1);
					company.addTeamMember(project1, member2);
					company.addTeamMember(project1, member3);
					company.addTeamMember(project2, member4);
					company.addTeamMember(project2, member5);
					company.addTeamMember(project3, member6);
					break;
				default:
					System.out.println("Please enter a valid option from the menu");
			}
		}
	}
}

