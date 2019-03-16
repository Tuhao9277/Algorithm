package DB.BiTree;

import DB.PNode;

/**
 * @Classname DescendantNode
 * @Description TODO
 * 寻找二叉树中任一节点的后继
 * @Date 2019-03-15 12:42
 * @Created by guo
 */
public class DescendantNode {
    public static PNode Search(PNode pNode){
        if (pNode.right != null) {
            return searchForLeftMost(pNode.right);
        }
        else {
            //记录父节点
            PNode parent = pNode.parent;
            //父节点及其左孩子不为空时，顺着父节点一直往上找，一直找到父节点的左孩子是当前pNode的位置
            while (parent != null && parent.left != pNode) {

                pNode = parent;
                parent = pNode.parent;
            }
            return parent;
        }
    }

    private static PNode searchForLeftMost(PNode pNode) {
        while (pNode.left != null) {
            pNode = pNode.left;
        }
        return pNode;
    }

}
