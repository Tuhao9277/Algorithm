package DB;

/**
 * @Classname BNode
 * @Description TODO
 * @Date 2019-03-14 21:29
 * @Created by guo
 */
public class BNode {
    public int value;
    public BNode left;
    public BNode right;

    public BNode(int value, BNode left, BNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BNode(int value) {
        this.value = value;
    }
}
