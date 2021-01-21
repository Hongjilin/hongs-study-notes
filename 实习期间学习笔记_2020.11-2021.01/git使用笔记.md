



[我的小世界-文章详情 (zengqiang.club)](http://zengqiang.club/blog/35)

# windows使用git上传代码到Github

## 1、安装git，创建仓库，配置ssh

1. 下载地址：https://git-scm.com/downloads 选择自己的系统下载即可，安装直接下一步就好，这里我就不多说
2. 创建仓库首先要创建一个github账号，大家用邮箱即可注册
3. 新建一个仓库![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418121447613.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418121528650.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center)
4. 配置ssh秘钥 这个操作就是让我们的电脑和github进行一个绑定验证 1. 右键->Git Bash Here 2. 需要配置ssh 命令:**ssh-keygen -t rsa -C "email@qq.com"** 3. 默认上次回车就好,出现如下界面即生成了ssh密钥 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418161322952.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) 4. 用记事本打开下图中的密钥路径文件,复制里面的密钥 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418161526723.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) 5. 在GitHub中配置密码,如下图操作 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418162108851.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418162155508.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418162211117.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418162240183.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418162252105.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) 6. 检测配置是否能成功 git输入:**ssh -T git@github.com**,如果第二次配置我们输入yes就好,看到success就成功了 ![在这里插入图片描述](https://img-blog.csdnimg.cn/2020041816262751.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center)

## 2、上传代码

1. 设置username和email，因为github每次commit都会记录他们 输入：**git config --global user.name "your name"** 注册时填写的名字 **git config --global user.email "email@qq.com"** 自己的邮箱、

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418163521116.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418163533999.png#pic_center) 2. 本地操作

- 先创建一个文件夹，进入文件，右键进入git bash命令行
- 通过命令git init把这个文件夹变成Git可管理的仓库(这个时候会现在文件夹下多了一个.git文件夹。它是Git用来跟踪和管理版本库的。如果你看不到，是因为它默认是隐藏文件，那你就需要设置一下让隐藏文件可见)
- 这个时候可以把你的项目复制过来，然后通过git add 命令把项目添加到仓库（git add .把该目录下的所有文件添加到仓库，注意点是用空格隔开的）
- 用git commit -m "first commit" 把项目提交到仓库(引号是提交的日志)
- ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419212204794.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center)

1. 与仓库建立连接 复制ssh地址,打开创建的仓库,复制下图ssh地址 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418164044140.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418164058899.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200418164112482.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) 输入**git remote add origin 刚复制的ssh地址** ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419211354660.png#pic_center)
2. 关联好之后我们就可以把本地库的所有内容推送到远程仓库（也就是Github）上了， 通过：**git push -u origin master** ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419212349282.png#pic_center) 这个时候出现错误了 根据提示,这是由于你新创建的那个仓库里面的README文件不在本地仓库目录中，这时我们可以通过以下命令先将内容合并 **git pull --rebase origin master** 在使用**git push -u origin master**提交（这个时候可能有点慢，稍等片刻） ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419212519209.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) 成功!

刷新自己github ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200419212611867.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzg5ODcz,size_16,color_FFFFFF,t_70#pic_center) **关于github的操作还有很多,大家可以在使用中不断地去学习** **最后希望这篇文章能帮助到您**





# 二、实际操作出现问题

上传-u不上去,pull也下载不来

>先运行 
>
>```
>git branch --set-upstream-to=origin/master master
>
>git pull
>git push origin
>```
>
>

2.commit后一定查看 git status,确定必须没有红色,如果有,重新commit

![image-20201123180951095](../../AppData/Roaming/Typora/typora-user-images/image-20201123180951095.png)

# 三、正常提交流程

```
git add .
git commit -m "备注信息"
git status    -----查看状态,有报错不能提交
git push
```

