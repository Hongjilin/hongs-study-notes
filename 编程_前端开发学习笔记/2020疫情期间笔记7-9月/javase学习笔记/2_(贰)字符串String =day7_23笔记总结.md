# ---------------==(Java贰)==------------------

# 字符串String =>day7_23笔记总结

## 一.字符串(String)类:

##### 		1.字符串用途:

​				a.用于字符串常量,也就是说字符串的值不会改变

##### 		2. String代码解释=>

```java
/*1.赋值时相当于执行一次new操作*/
String name=new  String()
name="hong"  
=>name=new String("hong")

/*2.当赋值为""时,有创建空间,只是里面没有值*/
String name="";
=>String name= new String("")

/*3.赋值为null时相当于没有创建空间*/
String name=null;=>String name;

/*4.引用类型判断时,通常都要先判断是否为空再判断空字符串*/
if(name!=null&&name.equal(""))
```

##### 		3.字符串主要构造函数方法=>

| 方法                                          | 说明                                                         |
| :-------------------------------------------- | :----------------------------------------------------------- |
| String()                                      | 生成一个空串                                                 |
| String(String  value)                         | 用已知串生成一个串对象                                       |
| String(char value[])                          | 用字符数组生成一个串对象                                     |
| String(char value[] , int offset , int count) | 用字符数组value的offset位置开始的count个字符,建立一个字符串对象,之后并不影响原来的字符串数组 |
| String(StringBuffer  value)                   | 用已经存在的StringBuffer对象初始化String对象                 |
|                                               |                                                              |



##### 4.字符串比较方法=>

1.   equals()=>  检查组成字符串内容的字符是否一致
2.   "=="符号比较=>  判断两个字符串在内存中的首地址,即判断是否是同一个字符串对象
3.   equalslgnoreCase()方法=>  忽略大小写比较
4.   toLowerCase()方法=>  将双方变为小写字符比较
5.   toUpperCase()方法=>  将双方变为大写字符比较
6.   compareTo()方法=> 按字典顺序比较两个字符串

##### 5.字符串连接方法=>

1.   使用"+"
2.   使用String类的concat()方法

##### 6.字符串常用提取方法=>

| 方法                                                         | 说明                                                         |
| ------------------------------------------------------------ | :----------------------------------------------------------- |
| public int **indexOf**(int ch)<br />public int **indexOf**(String value) | 搜索第一个出现的字符ch(或字符串value)                        |
| public int **lastIndexOf**(int ch)<br />public int **lastIndexOf**(String value) | 搜索最后一个出现的字符ch(或字符串value)                      |
| public char **charAt**(int index)                            | 查找字符串的第index个字符                                    |
| public String **substring**(int index)                       | 提取从位置索引开始的字符串部分                               |
| public String **substring**(int beginindex,int endindex)     | 提取beginindex和endindex之间的字符串部分                     |
| public String **trim**()                                     | 返回一个前后不含任何空格的调用字符串的副本                   |
| public boolean **startWith**(String prefix)<br />public boolean **endWith**(String suffix) | 测试字符串的起始字符串和结束字符串(验证开头和结尾是否为输入的字符出啊) |
| public String **replace**(char oldChar , char new Char)      | 字符串替换                                                   |
| String.**split**(char value)                                 | 字符串拆分                                                   |





## 二.StringBuffer类(String增强版)

##### 	1.StringBuffer用途

​		a.用于字符串变量,也就是说字符串的值可以改变

##### 	2.StringBuffer的代码声明与使用=>

```java
/*1.StringBuffer的声明*/
StringBuffer sb=new StringBuffer();//创建空StringBuffer对象
StringBuffer sb=new StringBuffer(5);//创建长度为5StringBuffer对象
StringBuffer sb=new StringBuffer("hello World");//创建一个变量存储字符串"hello World"

/*2.StringBuffer的使用*/
sb.toString();//转化为String类型
sb.append("**");//追加字符串
```

##### 	3.StringBuffer类的常用方法=>

| 方法                                                         | 说明                                                      |
| ------------------------------------------------------------ | --------------------------------------------------------- |
| **setLength**(int newlength)                                 | 重新设置字符串的长度,新串会为旧串的截余(常用来截取前几位) |
| **setCharAt**(int index, char ch)                            | 重设指定位置的字符串                                      |
| **append**(Object obj)                                       | 将指定对象转化为字符串添加到原串尾部                      |
| **insert**(int offset ,Object obj)                           | 将指定对象转换为字符串,然后插入到从offset开始的位置       |
| **capacity**                                                 | 求字符串容量(不等于字符串长度)                            |
| **deleteCharAt**( int index)<br />**delete**(int start,int end) | 删除字符                                                  |
| **reverse()**                                                | 翻转字符串                                                |
|                                                              |                                                           |
|                                                              |                                                           |
