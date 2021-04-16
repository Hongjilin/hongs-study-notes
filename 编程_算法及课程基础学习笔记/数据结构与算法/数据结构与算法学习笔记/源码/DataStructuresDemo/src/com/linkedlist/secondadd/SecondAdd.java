package com.linkedlist.secondadd;

/**
 * 演示最基础的链表插入,插入到链表的最后面,不考虑顺序
 */
public class SecondAdd {
    public static void main(String[] args) {
        //先创建节点对象,一个节点就是一个节点英雄
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建链表对象
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //1. 不按顺序添加:方法一
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        //2. 添加方法二
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero4);
        //调用打印
        singleLinkedList.list();
        //3. 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        System.out.println("测试修改后的");
        singleLinkedList.list();
        //4. 删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("删除后的链表情况~~");
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
     * 3. 添加节点到单链表后-----------------弃用的,用来对比`addByOrder()`
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

    //4. 添加节点到单链表后,按no排序
    public void addByOrder(HeroNode heroNode) {
    /*因为head节点是不能动的,动了的话链表就找不到入口或者找错路口,所以我们需要一个辅助遍历
       因为单链表,所以我们找的temp 必须为于添加位置的前一个节点,否则插入不了*/
        HeroNode temp = head;
        boolean flag = false; //flag标识添加的编号是否存在,默认为false
        while (true) {
            if (temp.next == null) break;//说明temp已经在链表的最后,就在链表插入(此时temp已经在链表尾部了)
            if (temp.next.no > heroNode.no) break;//说明位置已经找到,就在temp的后面插入
            else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//temp后移,直到找到符合上面条件为止
        }
        if (flag) System.out.printf("准备插入的英雄的编号%d已经存在了,不能加入\n", heroNode.no);
        else {
            //将heroNode插入到链表的temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //5. 修改节点信息,根据no编号来修改,即no编号不能改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        ;
        //定义一个辅助变量
        HeroNode temp = head;
        boolean flag = false;
        //找到需要修改的节点,根据no编号
        while (true) {
            if (temp == null) break; //表示当前到链表尾端
            if (temp.no == newHeroNode.no) {//表示找到该节点了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//根据flag可以判断是否找到要修改的节点
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else System.out.printf("没有找到编号%d的阶段,不能进行修改\n", newHeroNode.no);
    }

    //6. 删除节点1.head不能动,所以需要一个temp辅助节点找到待删除节点前的一个节点
    //         2.我们比较时,时temp.next.no和待删除节点的no比较
    public void del(int no) {
//        if (head.next == null) {
//            System.out.println("链表为空");
//            return;
//        }此处可以不加,与下面代码功能重复
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) break;//说明到了链表的最后
            if (temp.next.no == no) {
                //表示找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移,遍历
        }
        if (flag) temp.next = temp.next.next; //如果找到,进行删除
        else System.out.printf("要删除的%d节点不存在\n", no);
    }

    //7. 显示链表[遍历]
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

