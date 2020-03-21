package projectsAndTeamMembersProgram;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
	private TreeNode root;
	Comparable data;
	TreeNode leftNode;
	TreeNode rightNode;
	private LinkedList<Project> projects = new LinkedList<>();
	ArrayList<TeamMember> teamMembers = new ArrayList<>();
	
	public TreeNode(Comparable inputData) {
		data = inputData;
		leftNode = null;
		rightNode = null;
	}
	
	public Comparable getData() {
		return data;
	}
	
	public TreeNode getLeftNode() {
		return leftNode;
	}
	
	public TreeNode getRightNode() {
		return rightNode;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	private boolean isRootEmpty() {
		return root == null ? true: false;
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
	
	public Boolean removeProject (Project project) {
		return this.projects.remove(project);
	}
	
	public void displayProject (Project project) {
		System.out.println(project.toString());
	}
	
	public TeamMember findTeamMember (String s) {
		for (TeamMember teamMember: teamMembers) {
			if (teamMember.getName().equalsIgnoreCase(s)) 
				return teamMember;
		}
		return null;
	}
	
	public Boolean removeTeamMember (TeamMember teamMember) {
		if (this.teamMembers.remove(teamMember)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void displayTeamMember(TeamMember teamMember) {
		System.out.println(teamMember.toString());
	}
	
	public TreeNode insert(Comparable inValue) throws Exception {
		 if (inValue.compareTo(data) < 0) {
			if (leftNode == null) {
				leftNode = new TreeNode(inValue);
			} else {
				leftNode = leftNode.insert(inValue);
			}
		} else if (inValue.compareTo(data) >= 0) {
			if (rightNode == null) {
				rightNode = new TreeNode(inValue);
			} else {
				rightNode = rightNode.insert(inValue);
			}
		}
		return this;
	}
	
	public void insertNode (Comparable insertValue) throws Exception {
		root = this.isRootEmpty() ? new TreeNode(insertValue): root.insert(insertValue);
		}
	
	public boolean remove(TreeNode parentNode, Comparable data) {
		if (data.compareTo(this.getData()) == -1) {
			return (this.leftNode != null) ? this.leftNode.remove(this, data): false;
		} else if (data.compareTo(this.getData()) == 1) {
			return (this.rightNode != null) ? this.rightNode.remove(this, data): false;
		} else {
			if (this.leftNode != null && this.rightNode != null) {
				this.data = this.rightNode.minValue();
				this.rightNode.remove(this, this.data);
			} else if (parentNode.leftNode == this) {
				parentNode.leftNode = (leftNode != null) ? leftNode: rightNode;
			} else if (parentNode.rightNode == this) {
				parentNode.rightNode = (rightNode != null) ? leftNode: rightNode;
			}
			return true;
		}
	}
	
	public boolean removeNode (Comparable removedNode) {
		if (root.rightNode == null && root.leftNode == null) {
			if (root.data.compareTo(removedNode) == 0) {
				root = null;
				return true;
			} else {
				return false;
			}
		} else {
			return (root == null) ? false: root.remove(null, removedNode);
		}
	}
	
	public void inOrderTraversal() {
		inOrderHelper(root);
	}
	
	private void inOrderHelper(TreeNode node) {
		if(node == null)
			return;
		inOrderHelper(node.getLeftNode());
		System.out.println(node.getData());
		inOrderHelper(node.getRightNode());
	}
	
	public int findNumberOf (Project inValue) {
		ArrayList<Comparable> foundMatches = new ArrayList<Comparable>();
		foundMatches = findNumberOfHelper(root, foundMatches, inValue);
		return foundMatches.size();
	}
	
	private ArrayList<Comparable> findNumberOfHelper(TreeNode node, ArrayList<Comparable> foundMatches, Project inValue) {
		if (node != null) {
			TeamMember teamMember = (TeamMember)node.getData();
			String project = teamMember.getName().toLowerCase();
			if (inValue.getTitle().toLowerCase().equals(project)) {
				foundMatches.add(node.getData());
			}
			findNumberOfHelper(node.getLeftNode(), foundMatches, inValue);
			findNumberOfHelper(node.getRightNode(), foundMatches, inValue);
		}
		return foundMatches;
	}
	
	public Comparable minValue() {
		if (leftNode == null)
			return data;
		else
			return leftNode.minValue();
	}
	
	public String toString() {
		return this.data.toString();
	}
	
	public String getProjectTitle() {
		String targetData = getData().toString();
		return targetData;
	}

}
