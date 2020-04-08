package projectsAndTeamMembersProgram;

public class TeamMember implements Comparable<Object> {
	private String name;
	private Integer employeeNo;
	private String division;
	
	public String toString() {
		String projectDetails = new String();
		projectDetails += "Name" + "\t" + "\t" + "\t" + this.name + "\n"
				+ "Employee number" + "\t" + "\t" + this.employeeNo + "\n"
				+ "Division" + "\t" + "\t" + this.division;
		return projectDetails;
	}
	
	public TeamMember (String name, Integer employeeNo, String division) {
		this.name = name;
		this.employeeNo = employeeNo;
		this.division = division;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getEmployeeNo() {
		return employeeNo;
	}
	
	public String getDivision() {
		return division;
	}

	public int compareTo(TeamMember teamMember) {
		return Integer.compare(this.name.compareTo(teamMember.name), 0);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
