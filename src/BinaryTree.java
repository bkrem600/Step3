import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public boolean add(T data) {
		if (root == null) {
			root = new TreeNode<>(data);
			return true;
		}
		return root.insert(data);
	}

	public void remove(T data) {
		this.root = root.remove(root, data);
	}

	public String toString() {
		if (root != null) {
			return root.toString();
		} else {
			return null;
		}
	}

    public ArrayList<T> inOrderTraversal() {
        ArrayList<T> inOrder = new ArrayList<>();
        inOrderHelper(root, inOrder);
        return inOrder;
    }

    private void inOrderHelper(TreeNode<T> node, ArrayList<T> inOrder) {
        if (node == null) {
			return;
        }
        inOrderHelper(node.getLeftNode(), inOrder);
		inOrder.add(node.getData());
        inOrderHelper(node.getRightNode(), inOrder);
	}

	public T find(T data) {
		return root.find(data);
	}

}
