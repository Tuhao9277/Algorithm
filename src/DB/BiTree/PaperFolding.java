package DB.BiTree;

/**
 * @Classname FoldPaper
 * @Description TODO
 * 折N次，有2的n次方-1个折痕，即为一个二叉树结构，
 *          下
 *       下    上
 *     下 上  下  上
 *     中序遍历即可。
 * @Date 2019-03-14 22:17
 * @Created by guo
 */
public class PaperFolding {
    //
    public static void printAllFolds(int N) {
        printProcess(1,N,true);
    }

    private static void printProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printProcess(++i,n,true);
        System.out.println(down?"down":"up");
        printProcess(++i,n,false);
    }


    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);
    }
}
