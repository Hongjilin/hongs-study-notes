package com.queue;
import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个环形队列
        System.out.println("创建一个环形队列");
        CircleArrayQueue queue = new CircleArrayQueue(3);
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

class CircleArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾部
    private int[] arr;//该数据用于存放数据,模拟队列

    //创建队列的构造器
    public CircleArrayQueue(int arrMaxSize) {
        //注意:如果要能存3个有效数据,arrMaxSize就要为`4`,因为预留了一个位置,所以需要传入的数字要+1
        maxSize = arrMaxSize + 1;
        arr = new int[maxSize];
        /**
         * 1. 此处front含义做出调整:front指向队列的第一个元素,也就是说arr[front]就是队列的第一个元素,front的初始值为0*
         * 2.此处rear含义做出调整:rear指向队列的最后一个元素的后一个位置,因为希望空出一个空间作为约定(判断栈满栈空),rear的初始值为0
         */
        front = rear = 0;
    }

    //1. 判断队列是否满
    public boolean isFull() {
        //此时队满条件发生变化,因为rear预留了一个位置
        return (rear + 1) % maxSize == front;
    }

    //2. 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 3.获取队列的有效数量
     *
     * @return int  此函数结果用来在 遍历队列数组时防止下标越界
     */
    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }

    //4. 添加数据到队列
    public void addQueue(int n) {
        //判断是否队满
        if (isFull()) {
            System.out.println("队列满,不能加入数据~~~~~");
            return;
        }
        arr[rear] = n;//这里需要先赋值再将rear+1,因为rear指向最后一个有效数据
        //让rear后移一位,但是需要注意`%`,因为栈尾可以回到下标为`0`处,原因看我画的图
        rear = (rear + 1) % maxSize;

    }

    //5. 获取队列数据 出队列(类似删除数组第一位)
    public int getQueue() {
        //判断队列是否为空,抛出异常
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        //这里需要先将`front`的值保存下来(或者直接保存arr[front],再去return),因为front此时对应的是第一个有效数据,如果＋1后再返回,将指向错误的有效数据
        int thisFront = front;
        //front后移,原因与注意点同rear
        front = (front + 1) % maxSize;
        return arr[thisFront];
    }

    //6. 显示所有队列的数据
    public void showQueue() {
        //先判断是否为空
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
            return;
        }
        /**
         * 1.首先front指向队列第一位,所以要从front开始遍历
         * 2.结束
         *
         */
        for (int i = front; i < front + getSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //7. 显示队列的头数据,注意不是取出数据
    public int headQueue() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空的,没有数据~~~~");
        }
        //front是直接指向队列第一位的,所以这里可以直接返回
        return arr[front];
    }


}