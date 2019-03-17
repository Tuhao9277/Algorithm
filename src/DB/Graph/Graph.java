package DB.Graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Classname Graph
 * @Description TODO 图
 * nodes：点集
 * edges：边集
 * 表示方法：邻接表
 * 邻接矩阵
 * 生成图：
 * 给定数组：[important,from,to]
 * @Date 2019-03-17 10:11
 * @Created by guo
 */
public class Graph {

    public HashMap<Integer, GNode> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }


}
