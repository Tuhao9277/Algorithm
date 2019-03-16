package DB.Queue;

import java.util.PriorityQueue;

/**
 * @Classname IPOMaxProfits
 * @Description TODO
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 参数4，正数m
 *     costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
 *     费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多做k个项目 m表示你初始的资金
 *     说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个 项目。
 *
 *     输出： 你最后获得的最大钱数。
 * 给定一个初始投资资金，给定N个项目，想要获得其中最大的收益，并且一次只能做一个项目。
 * 这是一个贪心策咯的问题，按照花费的多少放到一个小根堆里面，
 * 然后要是小根堆里面的头节点的花费少于给定资金，就将头节点一个个取出来
 * ，放到按照收益的大根堆里面，这样就然后将大根堆 的堆顶弹出。。。,所获取的就是最大收益
 * @Date 2019-03-14 11:16
 * @Created by guo
 */
public class IPOMaxProfits {
    public static class Node {
        int cost;
        int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Node> minCost = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
        PriorityQueue<Node> maxProfit = new PriorityQueue<Node>(((o1, o2) -> o2.profit - o1.profit));
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(capital[i], profits[i]); //nodes中每个节点存储每个任务的开销和收益
        }
        //先将所有nodes按照开销放入minCost堆
        for (int i = 0; i < nodes.length; i++) {
            minCost.add(nodes[i]);
        }
        //若开销小于成本，则依次将小根堆中的元素按照收益放到大根堆
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().cost < w) {
                maxProfit.add(minCost.poll());
            }
            if (maxProfit.isEmpty()) {
                return w;
            }
            w += maxProfit.poll().profit;
        }
        return w;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{10, 20, 100};
        int[] profits = new int[]{11, 10, 200};
        int res = findMaximizedCapital(cost.length, 50, profits, cost);
        System.out.println(res);
    }
}
