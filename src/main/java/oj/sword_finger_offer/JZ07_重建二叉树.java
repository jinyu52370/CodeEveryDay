package oj.sword_finger_offer;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/13 12:03
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *  前序遍历 preorder = [3,9,20,15,7]
 *  中序遍历 inorder = [9,3,15,20,7]
 *  返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *  0 <= 节点个数 <= 5000
 */
public class JZ07_重建二叉树 {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTree(int preIndex, int inLeft, int inRight, int[] preorder, int [] inorder) {
        if (preIndex > preorder.length - 1 || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int mid = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }
        root.left = buildTree(preIndex + 1, inLeft, mid - 1, preorder, inorder);
        root.right = buildTree(preIndex + mid - inLeft + 1, mid + 1, inRight, preorder, inorder);
        return root;
    }
}
