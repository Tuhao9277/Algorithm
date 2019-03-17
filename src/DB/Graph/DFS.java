package DB.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname DFS
 * @Description TODO 深度优先遍历
 * 使用一栈
 * @Date 2019-03-17 11:24
 * @Created by guo
 */
public class DFS {

    public static void dfs(GNode node) {
        if (node == null) {
            return;
        }
        Stack<GNode> stack = new Stack<GNode>();
        HashSet<GNode> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        while (!stack.isEmpty()) {
            GNode cur = stack.pop();
            for (GNode next :
                    cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
