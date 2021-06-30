package com.linkedlist.josepfu;

public class Josepfu {
    public static void main(String[] args) {
         int NUM=5;
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(NUM);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();
        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, NUM); // 2->4->1->5->3
    }
}

//二、创建一个环形的单向链表
class CircleSingleLinkedList {
    //1. 创建一个first节点,当前没有编号
    private Boy first = null;

    //2. 添加小孩节点,构建成一个环形的链表
    public void addBoy(int nums) {
        //nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; //辅助指针,帮助构建环形链表
        //使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {//i从1开始,才能得到编号与数字顺序一样的no;
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) { //如果fori从0开始遍历,这里也要改为i==0,否则下面 `curBoy.setNext(boy);`将空指针异常
                first = boy;
                first.setNext(first); //构成环,即只有一个时自己指向自己
                curBoy = first;
            } else {
                boy.setNext(first); //将当前次循环的next指向第一个节点形成环
                curBoy.setNext(boy);//此处curBoy标记的是上一次循环的boy 如`i==2`-->curBoy==first、`i==3`-->curBoy==boy(第二个)
                curBoy = boy;  //这一步是移动当前curBoy位置到boy,保存当前boy 用作在下轮循环中指定当前boy的next
            }
        }
    }

    //3. 遍历当前环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩~~~~");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) break;
            curBoy = curBoy.getNext();//curBoy后移
        }
    }

    /**
     * //4. 根据用户输入,计算小孩出圈的顺序
     *
     * @param startNo  开始的位置
     * @param countNum 每次循环的数字
     * @param nums     单纯用来校验循环次数是否多于总长度
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误,请重新输入");
            return;
        }
        //①创建一个辅助指针,帮助完成小孩出圈
        Boy helper = first;
        //②将辅助指针事先指向环形列表的最后这个节点(即next指向first)
        while (true) {
            if (helper.getNext() == first) break;//说明helper指向最后的小孩节点
            helper = helper.getNext();
        }
        //③小孩报数前,先让first和helper移动K-1次(如果我是从3开始,我需要事先指向3的位置)
        //为什么是K-1次-->因为循环i是从0开始的
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //④当小孩报数是,让first和helper指针同时移动m-1次,然后出圈
        while (true) {
            if (helper == first) break; //说明圈中只有一个节点
            //让first和helper指针同时移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //出了for循环后,此时first指向的节点就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //此时将first指向的小孩节点出圈
            first = first.getNext();
            //注意:此处用的时setNext-->这步就是删除操作,原来的first指向的节点没有任何引用的时候,就会被回收
            helper.setNext(first);


        }
        System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());

    }


}


//一、创建一个Boy类,表示一个节点
class Boy {
    private int no;//编号
    private Boy next; //指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}