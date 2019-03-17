package DB.Graph;

/**
 * @Classname GraphGenerator
 * @Description TODO 图的生成
 * @Date 2019-03-17 10:45
 * @Created by guo
 */
public class GraphGenerator {
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            //记录每个节点的数据
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];

            //如果当前图中没有from节点
            if (!graph.nodes.containsKey(from)) {
                //from节点加入到nodes中
                graph.nodes.put(from, new GNode(from));
            }
            //取出from节点
            GNode fromNode = graph.nodes.get(from);
//            取出to节点
            GNode toNode = graph.nodes.get(to);
//            从from到to新建一条边
            Edge newEdge = new Edge(weight, fromNode, toNode);
//            from节点的下一个节点为toNode

            //连接from节点和to节点
            fromNode.nexts.add(toNode);
//            from节点的出度值加一
            fromNode.out++;
//            to节点的入度值加一
            toNode.in++;

            fromNode.edges.add(newEdge);
//            把新的边添加到图的边集中
            graph.edges.add(newEdge);

        }
        return graph;
    }

}
