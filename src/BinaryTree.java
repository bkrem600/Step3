import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public void add(T data) {
		if (root == null) {
			root = new TreeNode<>(data);
		}
		root.insert(data);
	}

	public void remove(T data) {
		this.root = root.remove(root, data);
	}

	@Override
	public String toString() {
		if (root != null) {
			return root.toString();
		} else {
			return null;
		}
	}

//    public ArrayList inOrderTraversal() {
//        ArrayList inOrder = new ArrayList();
//        inOrderHelper(root, inOrder);
//        return inOrder;
//    }
//
//    private void inOrderHelper(TreeNode<T> node, ArrayList list) {
//        if (node == null) {
//            return;
//        }
//        inOrderHelper(node.getLeftNode(), list);
//        list.add(node.getData());
//        inOrderHelper(node.getRightNode(), list);
//    }

	public T find(T data) {
		return root.find(data);
	}

}
