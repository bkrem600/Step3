package projectsAndTeamMembersProgram;

public class TreeNode {
	private TreeNode insertValue;
	Comparable data;
	TreeNode leftNode;
	TreeNode rightNode;
	
	public TreeNode (TreeNode insertValue) {
		this.insertValue = insertValue;
	}
	public TreeNode(Comparable nodeData) {
		data = nodeData;
		leftNode = rightNode = null; // node has no children
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
	
	public TreeNode getInsertValue() {
		return this.insertValue;
	}
	
	public TreeNode insert(TreeNode insertValue) {
		 if (((Comparable) insertValue).compareTo(data) < 0) {
			if (leftNode == null) {
				leftNode = new TreeNode(insertValue);
			} else {
				leftNode = leftNode.insert(insertValue);
			}
		} else if (((Comparable) insertValue).compareTo(data) >= 0) {
			if (rightNode == null) {
				rightNode = new TreeNode(insertValue);
			} else {
				rightNode = rightNode.insert(insertValue);
			}
		}
		return this;
	}
	
	public TreeNode find(TreeNode insertValue) {
		if (this.insertValue.equals(insertValue)) {
			return this.insertValue;
		}
		TreeNode leftNodeFind = null;
		TreeNode rightNodeFind = null;
		if (this.leftNode != null) {
			if (((Comparable) this.insertValue).compareTo(insertValue) > 0) {
				leftNodeFind = leftNode.find(insertValue);
			} 
			if (leftNodeFind != null) {
				return leftNodeFind;
			}
		if (this.rightNode != null) {
			if (((Comparable) this.insertValue).compareTo(insertValue) < 0) {
				rightNodeFind = rightNode.find(insertValue);
			}
			if (rightNodeFind != null) {
				return rightNodeFind;
			} else {
				return null;
			}
		}
			
		}
		return null;
	}
	
	public TreeNode remove(TreeNode root, Comparable insertValue) {
		if (root == null) {
			return root;
		} 
		if (((Comparable) this.insertValue).compareTo(insertValue) < 0) {
			root.leftNode = remove(root.leftNode, insertValue);
		} else if (((Comparable) this.insertValue).compareTo(insertValue) > 0) {
			root.rightNode = remove(root.rightNode, insertValue);
		} else {
			if (root.leftNode == null) {
				return root.rightNode;
			} else if (root.rightNode == null) {
				return root.rightNode;
			}
			root.insertValue = findMinValue (root.rightNode.insertValue);
			root.rightNode = remove(root.rightNode, (Comparable) root.insertValue);
		}
		return root;
	}
	
	public TreeNode findMinValue(TreeNode root) {
		if (root.leftNode != null) {
			return findMinValue(root.leftNode);
		} else {
			return root;
		}
	}
	
	public String toString() {
		String treeNodeDetails = new String();
		if (leftNode != null) {
			treeNodeDetails += leftNode.toString() + "\n";			
			}
		treeNodeDetails += this.insertValue.toString() + "\n";
			if (rightNode != null) {
				treeNodeDetails += rightNode.toString() + "\n";
			}
			return treeNodeDetails;
	}

}
