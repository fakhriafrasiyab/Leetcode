package leetcode;

import test.BinaryTreeNodeSearch;

public class SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root != null) {
            if (isLeafNode(root.left)) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    public boolean isLeafNode(TreeNode node) {
        if (node == null) {
            return false;
        } else return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        SumLeftLeaves sumLeftLeaves = new SumLeftLeaves();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(sumLeftLeaves.sumOfLeftLeaves(root));
    }

}

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;


    TreeNode() {
    }


    TreeNode(int val) {
        this.val = val;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
