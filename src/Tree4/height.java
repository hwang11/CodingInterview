package Tree4;
import util.*;
//-1은 null tree의 높이로 정의하므로  Integer.MIN_VALUE를 사용하여 에러표시.
public class height {
	static int checkHeight(TreeNode root) {
		if(root == null) return -1;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //0
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		//균형확인.
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) return Integer.MIN_VALUE;
		else return Math.max(leftHeight,rightHeight) +1;
	}
	
	static boolean isBalanced(TreeNode root) {
		return checkHeight(root)!= Integer.MIN_VALUE;
	}
	public static void main(String args[]) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
	}
}
