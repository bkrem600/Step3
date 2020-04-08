package projectsAndTeamMembersProgram;

import java.util.ArrayList;

public class Tree<Tree> {
	private TreeNode root;
	
	public TreeNode add (Project project) {
		if (root == null) {
			root = new TreeNode(project);
		}
		return root.insert(project);
	}
	
	public void remove(TreeNode insertValue) {
		this.root = root.remove(root, (Comparable) insertValue);
	}
	
	public String toString() {
		String treeDetails = new String();
		if(root != null) {
			treeDetails += root.toString();
		} else {
			treeDetails += "Tree is empty"; 
		}
		return treeDetails;
	}
	
	public ArrayList inOrderTraversal() {
		ArrayList inOrder = new ArrayList();
		inOrderHelper(root, inOrder);
		return inOrder;
	}
	
	private void inOrderHelper(TreeNode node, ArrayList list) {
		if (node == null) {
			return;
		}
		inOrderHelper(node.getLeftNode(), list);
		list.add(node.getData());
		inOrderHelper(node.getRightNode(), list);
	}
	
	public TreeNode find(TreeNode insertValue) {
		return root.find(insertValue);
	}
	
	public TreeNode getRoot() {
		return root;
	}

}
