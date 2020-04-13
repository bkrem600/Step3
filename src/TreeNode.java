public class TreeNode<T extends Comparable<T>> {

	private T data;
	public TreeNode<T> leftNode;
	public TreeNode<T> rightNode;

	public TreeNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		String string = "";
		if (leftNode != null) {
			string += leftNode.toString() + "\n";
		}
		string += this.data.toString() + "\n";
		if (rightNode != null) {
			string += rightNode.toString() + "\n";
		}
		return string;
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
		if (rightFind != null) {
			return rightFind;
		} else {
			return null;
		}
	}

	public boolean insert(T data){
		if (this.data.compareTo(data) > 0) {
			if (this.leftNode == null) {
				this.leftNode = new TreeNode<>(data);
				return true;
			} else {
				this.leftNode.insert(data);
			}
		}
		if (this.data.compareTo(data) < 0) {
			if (this.rightNode == null) {
				this.rightNode = new TreeNode<>(data);
				return true;
			} else {
				this.rightNode.insert(data);
			}
		}
		return false;
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
			root.data = findMinNode(root.rightNode).data;
			root.rightNode = remove(root.rightNode, root.data);
		}
		return root;
	}

	public TreeNode<T> findMinNode(TreeNode<T> root) {
		if (root.leftNode != null) {
			return findMinNode(root.leftNode);
		} else {
			return root;
		}
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
