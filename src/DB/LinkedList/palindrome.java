package DB.LinkedList;

import DB.Node;

/**
 * 给定一个单链表，判断是否为回文结构
 * 要求时间复杂度为o(N),空间复杂度o(1)
 * <p>
 * <p>
 * 思路：若不要求空间复杂度，则使用一个栈，记录链表的逆序，然后出栈+链表遍历
 * <p>
 * 在空间复杂度为o(1)的情况下
 * 需要找到链表的中点
 * <p>
 * 设置快慢指针
 * 快指针一次走两步，慢指针一次走一步，快指针走完时，慢指针到达链表中点位置
 * 后半部分入栈，并出栈+链表遍历，此时节省一半空间。
 * <p>
 * 彻底不使用额外空间的方法：
 * <p>
 * 设置快慢指针
 * 快指针一次走两步，慢指针一次走一步，快指针走完时，慢指针到达链表中点位置，
 * 后边部分给丫逆序，做成  1 -> 2 -> 3 <- 2 <- 1
 * 从两头开始遍历，若有一个对不上则不是回文
 */

public class palindrome {



    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;
        Node slow = head;
        Node fast = head;

        if (fast.next != null && fast.next.next != null) {
            slow = slow.next;   //n1 ->mid
            fast = fast.next.next;  //n2 ->end
        }
        fast = slow.next;   //n2 ->right part first node
        slow.next = null;   // mid.next ->null
        Node n3 = null;

        //逆序后半部分链表  p->q->r   改为 p <- q <- r

        while (fast != null) {  //fast 为 q r为n3
            n3 = fast.next;   // n3 记录r的位置
            fast.next = slow;   //使得 p <- q
            slow = fast;       // slow 现在变为q
            fast = n3;         // r位置为fast，继续往后调整，每次调整slow跟fast的值
        }

        //check palindrome
        n3 = slow;  //n3 从尾部节点开始
        fast = head;    //n2 从头部节点开始
        boolean res = true;
        while (slow != null && fast != null) {
            if (slow.value != fast.value) {
                res = false;
                break;
            }
            slow = slow.next; //left to mid
            fast = fast.next; // right to mid
        }


        //recover list  逆序部分恢复
        slow = n3.next;
        n3.next = null;
        while (slow != null) {

            fast = slow.next;
            slow.next = n3;
            n3 = slow;
            slow = fast;
        }

        return res;
    }
    public static void printLinkedList(Node n1){
        if (n1 == null) {
            return;
        }
        while (n1 != null) {
            System.out.print(n1.value+" ");
            n1 = n1.next;
        }
    }

    public static void main(String[] args){
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(1);
        head1.next.next.next.next.next = new Node(9);
        head1.next.next.next.next.next.next = new Node(7);

        boolean res1 = isPalindrome(head1);

        System.out.println(res1);
        printLinkedList(head1);
    }

}
