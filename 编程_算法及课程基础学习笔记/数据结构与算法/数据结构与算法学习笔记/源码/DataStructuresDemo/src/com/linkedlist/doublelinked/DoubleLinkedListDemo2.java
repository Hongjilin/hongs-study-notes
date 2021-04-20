package com.linkedlist.doublelinked;
/**
 * 课程外思路实现
 */
public class DoubleLinkedListDemo2 {
    public static void main(String[] args) {
        // 构造测试数据
        HeroNode node_1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node_2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node_3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node_4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode node_5 = new HeroNode(5, "洪吉林", "码农");
        HeroNode node_6 = new HeroNode(6, "努力学习的汪", "学习狗");

        System.out.println("===============向环形链表中插入结点==================");
        HeroNode first = insertCircleList(null, node_1);
        first = insertCircleList(first, node_2);
        first = insertCircleList(first, node_3);
        first = insertCircleList(first, node_4);
        first = insertCircleList(first, node_5);
        first = insertCircleList(first, node_6);
        showList(first);

        System.out.println("===============约瑟夫游戏开始===============");
        // 从第 1 个结点开始计数，每次计 3 个数。
        josepfuGame(first, 1, 3);

    }

    /**
     * @Description 1. 约瑟夫游戏开始
     * @Param [first, k, m]   头节点,从第 k 个人开始数，每次数 m 个
     */
    public static void josepfuGame(HeroNode first, int k, int m) {
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode helperNode = first;
        // 首先要移动到第 k 个结点，此时辅助指针初始指向第一个计数的结点
        for (int i = 1; i < k; i++) {
            helperNode = helperNode.next;
        }
        while (helperNode.next.getNo() != helperNode.getNo()) {
            // 报数， m 个数也就是相当于向后移动 m-1 次，也就是要把第 m-1 个结点去掉
            // 由于单链表的特点，要去掉第 m-1 个结点，肯定是要让指针前一个结点，即第(m-2)个结点
            for (int j = 0; j < m - 2; j++) {  // 让指针后移 m-2 个结点
                helperNode = helperNode.next;
            }
            System.out.println(helperNode.next + "退出链表了!");
            // 删除结点
            helperNode.next = helperNode.next.next;
            // 因为下一轮要从刚刚去掉的结点的后面一个结点开始计数了，所以需要让辅助指针初始指向下一轮第一个计数的结点
            helperNode = helperNode.next;
        }
        System.out.println(helperNode + "退出链表了!");
    }

    /**
     * @Description 2. 插入结点到环形链表中，用于构造环形链表
     */
    public static HeroNode insertCircleList(HeroNode first, HeroNode node) {
        // 判断链表是不是为空，如果为空，就直接插入
        if (first == null) {
            first = node;
            // 因为要环形链表，而且只有一个结点，所以要我指向我自己
            first.next = node;
        } else {
            // 如果环形链表不为空
            HeroNode tempNode = first;
            while (true) {
                // 如果到了环形链表的最后一个元素
                if (tempNode.next.getNo() == first.getNo()) {
                    tempNode.next = node;
                    // 因为是环形链表，所以最后一个结点还要指向第一个结点
                    node.next = first;
                    break;
                }
                tempNode = tempNode.next;
            }
        }
        return first;
    }

    /**
     * @Description 3. 打印单向环形链表
     */
    public static void showList(HeroNode first) {
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode tempNode = first;
        while (true) {
            if (tempNode.next.getNo() == first.getNo()) {
                System.out.println(tempNode);
                break;
            }
            System.out.println(tempNode);
            tempNode = tempNode.next;
        }
    }

}


class HeroNode {
    private int no;             // 本节点数据
    private String name;
    private String nickName;
    public HeroNode next;       // 指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    //为了显示方法,我们重新toString
    @Override
    public String toString() {
        return "HeroNode[no=" + no + ",name=" + name + ",nickname=" + nickName + "]";
    }
    // getter and setter and toString
}
