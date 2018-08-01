package Tree4;
import util.*;
public class Balanced {
	static int getHeight(TreeNode root) {
		if(root == null) return -1; //초기사례.
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	static boolean isBalanced(TreeNode root) {
		if(root == null) return true; //초기사례.
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1) return false;
		else return isBalanced(root.left) && isBalanced(root.right);
		//왼쪽, 오른쪽 둘다 균형이면 true반환해라.
		
	}
	public static void main(String args[]) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
	}
}
