import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitTest {

    private static Company testCompany = new Company("Test Company");

    public static void main(String[] args) {
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
                    startDate = Input.getString("Project start date: ");
                    endDate = Input.getString("Project end date: ");
                    testCompany.addProject(new Project(projectTitle, startDate, endDate));
                    break;
                case 2:
                    projectTitle = Input.getString("Project title: ");
                    Project project = testCompany.findProject(projectTitle);
                    if (project != null) {
                        testCompany.removeProject(project);
                    } else {
                        System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
                    }
                    break;
                case 3:
                    projectTitle = Input.getString("Project title: ");
                    project = testCompany.findProject(projectTitle);
                    if (project != null) {
                        memberName = Input.getString("Team Member Name: ");
                        TeamMember member = project.findTeamMember(memberName);
                        if (member == null) {
                            try {
                                memberNumber = Input.getInteger("Team Member Number: ");
                                memberDivision = Input.getString("Team Member Division: ");
                                testCompany.addTeamMember(project, new TeamMember(memberName, memberNumber, memberDivision));
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
                    project = testCompany.findProject(projectTitle);
                    if (project != null) {
                        memberName = Input.getString("Team Member Name: ");
                        TeamMember member = project.findTeamMember(memberName);
                        if (member != null) {
                            testCompany.removeTeamMember(project, member);
                        } else {
                            System.out.println("The team member " + '"' + memberName + '"' + " could not be found");
                        }
                    } else {
                        System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
                    }
                    break;
                case 5:
                    projectTitle = Input.getString("Project title: ");
                    project = testCompany.findProject(projectTitle);
                    if (project != null) {
                        System.out.println("\n" + project.toString());
                        testCompany.displayTeamMembers(project);
                    } else {
                        System.out.println("The project " + '"' + projectTitle + '"' + " could not be found");
                    }
                    break;
                case 6:
                    testCompany.displayAll();
                    break;
                case 7:
                    testCompany.displayAllNumbers();
                    break;
                default:
                    System.out.println("Please enter a valid option from the menu");
            }
        }
    }

    @org.junit.jupiter.api.BeforeEach
    public void initialiseCompany() {
        testCompany = new Company("Test Company");
    }

    @org.junit.jupiter.api.Test
    void addProject() {
        Project testProject = new Project("Test Project","01/04/2020","10/04/2020");
        testCompany.addProject(testProject);
        assertEquals(testProject, testCompany.findProject("Test Project"));
    }

    @org.junit.jupiter.api.Test
    void removeProject() {
        Project testProject1 = new Project("Test Project 1","01/04/2018","10/05/2018");
        Project testProject2 = new Project("Test Project 2","02/05/2019","11/06/2019");
        Project testProject3 = new Project("Test Project 3","03/06/2020","12/07/2020");
        testCompany.addProject(testProject1);
        testCompany.addProject(testProject2);
        testCompany.addProject(testProject3);
        testCompany.removeProject(testProject1);
        assertEquals(testProject2, testCompany.findProject("Test Project 2"));
        assertEquals(testProject3, testCompany.findProject("Test Project 3"));
    }

    @org.junit.jupiter.api.Test
    void findProject() {
        Project testProject1 = new Project("Test Project 1","01/04/2018","10/05/2018");
        Project testProject2 = new Project("Test Project 2","02/05/2019","11/06/2019");
        Project testProject3 = new Project("Test Project 3","03/06/2020","12/07/2020");
        testCompany.addProject(testProject1);
        testCompany.addProject(testProject2);
        testCompany.addProject(testProject3);
        assertEquals(testProject1, testCompany.findProject("Test Project 1"));
        assertEquals(testProject2, testCompany.findProject("Test Project 2"));
        assertEquals(testProject3, testCompany.findProject("Test Project 3"));
    }

    @org.junit.jupiter.api.Test
    void addTeamMember() {
        Project testProject = new Project("Test Project","01/04/2020","10/04/2020");
        testCompany.addProject(testProject);
        TeamMember teamMember1 = new TeamMember("Team Member 1", 1111, "Website Creation");
        TeamMember teamMember2 = new TeamMember("Team Member 2", 2222, "Database Creation");
        TeamMember teamMember3 = new TeamMember("Team Member 3", 3333, "App Creation");
        testCompany.addTeamMember(testProject, teamMember1);
        testCompany.addTeamMember(testProject, teamMember2);
        testCompany.addTeamMember(testProject, teamMember3);
        assertEquals(teamMember1, testCompany.findProject("Test Project").getTeamMembers().get(0));
        assertEquals(teamMember2, testCompany.findProject("Test Project").getTeamMembers().get(1));
        assertEquals(teamMember3, testCompany.findProject("Test Project").getTeamMembers().get(2));
    }

    @org.junit.jupiter.api.Test
    void removeTeamMember() {
        Project testProject = new Project("Test Project","01/04/2020","10/04/2020");
        testCompany.addProject(testProject);
        TeamMember teamMember1 = new TeamMember("Team Member 1", 1111, "Website Creation");
        TeamMember teamMember2 = new TeamMember("Team Member 2", 2222, "Database Creation");
        TeamMember teamMember3 = new TeamMember("Team Member 3", 3333, "App Creation");
        testCompany.addTeamMember(testProject, teamMember1);
        testCompany.addTeamMember(testProject, teamMember2);
        testCompany.addTeamMember(testProject, teamMember3);
        testCompany.removeTeamMember(testProject, teamMember1);
        assertEquals(teamMember2, testCompany.findProject("Test Project").getTeamMembers().get(0));
        assertEquals(teamMember3, testCompany.findProject("Test Project").getTeamMembers().get(1));
    }

}

