package com.linkedlist.firstadd;

/**
 * 演示最基础的链表插入,插入到链表的最后面,不考虑顺序
 */
public class FirstAdd {
    public static void main(String[] args) {
        //先创建节点对象,一个节点就是一个节点英雄
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建链表对象
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //不按顺序添加
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        //调用打印
        singleLinkedList.list();
    }
}

//一、定义一个HeroNode,每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方法,我们重新toString
    @Override
    public String toString() {
        return "HeroNode[no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
    }

}
//二、定义SingleLinkedList管理我们的英雄
class SingleLinkedList {
    //1. 先初始化一个头节点,头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");
    //2. 返回头节点,get方法
    public HeroNode getHead() {
        return head;
    }

    /**
     * 3. 添加节点到单链表后
     * 思路:不考虑编号顺序,直接插入到链表最后
     * 1)找到当前链表的最后节点
     * 2)将最后这个节点的next指向新的节点
     */
    public void add(HeroNode heroNode) {
        //因为head节点是不能动的,动了的话链表就找不到入口或者找错路口,所以我们需要一个辅助遍历
        HeroNode temp = head;
        //遍历链表,找到最后
        while (true) {
            //找到链表的最后:当next值为空,就是最后一位
            if (temp.next == null) break;
            //如果没有找到最后,就将temp向后移动,不然就原地踏步死循环了
            temp = temp.next;
        }
        //当退出while循环的时候,temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }

    //4. 显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动且头节点是没有数据的,所以直接`head.next;`
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) break;
            //输出节点信息
            System.out.println(temp);
            //将temp后移,一定小心
            temp = temp.next;
        }
    }
}

