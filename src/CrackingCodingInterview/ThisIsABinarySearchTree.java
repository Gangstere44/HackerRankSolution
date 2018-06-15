package CrackingCodingInterview;

public class ThisIsABinarySearchTree {

	class Node {
		int data;
		Node left;
		Node right;
	}
	
	boolean checkLeftBST(Node leftChild, int parentValue) {
		return leftChild == null || 
				(leftChild.data < parentValue && 
						checkBST(leftChild) && 
						checkLeftBST(leftChild.left, parentValue) &&
						checkLeftBST(leftChild.right, parentValue));
	}
	
	boolean checkRightBST(Node rightChild, int parentValue) {
		return rightChild == null || 
				(rightChild.data > parentValue && 
						checkBST(rightChild) && 
						checkRightBST(rightChild.left, parentValue) &&
						checkRightBST(rightChild.right, parentValue));
	}

	boolean checkBST(Node root) {
		return checkLeftBST(root.left, root.data) && checkRightBST(root.right, root.data);
	}

}
