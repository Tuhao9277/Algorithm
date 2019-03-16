package DB.Stack;

import java.util.Stack;

/*
使用两个栈实现一个队列
* 新建两个栈
*   新的数从栈1进，从栈2 导出
 *  将栈1的元素全部压入栈2
* 若栈1中还有元素，栈2不pop
*
* 栈2一次性pop空
* */
public class TwoStackToQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public TwoStackToQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    //新数压入栈1
    public void push(int pushInt){

        stackPush.push(pushInt);
        dao();
    }

    //倾倒栈2
    public int poll(){

        if (stackPop.empty() && stackPush.empty())
            throw new RuntimeException("stack is empty!");
        dao();
        return stackPop.pop();
    }
    //取栈2栈顶元素
    public int peek(){

        if (stackPop.empty() && stackPush.empty())
            throw new RuntimeException("stack is empty!");
        dao();
        return stackPop.peek();
    }

    //push栈导入pop栈
    public void dao(){
        if (stackPush.isEmpty()) {

            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
}
