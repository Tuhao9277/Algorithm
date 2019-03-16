package DB.BiTree;
import DB.BNode;
import java.util.Stack;
/**
 * @Classname Traversal
 * @Description TODO
 * 先序，中序，后序遍历的非递归算法
 * @Date 2019-03-14 21:29
 * @Created by guo
 */
public class Traversal {
    public static void preOrderNotR(BNode head) {
        if (head == null) {
            return;
        }
        Stack<BNode> stack = new Stack<BNode>();
        stack.push(head);
        while (!stack.isEmpty()) {
            //先序遍历，先打印，后入栈左右
            BNode bNode = stack.pop();
            System.out.println(bNode.value);

            //先入右节点，再入左节点
            if (bNode.right != null) {
                stack.push(bNode.right);
            }
            if (bNode.left != null) {
                stack.push(bNode.left);
            }
        }
    }

    public static void inOrderNotR(BNode head) {
        if (head == null) {
            return;
        }
        Stack<BNode> stack = new Stack<BNode>();
        while (!stack.isEmpty() || head != null) {
//            先压入左边界，一直压到最左叶子节点
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                //出栈打印往右走
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();

    }

    public static void postOrderNotR(BNode head) {
        if (head == null) {
            return;
        }
        //思路：先序遍历是中左右。改变其中左右的入栈顺序可以做到中右左，紧接着用一个help栈记录从原栈中弹出的元素，
        //最后遍历help栈即可
        Stack<BNode> stack = new Stack<BNode>();
        Stack<BNode> help = new Stack<BNode>();
        stack.push(head);
        while (!stack.isEmpty()) {
            //每次要改变head的节点位置。
            head = stack.pop();
            help.push(head);

            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
            while (!help.isEmpty()) {
                System.out.print(help.pop().value + " ");
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        BNode head = new BNode(5);
        head.left = new BNode(3);
        head.right = new BNode(8);
        head.left.left = new BNode(2);
        head.left.right = new BNode(4);
        head.left.left.left = new BNode(1);
        head.right.left = new BNode(7);
        head.right.left.left = new BNode(6);
        head.right.right = new BNode(10);
        head.right.right.left = new BNode(9);
        head.right.right.right = new BNode(11);

        // unrecursive
        System.out.println("============unrecursive=============");
        //preOrderNotR(head);
        //inOrderNotR(head);
        postOrderNotR(head);


    }
}
