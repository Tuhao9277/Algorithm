package DB.LinkedList;
/*
 *拷贝一个特殊链表
 *解法一：使用Map拷贝一个特殊链表
 *
 * Map(旧节点,新节点) 依次存入
 * 设置某一克隆节点的next值为原x.next的克隆值
 *
 *
 * 解法二：将新旧链表合为一个大链表
 * 结构：a->a'->b->b'->c->c'
 *
 * 若a的rand节点是c，则a'的rand节点就为c->next
 * 新老链表分离
 *
 * */

import java.util.HashMap;

public class CopyRandomList {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    //HashMap解法
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        Node X = head;
        while (X != null) {
            //get过程为取出当前克隆节点的过程
            map.get(X).next = map.get(X.next); //某一克隆节点的next值为原x.next的克隆值
            map.get(X).rand = map.get(X.rand);
        }
        return map.get(head);
    }

    //合二为一解法
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;

        //copy node and link every node
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;

        //set copy node rand
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;

        }
        Node res = head.next;
        cur = head;

        //split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

    }
}
