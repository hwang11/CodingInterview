package Tree5;
import util.*;
public class BST {
//	int index = 0;
//	void copyBST(TreeNode root,int[] array) {
//		if(root == null) return;
//		copyBST(root.left, array);
//		array[index] = root.data;
//		index++;
//		copyBST(root.right, array);
//	}
	static Integer last_printed = null;
	static boolean checkBST(TreeNode n) {
		if(n == null) return true;
		if(!checkBST(n.left)) return false;
		if(last_printed != null && n.data <= last_printed) {
			return false;
		}
		last_printed = n.data;
		if(!checkBST(n.right)) return false;
		return true;
	}
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5};
		TreeNode node = TreeNode.createMinimalBST(arr);
		//tree생성.
		System.out.println("BST맞아? "+checkBST(node));
		
	}
	class WrapInt{
		public int value;
	}
}
