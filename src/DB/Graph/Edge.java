package DB.Graph;

/**
 * @Classname Edge
 * @Description TODO 图中边的结构
 * @Date 2019-03-17 10:40
 * @Created by guo
 */
public class Edge {
    public int weight;
    public GNode in;
    public GNode out;

    public Edge(int weight, GNode in, GNode out) {
        this.weight = weight;
        this.in = in;
        this.out = out;
    }
}
