package DB.BiTree;

/**
 * @Classname trie
 * @Description TODO 前缀树
 * @Date 2019-03-16 15:12
 * @Created by guo
 */
public class trie {
    public static class TrieNode {
        int pass;   //该节点被经过多少次
        int end;    //有多少个以此节点为终点的字符串
        public TrieNode[] nexts; //字母集

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];//新建存放26个英文字母的数组
        }
    }


    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray(); //字符串转换为字符数组
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a'; //字符之间的加减为ASCⅡ编码的加减
                if (node.nexts[index] == null) {
                    //没建出路，新建一条路
                    node.nexts[index] = new TrieNode();
                }
                //有路，node往下一级跑
                node = node.nexts[index];
                //走过一次，pass++
                node.pass++;
            }
            node.end++;

        }

        public void delete(String word) {
            if (search(word)) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                //node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    //删除操作,注意多个字符链共享一个字符的情况
                    //如果第二个字符链上只剩下1条
                    index = chs[i] - 'a';
                    if (node.nexts[index].pass-- == 1) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return false;
                }
                node = node.nexts[index];
            }
            return node.end != 0;
        }

        public void prefix() {
            TrieNode cur = root;
            int index = 0;

        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }

                node = node.nexts[index];
            }
            return node.pass;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] strs = new String[]{"flower", "flow", "flight"};
        for (int i = 0; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
//        System.out.println(trie.search("zuo"));
//        trie.insert("zuo");
//        System.out.println(trie.search("zuo"));
//        trie.delete("zuo");
//        System.out.println(trie.search("zuo"));
//        trie.insert("zuo");
//        trie.insert("zuo");
//        trie.delete("zuo");
//        System.out.println(trie.search("zuo"));
//        trie.delete("zuo");
//        System.out.println(trie.search("zuo"));
//        trie.insert("zuoa");
//        trie.insert("zuoacb");
//        trie.insert("zuoab");
//        trie.insert("zuoad");
//        trie.delete("zuoa");
        System.out.println(trie.search("fl"));
        System.out.println(trie.prefixNumber("flow"));

    }


}
