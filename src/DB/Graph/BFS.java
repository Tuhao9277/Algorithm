package DB.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname BFS
 * @Description TODO 广度优先遍历
 * 概念：离某一节点最近的节点先输出，远的节点后输出
 * 距离相等的节点为一层，同一层节点输出顺序随机
 * 准备一个队列，和一个Set （或使用一个Boolean类型的数组,visited)
 * Set/visited记录该点是否进入过队列
 * 队列记录
 * @Date 2019-03-17 11:11
 * @Created by guo
 */
public class BFS {
    public static void bfsSearch(GNode node) {
        if (node == null) {
            return;
        }
        Queue<GNode> queue = new LinkedList<GNode>();
        HashSet<GNode> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            GNode cur = queue.poll();
            System.out.println(cur.value);
            for (GNode next :
                    cur.nexts) {
                //当前节点的所有邻接点全部加入队列
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);

                }
            }
        }

    }

}
