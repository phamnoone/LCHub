/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null)
            return true
        return  isValidL(root?.left, root.`val`) && isValidR(root?.right, root.`val`)
    }

    private fun isValidL(r: TreeNode?, k: Int): Boolean {
        if (r == null) 
            return true
        val isK = r.`val` < k && isValidL(r?.right, k)
        val isNodeK =  isValidL(r?.left, r.`val`) && isValidR(r?.right, r.`val`)
        return isK && isNodeK
    }

    private fun isValidR(r: TreeNode?, k: Int): Boolean {
       if (r == null) 
            return true
        val isK = r.`val` > k && isValidR(r?.left, k) 
        val isNodeK =  isValidL(r?.left, r.`val`) && isValidR(r?.right, r.`val`)
        return isK && isNodeK
    }
}