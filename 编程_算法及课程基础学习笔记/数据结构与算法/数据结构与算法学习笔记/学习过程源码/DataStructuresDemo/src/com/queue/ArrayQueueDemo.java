package com.queue;
import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int head = queue.headQueue();
                        System.out.printf("表头是%d\n", head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    scanner.close();//关闭不释放会有异常
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front; //队列头
    private int rear;//队列尾
    private int[] arr; //该数据用于存放数据,模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部,分析出front是只想队列头的前一个位置
        rear = -1;//只想队列尾部,只想队列尾部数据(即队列最后一个数据)
    }

    //1. 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1; //当队列为指向数组最后一位时就是队列满
    }

    //2. 判断队列是否为空
    public boolean isEmpty() {
        return rear == front; //当队列头与尾部相等时,说明该队列没有值了
    }

    //3. 添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满,不能加入数据~~~~~~");
            return;
        }
        rear++; //让rear 往后移动一位
        arr[rear] = n; //以后移后的rear作为数组下标进行赋值
    }

    //4. 获取队列的数据,出队列
    public int getQueue() {
        //判断队列是否为空//抛出异常
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        front++; //front后移 出队列
        return arr[front];
    }

    //5. 显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空的 没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据,注意不是取出数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的,没有数据~~~~");
        }
        return arr[front + 1]; //front并没有直接指向数据,而是数据前一位,所以需要+1
    }

}