package DB.Graph;

import java.util.ArrayList;

/**
 * @Classname GNode
 * @Description TODO 图节点的数据结构
 * @Date 2019-03-17 10:38
 * @Created by guo
 */
public class GNode {
    public int value;
    public int in;
    public int out;
    public ArrayList<GNode> nexts;      //该点出发的能到达的邻节点集合
    public ArrayList<Edge> edges;   //从该点出发的边的集合


    public GNode(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
