> 此笔记为 本人洪详细学习Git阶段记录笔记
>
>  									始于:2021-1-27    截至:`更新中`

# Git详细学习(`更新中`)

## 一、初始化

> 该处是用来提交时当作签名使用的

```
git config --global user.name "我的用户名"
git config --global user.email "我的邮箱"
```

## 二、区域

1. 工作区
2. 暂存区
3. 版本库

## 三、对象

### 1、git对象

> 1. key:val 组成的键值对(key是val相应的hash)
>
> ​		键值对在git内部是blob类型(git特有)
>
> 2. 存储数据文件内容,也称为数据对象

##### ① 直接写入git对象方法与读取(存入".git/objects")

```shell
#将打印内容写入对象(git数据库)并且返回其相应哈希值
echo "写入的对象内容" | git hash-object -w --stdin 
#读取内容并不能直接cat读取,因为git存入时已经加密,需要如下代码 -p:内容  -t:类型
git cat-file -p 存入对象的哈希值(此值可以由上一步得到) 
#将文件写入git对象,即我们常见的版本控制中出现的
git hash-object -w ./test.txt
#查看Git存储的数据  返回其文件夹内的所有哈希文件
find .git/objects -type f 
```

### 2、树对象

> 树对象是存储键值 作用为控制版本,如我们的版本前回退 就是在操作这个对象的(指向改变)
>
> 作用就是生成快照

#### 构建树对象

> 我们可以通过 update-index , write-tree , read-tree 等命令来构建树对象并且塞到暂存区

##### ① 利用 `update-index` 命令 创建暂存区

>利用 `update-index` 命令 为test.txt文件的首个版本创建一个暂存区,并通过`write-tree`命令生成树对象

```shell
#1生成一个树对象
git update-index --add --cacheinfo 100664(文件状态码:普通文件) 哈希值 对应文件名
#生成快照(树对象)
git write-tree
#2 将第一个树对象加入第二个树对象,使其成为新的树对象
git read-tree -prefix=bak 哈希值(树对象的)  
git write-tree
```

##### ②查看暂存区当前样子

```shell
git ls-files -s
```

### 3、提交对象

> 1. 通过上述两个对象操作后,你会发现你已经生成了不同项目的快照,但是问题是:如果想重用这些快照,你必须记住所有三个 SHA-1(快照)哈希值 .但是,你也完全不知道是谁保存了这些快照,在什么时刻保存的,以及为什么保存这些快照.而以上这些,正是提交对象(commit object)能为你保存的基本信息
>2. 我们可以通过调用commit-tree命令创建一个提交对象,为此需要指定一个树对象的SHA-1值,为此需要指定一个树对象的SHA-1值 , 以及该提交的父提交对象(如果有的话,第一次将暂存区做快照就没有父对象)
> 3. 真正的一个版本其实就是提交对象

##### ①创建提交对象

```shell
echo "first commit" |git commit-tree 树对象的哈希值
```

②指定一个树对象的SHA-1值 , 以及该提交的父提交对象

```shell
echo "second commit" | git commit-tree 提交的树对象哈希值 -p 父亲树对象哈希值
```

## 四、高层命令

### 1、git add  

>1. 会将工作目录的修改,保存成git对象 `先到版本库,再到暂存区`,而不是直接到暂存区
>
>2. 在工作目录修改几个文件,就会生成几个git对象(一个文件对应一个git文件)
>
>3. 同一个文件,每次修改再add的时候都会生成一个新的git对象,是增量而不是覆盖
>4. 所以说git是绝对安全的,就算我只存到暂存区没有提交 git也会给我保存
>5. 只有后面提交的时候,才会根据暂存区内容给我生成树对象并存入版本区,然后加上我们的提交信息,才生成提交对象存入版本库

```shell
#相当于以下两个命令集合
git hash-object -w 文件名(修改了多少个工作目录中的文件,就要被执行几次)
git update-index ...
```

### 2、 git  commit -m "注释内容"

> 将暂存区提交到版本库

```shell
git write-tree
git commit-tree
```

> 跳过暂存区存入

```shell
git commit -a
```

### 3、git init 

> 初始化仓库 初始化后,在当前目录下出现一个名为.git的文件夹

### 4、git status

> 查看文件的状态

### 5、git diff

1. 当前做的那些更新没有暂存?

    命令:`git diff`(不加参数直接输入git diff)

2. 有哪些更新已经暂存起来准备好了下次提交

   命令:`git diff --cached`或者`git diff --staged(1.6.1以上版本)`

### 6、git log

> 1. `git log`(不带参数)
>
>    `空格键`往下翻页 `b`向上翻页 `q`退出日志查阅
>
> 2. git log --oneline 
>
>    将日志信息拍成一行显示
>
> 3. git reflog
>
>    所有的日志信息

### 7、git rm 

> 删除工作目录对应的文件,再将修改添加到暂存区(默认删除后给你用了git add 文件名)

```shell
#删除命令
git rm 文件名 
#直接提交修改,因为rm命令帮你提交到暂存区了
git commit -m "xxx"
```

### 8、git mv

>将工作目录中的文件进行重命名,再将修改添加到暂存区

```shell
git mv 原文件名  新文件名
```



## 五、分支

