package DB.LinkedList;

import DB.DoubleNode;
import DB.Node;

/**
 * @Classname ReverseList
 * @Description TODO 反转链表
 * 单链表：定义一前一后两个指针，随着遍历而反转
 * 头插法
 * <p>
 * <p>
 * 双链表反转
 * @Date 2019-03-18 14:40
 * @Created by guo
 */
public class ReverseList {
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;   //next记录当前位置的下一个节点

            head.next = pre;
            pre = head; //交换

            head = next; //head 来到next的位置
        }
        return pre;
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;

            head.next = pre;
            head.last = next;

            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.println("DoubleList Linked List:");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("|");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        System.out.println("After Reversion:");
        printDoubleLinkedList(reverseList(head2));

    }


}
