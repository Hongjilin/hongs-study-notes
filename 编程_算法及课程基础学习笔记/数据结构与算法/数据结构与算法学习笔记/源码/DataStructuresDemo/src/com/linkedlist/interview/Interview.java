package com.linkedlist.interview;

import java.net.HttpRetryException;
import java.util.Stack;

/**
 * 此部分是面试题
 */
public class Interview {
    public static void main(String[] args) {
        //先创建节点对象,一个节点就是一个节点英雄
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "洪吉林", "帅哥");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "洪吉林", "帅哥");
        HeroNode hero6 = new HeroNode(6, "努力学习的汪", "好学生");
        HeroNode hero7 = new HeroNode(7, "离婚且带娃", "不是我");
        HeroNode hero8 = new HeroNode(8, "你听我狡辩", "口头禅");
        //创建链表对象
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        //1. 不按顺序添加:方法一
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        //2. 添加方法二
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero7);
        singleLinkedList.list();
        System.out.println("两个链表分界线");

        //-----------课后作业:第二个链表-----------------------
        singleLinkedList1.addByOrder(hero2);
        singleLinkedList1.addByOrder(hero5);
        singleLinkedList1.addByOrder(hero6);
        singleLinkedList1.addByOrder(hero8);
        singleLinkedList1.list();
        System.out.println("合并两个链表");
        staticList(mergeLinkedList(singleLinkedList.getHead(), singleLinkedList1.getHead()));
//        //3. 测试修改节点的代码
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
//        singleLinkedList.update(newHeroNode);
//        System.out.println("测试修改后的");
//        singleLinkedList.list();
//        //4. 删除一个节点
//        singleLinkedList.del(1);
////        singleLinkedList.del(4);
//        System.out.println("删除后的链表情况~~");
//        singleLinkedList.list();
//
//        //5. 测试一下 求单链表中有效节点的个数
//        System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2
//        //6. 测试一下看看是否得到了倒数第K个节点
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
//        System.out.println("res=" + res);
//        //7. 测试一下单链表的反转功能
//        System.out.println("原来链表的情况~~");
//        singleLinkedList.list();
//        System.out.println("反转单链表~~");
//        reverseLinkedHead(singleLinkedList.getHead());
//        singleLinkedList.list();
//        //8.测试逆序打印单链表, 没有改变链表的结构~~
//        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
//        reversePrint(singleLinkedList.getHead());
    }

    /**
     * 合并两个单链表
     *
     * @param head1 传入第一个链表头节点
     * @param head2 传入第二个链表头节点
     * @return 返回合并后的链表
     */
    public static HeroNode mergeLinkedList(HeroNode head1, HeroNode head2) {
        if (head1 == null) return head2; //此处是递归,不能按head.next==null进行判断,否则会造成数据丢失
        if (head2 == null)   return head1;
        if (head1.no <= head2.no) {
            //如果不加这个判断,如果两者的no相同,将会导致出现重复的数据(如两个),
            //打印代码System.out.println("head"+head+",head.next"+head.next);  打印结果 headHeroNode[no=0,name=,nickname=],head.nextHeroNode[no=0,name=,nickname=]
            head1.next = (head2.no != head1.no) ? mergeLinkedList(head1.next, head2) : mergeLinkedList(head1.next, head2.next);
//            head1.next= mergeLinkedList(head1.next, head2);  犯下的错误
            return head1;
        } else {
            head2.next = mergeLinkedList(head1, head2.next);
            return head2;
        }
    }

    /**
     * 遍历打印静态链表
     *
     * @param head 传入打印的链表头节点
     */
    public static void staticList(HeroNode head) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动且头节点是没有数据的,所以直接`head.next;`
        HeroNode temp = head.next;
        System.out.println("head" + head + ",head.next" + head.next);
        while (true) {
            if (temp == null) break;
            //输出节点信息
            System.out.println(temp + "000");
            //将temp后移,一定小心
            temp = temp.next;
        }
    }

    /**
     * 1. 求单链表中有效节点的个数
     * 方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) return 0; //空链表
        int length = 0; //声明一个累加器
        //定义一个辅助的变量,这里我们没有统计头节点(-->head.next)
        HeroNode cur = head.next;
        while (cur != null) {//当当前节点 为空时退出累计遍历
            length++;
            cur = cur.next;
        }
        return length;
    }

    ;

    /**
     * 2. 查找单链表中的倒数第k个结点
     *
     * @param head 要进行查找的单向链表
     * @param K    传入倒数第几位 数字
     * @return 该位置的节点
     */
    public static HeroNode findLastIndexNode(HeroNode head, int K) {
        if (head.next == null) return null; //空链表,无法找到
        //1. 获得链表的长度(总个数)
        int size = getLength(head);
        //2. 做一个K的校验,明显K不能为负数以及大于总长度
        if (K <= 0 || K > size) return null;
        //3. 定义给辅助变量
        HeroNode cur = head.next;
        //4. 遍历 倒数第K个节点 就是`size-K`的位置
        for (int i = 0; i < (size - K); i++) {
            cur = cur.next; //cur后移到符合条件的位置
        }
        return cur;
    }

    ;

    /**
     * 3.单链表的反转【腾讯面试题，有点难度】
     *
     * @param head 传入需要进行反转的单链表
     */
    public static void reverseLinkedHead(HeroNode head) {
        //1. 当链表为空或者只有一个节点时候,直接返回,无需反转
        if (head.next == null || head.next.next == null) return;
        //2. 定义一个辅助的指针遍历,帮助我们遍历原来的链表
        HeroNode cur = head.next;
        //3. 定义一个next,辅助变量,来指向当前节点[cur]的下一个节点,用来进行位置互换
        HeroNode next = null;
        //4. 初始化一个新的头节点,用来暂时存放反转链表
        HeroNode reverseHead = new HeroNode(0, "", "");
        //5. 遍历原来的链表,每遍历一个节点,就将其取出,并放在新的链表reverseHead的最前端
        while (cur != null) {//当当前节点 为空时退出累计遍历
            next = cur.next; //先暂时保存当前节点的下一个节点,后面换完位置后需要复原cur的下一位,否则无法遍历
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;//将cur链接到新的链表上
            cur = next;//让cur后移
        }
        //遍历结束,将head.next指向reverseHead.next 接管链表,实现单链表的反转
        head.next = reverseHead.next;
    }


    /**
     * 4. 可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
     *
     * @param head 要传入的链表头
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) return; //空链表 不能打印
        //创建一个栈,将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;//cur后移,这样就可以压入下一个节点
        }
        //将栈中节点取出打印.利用其先进后出特点,实现逆序da'yin
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
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

