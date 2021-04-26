package com.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "70*2+2*3+2000";
        //先创建两个栈,一个数栈一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义相关变量
        int index = 0, num1 = 0, num2 = 0, oper = 0, res = 0;
        char ch = ' ';//每次将扫描到的char保存于ch中
        String keepNum = "";//用于拼接多位数
        //开始循环扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么
            if (operStack.isOper(ch)) {//如果是运算符
                if (!operStack.isEmpty()) {//判断当前字符站是否为空
                    //如果符号栈中有操作符,就进行比较如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数
                    //再从符号栈中pop出一个符号进行运算,再将得到的结果入数栈,然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    } else operStack.push(ch);//如果当前操作符的优先级大于栈中的操作符,就直接入符号栈
                } else operStack.push(ch);   //如果为空直接入符号栈
            } else {
                //如果是数,则直接入数栈
                //numStack.push(ch - 48); //? "1+3" '1' => 1
                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接
                //处理多位数
                keepNum += ch;
                //如果ch已经是expression的最后一位,就直接入栈
                if (index == expression.length() - 1) numStack.push(Integer.parseInt(keepNum));
                else {
                    //判断下一个字符是不是数字,如果是数字,就继续扫描,如果是运算符,则入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {//此处是判断是符号入栈,并清空,不是不好就记录下来 下轮使用
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) break; //结束循环，跳出循环体，执行后面的程序。
        }
        //当表达式扫描完毕,就顺序的从数栈和符号栈中pop出相应的数和符号,并进行运算
        //经过上面的操作，符号栈剩下的都是优先级相等的符号了，直接出栈做运算就可以啦
        while (true) {
            //如果符号栈为空,则计算到最后的结果,数栈中只有一个数字--结果
            if (operStack.isEmpty()) break;
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);//结果入栈
//            System.out.println("-------- 出循环后数栈 ---------");
//            numStack.list();
//            System.out.println("-----------------");
        }
        int res2 = numStack.pop();
        System.out.printf("表达式%s=%d", expression, res2);
    }


}


//1. 定义一个ArrayStack栈
class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack; //数组,数组模拟栈
    private int top = -1; //top表示栈顶,初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //可以返回当前栈顶的值,但不是pop,而是用做对比
    public int peek() {
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈--push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop,将栈顶的数据返回
    public int pop() {
        if (isEmpty()) throw new RuntimeException("栈空,没有数据");
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈,遍历时需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空,没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级,优先级是程序员来确定,优先级使用数字表示
    //数字越大,则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') return 1;
        else if (oper == '+' || oper == '-') return 0;
        else return -1;
    }

    //判断是否为一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {

            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}