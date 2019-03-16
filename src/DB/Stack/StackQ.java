package DB.Stack;

import java.util.Stack;

/*
*
* Q:在一个栈的结构中实现返回最小值的操作
* 要求getMin()方法的时间复杂度为o(1)
*
* A:另新建一个栈，每入栈原栈的一个元素，在新栈中入栈最小值的元素。
* 如
* 5     1
* 1     1
* 4     2
* 2     2
* 3     3
*
* */
public class StackQ {
    private Stack<Integer> stackData ;
    private Stack<Integer> stackMin ;

    public StackQ() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            stackMin.push(newNum);
        }
        else if (newNum <getMin()){

            stackMin.push(newNum);
        }
        else {
            int newMin = stackMin.peek();
            stackMin.push(newMin);  //重复压入栈顶元素
        }
        stackData.push(newNum);
    }
    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("The tack is empty");
        }
        return this.stackMin.peek();
    }
    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("The stack is empty");
        }
        return this.stackData.pop();
    }
}
