import java.io.*;

public class Experiment {
    public static void main(String[] args) {

        File file = new File("/Users/guo/IdeaProjects/untitled01/src/text.txt");

        System.out.println(readFile(file));
    Integer i = 24;
    }

    public static String readFile(File file) {

        StringBuilder result = new StringBuilder(); //构建一个字符串生成器，用于存放每行数据

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String s = null;

            while((s = br.readLine()) != null) { //每次读取一行

                result.append(System.lineSeparator() + s);

            }

            br.close();

        } catch (FileNotFoundException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        } catch (IOException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

        return result.toString();

    }
}
