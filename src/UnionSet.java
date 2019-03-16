import java.util.HashMap;
import java.util.List;

/**
 * @Classname UnionSet
 * @Description TODO List
 * <p>
 * isSameSet()
 * 查两个元素是否属于一个集合
 * <p>
 * Union
 * 合并A，B两个集合
 * <p>
 * 集合可以用List HashSet实现，存在遍历代价
 * <p>
 * 并查集结构：
 * 一个元素有一个指向上一级的指针，和一个变量值（单链表）
 * <p>
 * 每个元素各自成一个集合
 * 每个元素的指针指向自己
 * <p>
 * 较小个数节点的集合挂在多个数节点的集合下面
 * 最上级节点为代表节点
 * 代表节点的指针指向自己
 * @Date 2019-03-16 14:09
 * @Created by guo
 */
public class UnionSet {
    public static class UnionFindSet {
        public class Data{

        }
        public HashMap<Data, Data> fatherMap;
        public HashMap<Data, Integer> sizeMap;

        public UnionFindSet() {
            //（key,value)表示，key的父节点是value，
            // (DataA,dataB)表示，dataA的父节点是DataB
            //sizeMap 代表节点
            fatherMap = new HashMap<Data,Data>();
            sizeMap = new HashMap<Data,Integer>();
        }

        //初始化集合
        public void makeSets(List<Data> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Data node :
                    nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Data findRepresent(Data node) {
            Data father = fatherMap.get(node);
            if (father != node) {
                father = findRepresent(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Data a, Data b) {
            return findRepresent(a) == findRepresent(b);
        }

        public void Union(Data a, Data b) {
            if (a == null || b == null) {
                return;
            }
            Data aHead = findRepresent(a);
            Data bHead = findRepresent(b);
            if (aHead != bHead) {//不在一个即合里，进行合并
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead); //aHead挂在b的下面
                    sizeMap.put(bHead, aSetSize + bSetSize);
                }
                else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }

    }
}

