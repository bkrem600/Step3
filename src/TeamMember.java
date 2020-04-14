public class TeamMember implements Comparable<TeamMember> {

	private String name, division;
	private int number;

	public TeamMember(String name, int number, String division) {
		this.name = name;
		this.number = number;
		this.division = division;
	}

	public String toString() {
		return name + " (" + number + ", " + division + ")";
	}

	@Override
	public int compareTo(TeamMember teamMember) {
		return this.name.compareTo(teamMember.name);
	}

	@Override
	public boolean equals(Object object) {
		try {
			return this.name.equals(((TeamMember) object).name);
		} catch (Exception e) {
			return false;
		}
	}

	public String getName() {
		return name;
	}
}
