package com.linkedlist.doublelinked;


public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "林冲", "豹子头");
        DoubleHeroNode hero5 = new DoubleHeroNode(5, "666", "666");
        //创建链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //1.直接添加到链表尾部
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();
        //修改测试
        System.out.println("测试修改林冲");
        DoubleHeroNode newHeroNode = new DoubleHeroNode(4, "洪吉林", "零充");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();
        //删除测试
        System.out.println("测试删除吴用");
        doubleLinkedList.del(3);
        doubleLinkedList.list();
        //测试插入添加
        //1.直接添加到链表尾部
        System.out.println("测试插入添加 ");
        doubleLinkedList.addByOrder(hero5);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    //1. 先初始化一个头节点,头节点不要动,不存放具体的数据
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    //2. 返回头节点,get方法
    public DoubleHeroNode getHead() {
        return head;
    }

    //3. 添加一个节点节点到双向链表的最后
    public void add(DoubleHeroNode heroNode) {
        //因为head节点是不能动的,动了的话链表就找不到入口或者找错路口,所以我们需要一个辅助遍历
        DoubleHeroNode temp = head;
        //遍历链表,找到最后
        while (true) {
            //找到链表的最后:当next值为空,就是最后一位
            if (temp.next == null) break;
            //如果没有找到最后,就将temp向后移动,不然就原地踏步死循环了
            temp = temp.next;
        }
        //当退出while循环的时候,temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //3.1 按照no进行对双向链表的插入
    public void addByOrder(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = head;//需要找到要添加位置的前一个节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) break;//说明已经遍历到链表最后
            if (temp.next.no > heroNode.no) break;//说明已经找到,就在temp后面插入
            else if (temp.next.no == heroNode.no) {//说明已经存在重复no
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) System.out.printf("准备插入的英雄的编号%d已经存在了,不能加入\n", heroNode.no);
        else {
            heroNode.next = temp.next; //将temp的下next赋值到要插入的节点的next
            heroNode.pre = temp;  //将temp作为heroNode的pre(上一位)
            temp.next = heroNode; //在找到的位置后面插入heroNode ,并且这里不用判断非空
        }


    }

    //4. 修改节点信息,
    //可以看到双向链表的节点内容修改与单向链表一样,只是节点类型改变
    public void update(DoubleHeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode temp = head;
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

    /**
     * 5. 从双向链表中删除一个节点
     * 说明:
     * 1.对于双向链表,我们可以直接找到要删除的这个节点
     * 2.找到后,自我删除即可
     */
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空,无法删除");
            return;
        }
        DoubleHeroNode temp = head;//辅助遍历(指针)
        boolean flag = false;//标识是否找到待删除节点
        while (true) {
            if (temp == null) break;//已经到了链表最后
            if (temp.no == no) { //找到待删除的节点
                flag = true;
                break;
            }
            temp = temp.next;//temp后移,遍历
        }
        if (flag) {
            temp.pre.next = temp.next;//将下一个节点地址赋值给上一个节点的`next`
            //如果不加判断,可能当前节点是最后一个,导致`temp.next.pre`会出现空指针异常
            if (temp.next != null) temp.next.pre = temp.pre;//将下一个节点的上一个(pre)赋值为当前节点的上一个(pre)
        } else System.out.printf("要删除的%d节点不存在\n", no);

    }

    //7. 显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动且头节点是没有数据的,所以直接`head.next;`
        DoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null) break;
            //输出节点信息
            System.out.println(temp);
            //将temp后移,一定小心
            temp = temp.next;
        }
    }

}


//一、定义一个HeroNode,每个HeroNode对象就是一个节点
class DoubleHeroNode {
    public int no;
    public String name;
    public String nickname;
    public DoubleHeroNode next;//指向下一个节点,默认为null
    public DoubleHeroNode pre;//指向前一个节点,默认为null

    //构造器
    public DoubleHeroNode(int no, String name, String nickname) {
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