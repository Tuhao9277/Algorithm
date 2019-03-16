import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class AlgoVisualizer {
    // TODO:创建属于自己的数据
    private static int DELAY = 40;
    private int[] money;
    private AlgoFrame algoFrame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        money = new int[N];
        for (int i = 0; i < money.length; i++) {
            money[i] = N;

        }

        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO:根据实际情况添加键盘或者鼠标监听器
            new Thread(() -> {
                run();
            }).start();

        });
    }

    //动画逻辑
    private void run() {

        // TODO:编写自己的动画逻辑
        while (true) {

            Arrays.sort(money);

            algoFrame.render(money);
            AlgoVisHelper.pause(DELAY);

            for (int k = 0; k < 50; k++) {

                for (int i = 0; i < money.length; i++) {

                        int j = (int) (Math.random() * money.length);
                        money[i] -= 1;
                        money[j] += 1;

                }
            }

        }
    }

    public static void main(String[] args) {
        int senceWidth = 600;
        int senceHeight = 400;
        AlgoVisualizer algoVisualizer = new AlgoVisualizer(senceWidth, senceHeight, 100);
    }

}
