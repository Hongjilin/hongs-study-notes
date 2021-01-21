# ------------------==(Java玖)==---------------------

# 异常、log4j使用=>day8_7

### 一、Java如何进行异常处理

Java异常机制用到的几个关键字：try、catch、finally、throw、throws。

>-  **try**     -- 用于监听。将要被监听的代码(可能抛出异常的代码)放在try语句块之内，当try语句块内发生异常时，异常就被抛出。
>- **catch**  -- 用于捕获异常。catch用来捕获try语句块中发生的异常。
>- **finally** -- finally语句块总是会被执行。它主要用于回收在try块里打开的物力资源(如数据库连接、网络连接和磁盘文件)。只有finally块，执行完成之后，才会回来执行try或者catch块中的return或者throw语句，如果finally中使用了return或者throw等终止方法的语句，则就不会跳回执行，直接停止。
>- **throw**  -- 用于抛出异常。
>- **throws** -- 用在方法签名中，用于声明该方法可能抛出的异常。**主方法上也可以使用throws抛出。**如果在主方法上使用了throws抛出，就表示在主方法里面可以不用强制性进行异常处理，如果出现了异常，就交给JVM进行默认处理，则此时会导致程序中断执行



### 二、异常的使用及执行流程

###### **1、异常的处理方案**

```
try...catch、try...catch...finally、try...finally
   try{
     可能会发生的异常
   }catch(异常类型 异常名(变量)){
     针对异常进行处理的代码
   }catch(异常类型 异常名(变量)){
     针对异常进行处理的代码
   }...
  [finally{
     释放资源代码；
   }]
```

###### 注意：

- catch 不能独立于 try 存在。
- catch里面不能没有内容
- 在 try/catch 后面添加 finally 块并非强制性要求的。
- try 代码后不能既没 catch 块也没 finally 块。
- try里面越少越好。
- try, catch, finally 块之间不能添加任何代码。
- finally里面的代码最终一定会执行（除了JVM退出）
- 如果程序可能存在多个异常，需要多个catch进行捕获。
- 异常如果是同级关系，catch谁前谁后没有关系
  如果异常之间存在上下级关系，上级需要放在后面

###### **2、异常的执行流程**

![img](https://img-blog.csdnimg.cn/20190316111318681.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N1Z2FyX25vMQ==,size_16,color_FFFFFF,t_70)



### 三、异常方法

下面的列表是 Throwable 类的主要方法:

| **序号** | **方法及说明**                                               |
| :------- | :----------------------------------------------------------- |
| 1        | **public String getMessage()** 返回关于发生的异常的详细信息。这个消息在Throwable 类的构造函数中初始化了。 |
| 2        | **public Throwable getCause()** 返回一个Throwable 对象代表异常原因。 |
| 3        | **public String toString()** 使用getMessage()的结果返回类的串级名字。 |
| 4        | **public void printStackTrace()** 打印toString()结果和栈层次到System.err，即错误输出流。 |
| 5        | **public StackTraceElement [] getStackTrace()** 返回一个包含堆栈层次的数组。下标为0的元素代表栈顶，最后一个元素代表方法调用堆栈的栈底。 |
| 6        | **public Throwable fillInStackTrace()** 用当前的调用栈层次填充Throwable 对象栈层次，添加到栈层次任何先前信息中。 |

### 四、Java 内置异常类

| **异常**                        | **描述**                                                     |
| :------------------------------ | :----------------------------------------------------------- |
| `ArithmeticException`           | 当出现异常的运算条件时，抛出此异常。例如，一个整数"除以零"时，抛出此类的一个实例。 |
| ArrayIndexOutOfBoundsException  | 用非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引。 |
| ArrayStoreException             | 试图将错误类型的对象存储到一个对象数组时抛出的异常。         |
| ClassCastException              | 当试图将对象强制转换为不是实例的子类时，抛出该异常。         |
| IllegalArgumentException        | 抛出的异常表明向方法传递了一个不合法或不正确的参数。         |
| IllegalMonitorStateException    | 抛出的异常表明某一线程已经试图等待对象的监视器，或者试图通知其他正在等待对象的监视器而本身没有指定监视器的线程。 |
| IllegalStateException           | 在非法或不适当的时间调用方法时产生的信号。换句话说，即 Java 环境或 Java 应用程序没有处于请求操作所要求的适当状态下。 |
| IllegalThreadStateException     | 线程没有处于请求操作所要求的适当状态时抛出的异常。           |
| `IndexOutOfBoundsException`     | 指示某排序索引（例如对数组、字符串或向量的排序）超出范围时抛出。 |
| NegativeArraySizeException      | 如果应用程序试图创建大小为负的数组，则抛出该异常。           |
| NullPointerException            | 当应用程序试图在需要对象的地方使用 `null` 时，抛出该异常     |
| `NumberFormatException`         | 当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常。 |
| SecurityException               | 由安全管理器抛出的异常，指示存在安全侵犯。                   |
| StringIndexOutOfBoundsException | 此异常由 `String` 方法抛出，指示索引或者为负，或者超出字符串的大小。 |
| UnsupportedOperationException   | 当不支持请求的操作时，抛出该异常。                           |
| ClassNotFoundException          | 应用程序试图加载类时，找不到相应的类，抛出该异常。           |
| CloneNotSupportedException      | 当调用 `Object` 类中的 `clone` 方法克隆对象，但该对象的类无法实现 `Cloneable` 接口时，抛出该异常。 |
| IllegalAccessException          | 拒绝访问一个类的时候，抛出该异常。                           |
| InstantiationException          | 当试图使用 `Class` 类中的 `newInstance` 方法创建一个类的实例，而指定的类对象因为是一个接口或是一个抽象类而无法实例化时，抛出该异常。 |
| InterruptedException            | 一个线程被另一个线程中断，抛出该异常。                       |
| NoSuchFieldException            | 请求的变量不存在                                             |
| NoSuchMethodException           | 请求的方法不存在                                             |



### 五、异常相关问题

##### 5.1)Error与Exception的区别：

> Error（错误）是系统中的错误，程序员是不能改变的和处理的，是在程序编译时出现的错误，只能通过修改程序才能修正。一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢等。对于这类错误的导致的应用程序中断，仅靠程序本身无法恢复和和预防，遇到这样的错误，建议让程序终止。
>
> Exception（异常）表示程序可以处理的异常，可以捕获且可能恢复。遇到这类异常，应该尽可能处理异常，使程序恢复运行，而不应该随意终止异常。



##### **5.2)在catch捕获异常时，为什么不考虑使用Throwable类型，而只是使用Exception来进行接收？**

> Throwable表示的范围要比Exception大。实际上程序使用Throwable来进行处理，没有任何语法问题，但是却会存在逻辑问题。因为此时出现的（或者说用户能够处理的）只有Exception类型，而如果使用Throwable接收，还会表示可以处理Error的错误，而用户是处理不了Error错误的，所以在开发中用户可以处理的异常都要求以Exception类为主。

##### **5.3)异常是一起处理好还是分开处理好？**

> **根据实际的开发要求是否严格来决定。**在实际的项目开发项目工作中，所有的异常是统一使用Exception处理还是分开处理，完全根据开发者的项目开发标准来决定。如果项目开发环境严谨，基本上要求针对每一种异常分别进行处理，并且要详细记录下异常产生的时间以及产生的位置，这样可以方便程序维护人员进行代码的维护。**再次注意：处理多个异常时，捕获范围小的异常要放在捕获范围大的异常之前处理。**

##### **5.4)throw和throws的区别？**

> throw和throws都是在异常处理中使用的关键字，区别如下：
>
> - throw：指的是在方法中人为抛出一个异常对象（这个异常对象可能是自己实例化或者抛出已存在的）；
> - throws：在方法的声明上使用，表示此方法在调用时必须处理异常。



##### **5.5)检查型异常（Checked Exception）与非检查型异常（Unchecked Exception）区别？**

>- 所有的检查性异常都继承自java.lang.Exception；所有的非检查性异常都继承自java.lang.RuntimeEx ception。
>- 检查性异常和非检查性异常最主要的区别在于其处理异常的方式：检查性异常必须使用try catch或者throws等关键字进行处理，否则编译器会报错;非检查性异常一般是程序代码写的不够严谨而导致的问题，可以通过修改代码来规避。
>- 常见的运行时异常：空指针异常(NullPointerException)、除零异常(ArithmeticException)、数组越界异常(ArrayIndexOutOfBoundsException)等;
>- 常见的检查性异常：输入输出异常(IOException)、文件不存在异常(FileNotFoundException)、SQL语句异常(SQLException)等。



### 六、自定义异常

在 Java 中你可以自定义异常。如果要自定义异常类，则扩展Exception类即可，因此这样的自定义异常都属于检查异常（checked exception）。如果要自定义非检查异常，则扩展自RuntimeException。

按照国际惯例，自定义的异常应该总是包含如下的构造函数：

- 一个无参构造函数
- 一个带有String参数的构造函数，并传递给父类的构造函数。
- 一个带有String参数和Throwable参数，并都传递给父类构造函数
- 一个带有Throwable 参数的构造函数，并传递给父类的构造函数。

下面是IOException类的完整源代码，可以借鉴。

```java
package java.io;

public class IOException extends Exception {
    static final long serialVersionUID = 7818375828146090155L;

    public IOException() {
	super();
    }
    public IOException(String message) {
	super(message);
    }
    public IOException(String message, Throwable cause) {
        super(message, cause);
    }
    public IOException(Throwable cause) {
        super(cause);
    }

}
```

**finally块和return**

- 首先一个不容易理解的事实：在 try块中即便有return，break，continue等改变执行流的语句，finally也会执行。
- finally中的return 会覆盖 try 或者catch中的返回值。
- finally中的return或异常会抑制（消灭）前面try或者catch块中的异常。

### 七、logger4j使用步骤

使用log4j的步骤

第一步 :在项目中加入log4j,所使用的JAR文件

第二步:创建log4j.properties文件(在src目录下)

第三步,编写log4j.properties,配置日志信息:

```
### \u8BBE\u7F6ELogger\u8F93\u51FA\u7EA7\u522B\u548C\u8F93\u51FA\u76EE\u7684\u5730 ###
log4j.rootLogger=debug,stdout,logfile

### \u628A\u65E5\u5FD7\u4FE1\u606F\u8F93\u51FA\u5230\u63A7\u5236\u53F0 ###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.err
log4j.appender.stdout.layout=org.apache.log4j.SimpleLayout

### \u628A\u65E5\u5FD7\u4FE1\u606F\u8F93\u51FA\u5230\u6587\u4EF6\uFF1Ajbit.log ###
log4j.appender.logfile=org.apache.log4j.FileAppender
log4j.appender.logfile.File=log.log
log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
log4j.appender.logfile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %l %F %p %m%n

```

![image-20200808232232610](../../AppData/Roaming/Typora/typora-user-images/image-20200808232232610.png)

第四步：创建Logger对象

```
		Logger logger = Logger.getLogger(类.class.getName());
```

第五步：调用方法：logger.debug(message);