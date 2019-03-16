package DB.LinkedList;

import DB.Node;

import java.util.HashSet;

/**
 * @Classname findListLoop
 * @Description TODO
 * 题目:给定一个链表，判断该链表是否有环结构,并返回入环节点
 * 解法一：使用HashSet
 * <p>
 * HashSet里添加的是节点的内存地址
 * <p>
 * 即 a->b-><-️c
 * 或
 * a b c d e
 * ^
 * | f
 * <p>
 * h g
 * 解法二：快慢指针法
 * <p>
 * 快指针一次走两步，慢指针一次走一步，若遍历过程中二者相遇
 * 快指针回到开头，找到第一个入环节点，
 * 快指针变成每次走一步，慢指针继续走，二者会在第一个入环节点相遇
 * 时间复杂度 o(n)
 * <p>
 * 题目：无环的两条单链表，求其公共部分的始节点
 * 思路：若两条单链表存在公共部分，则必然是Y型结构，且终点节点相同，
 * 但由于不清楚谁长谁短，故较长者先走到与较短者相一致长度的地方二者各自再一起遍历。
 * <p>
 * <p>
 * 题目二：两链表，求二者第一个相交点
 * 一个有环结构，一个无环，则二者不存在相交，
 * 两者均有环，若二者相交，则二者共有一个环，有以下情况
 * 1.入环节点相同
 * Y
 * 0
 * <p>
 * 求第一个环外节点的相交点
 * <p>
 * 2.入环节点不同
 * \ /
 * o
 * loop1 ≠loop2（各自的入环节点）
 * loop1继续遍历，若与loop2相遇，则为相交，loop2为第一个相交节点
 * <p>
 * 若二者不相交， 则出现两个6的结构，且loop1不会与loop2相遇，回到loop1
 * @Date 2019-03-11 15:15
 * @Created by guo
 */
public class findListLoop {
    public static Node getFirstLoopNode(Node head) {
        HashSet<Node> set = new HashSet<Node>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        //设置快慢指针
        Node slow = head.next;
        Node fast = head.next.next;

        //遍历，以待相遇
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        //二者相遇，fast回到头结点位置
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    //无环相交问题
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;

    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) { //Y+公共环的情况
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return cur1;
                }
                cur1 = cur1.next;
            }
        }

        return null;
    }


}
