public class TreeNode<T extends Comparable<T>> {

	private T data;
	public TreeNode<T> leftNode;
	public TreeNode<T> rightNode;

	public TreeNode(T data) {
		this.data = data;
	}

	public String toString() {
		String treeNodeDetails  = "";
		if (leftNode != null) {
			treeNodeDetails  += leftNode.toString() + "\n";
		}
		treeNodeDetails  += this.data.toString() + "\n";
		if (rightNode != null) {
			treeNodeDetails  += rightNode.toString() + "\n";
		}
		return treeNodeDetails ;
	}

	public void insert(T data){
		if (this.data.compareTo(data) > 0) {
			if (this.leftNode == null) {
				this.leftNode = new TreeNode<>(data);
				return;
			} else {
				this.leftNode.insert(data);
			}
		}
		if (this.data.compareTo(data) < 0) {
			if (this.rightNode == null) {
				this.rightNode = new TreeNode<>(data);
			} else {
				this.rightNode.insert(data);
			}
		}
	}

	public TreeNode<T> remove(TreeNode<T> root, T data) {
		if (root == null) {
			return null;
		}
		if (this.data.compareTo(data) < 0) {
			root.leftNode = remove(root.leftNode, data);
		} else if (this.data.compareTo(data) > 0) {
			root.rightNode = remove(root.rightNode, data);
		} else {
			if (root.leftNode == null) {
				return root.rightNode;
			} else if (root.rightNode == null) {
				return root.leftNode;
			}
			root.data = findMinValue(root.rightNode).data;
			root.rightNode = remove(root.rightNode, root.data);
		}
		return root;
	}

	public TreeNode<T> findMinValue(TreeNode<T> root) {
		if (root.leftNode != null) {
			return findMinValue(root.leftNode);
		} else {
			return root;
		}
	}

	public T find(T data){
		if (this.data.equals(data)) {
			return this.data;
		}
		T leftFind = null, rightFind = null;
		if (this.leftNode != null) {
			if (this.data.compareTo(data) > 0) {
				leftFind = leftNode.find(data);
			}
		}
		if (leftFind != null) {
			return leftFind;
		}
		if (this.rightNode != null) {
			if(this.data.compareTo(data) < 0) {
				rightFind = rightNode.find(data);
			}
		}
		return rightFind;
	}

	public T getData() {
		return data;
	}

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

}
