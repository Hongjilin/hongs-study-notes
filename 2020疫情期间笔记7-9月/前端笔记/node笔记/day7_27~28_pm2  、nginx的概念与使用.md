# -----------------------==(NODE柒)==------------------------	

# pm2  、nginx的概念与使用=>Day7_27~28

### 一.pm2命令

##### 	1.pm2的使用

>    进程守卫:
>         1.监控当前的项目的资源的消耗情况
>         2.实现对当前的项目的热部署

##### 	2..实际操作

######       	  1.pm2安装

```
	 npm install  pm2 -g
```

######       	  2.检验是否由安装成功:

```
 npm list 包名 -g
```

######        	 3.了解下面的命令的使用以及顺序

```
    pm2 init    				##创建pm2配置文件
    pm2 start bin/www   ##启动服务器 bin/www表示要运行的脚本,express项目就
    pm2 list            ##查看运行状态
    pm2 log             ##查看日志
    pm2 restart www     ##重启应用 www是 pm2启动进程的名称
    pm2 stop www        ##停止应用 www是 pm2启动进程的名称(也可以输入id)
    pm2 delete www      ##卸载应用(即终止运行) www是 pm2启动进程的名称(也可以输入id)
    pm2 monit           ##实时监控cpu
```

###### 4.ecosystem.config.js修改

```js
module.exports = {
  apps : [
      //删除apps里面所有元素,这些都是多余的,然后添加以下元素
      {
          script: 'bin/www',
          //监听
          watch: true
      },
  ],
```



### 二.**Nginx**

#### 	1. 了解Nginx:

>    Nginx是一款[轻量级](https://baike.baidu.com/item/轻量级/10002835)的[Web](https://baike.baidu.com/item/Web/150564) 服务器/[反向代理](https://baike.baidu.com/item/反向代理/7793488)服务器及[电子邮件](https://baike.baidu.com/item/电子邮件/111106)（IMAP/POP3）代理服务器，在BSD-like 协议下发行。其特点是占有内存少，[并发](https://baike.baidu.com/item/并发/11024806)能力强，事实上nginx的并发能力在同类型的网页服务器中表现较好，中国大陆使用nginx网站用户有：百度、[京东](https://baike.baidu.com/item/京东/210931)、[新浪](https://baike.baidu.com/item/新浪/125692)、[网易](https://baike.baidu.com/item/网易/185754)、[腾讯](https://baike.baidu.com/item/腾讯/112204)、[淘宝](https://baike.baidu.com/item/淘宝/145661)等。

#### 	2.Nginx的作用:

>1)反向代理解决跨域问题
>		2)负载均衡
>		3)翻墙......

#### 	3.Nginx的三个bat文件=>

###### 		3.1)start.bat=>

```bat
start nginx -c ./conf/nginx.conf
echo success
pause
```

###### 		3.2)stop.bat=>

```bat
nginx.exe -s stop
echo success
pause
```

###### 		3.3)reload.bat=>

```bat
nginx.exe -s reload
echo success
pause
```

#### 4.Nginx实操=>

###### 	4.1)配置start.bat stop.bat reload.bat

1.   start.bat :启动nginx(通过start.bat启动的nginx,千万不能多次启动,否则会出现多个nginx实例,这个时候stop来不及了  stop只能关闭最后一个,但是如果真的犯错了,怎么关闭以前呢:在任务栏,右击打开任务管理器==>进入到详细服务列表,找到nginx服务,统统结束)
2.   stop.bat :停用nginx(在start之后可以用)
3.   reload.bat:重启nginx(在start之后可以用)
4.   通过cmd执行start.bat来启动nginx启动之后,千万别关闭串口

######     4.2)nginx出现访问不了的情况=>

1.   只有一种:配置出现问题=>学会看日志: E:\nginx\logs\error.log去看日志内容

#### 5.配置文件=>

##### 		5.1)配置文件位置:

>    E:\nginx\conf\nginx.conf

##### 		5.2)配置文件服务器配置部分解释=>

```bat
server {
        listen       80;
        #//监听的域名
        //本地IP地址
        server_name  localhost;
        #charset koi8-r;
        #access_log  logs/host.access.log  main;
           #//如果是localhost 80端口   就访问根目录下的index.html
        location / {
            root   html;
            index  index.html index.htm;
        }
        //测试静态文件服务器配置(注意斜杠)
        location /xk {
              alias  E:/fyWebStrom/Xunke_Code/day7_27_28/public;
		}
		location /cross/ {
			proxy_pass  http://localhost:3000/;
			add_header  to http://localhost:3000;
		}
    }

```

##### 		5.3)静态文件服务器配置(注意斜杠)

###### 	5.3.1)方式一:	

```
location /qn { alias  E:/fyWebStrom/Xunke_Code/day7_27_28/public;	}
  alias表示别名,意思就是当我们请求的uri里头包含了qn,那么就会自动去访问alias指向的路径下的文件
    eg:
    http://localhost/qn/test.html
    表示:请求alias路径下的test.html
```

###### 	5.3.2)方式二:	

```
location  /qn{
    root E:/fyWebStrom/Xunke_Code/day7_27_28/public/Demo.html
    //表示根, 请求root路径下的qn文件夹下的test.html
}
```

#### 6.跨域代理=>

##### 6.1)配置文件配置:

```
server {
        listen       80;
        server_name  localhost;
        #charset koi8-r;
        #access_log  logs/host.access.log  main;
        //nginx跨域配置
            location /cross/ {
        proxy_pass http://localhost:3000/;
        add_header to http://localhost:3000;
   } }
```

##### 6.2)配置proxy_pass代理转发四种方式=>

###### 	6.2.1)配置路径原理

>    在nginx中配置proxy_pass代理转发时，如果在proxy_pass后面的url加/，表示绝对根路径；如果没有/，表示相对路径，把匹配的路径部分也给代理走。

假设下面四种情况分别用 http://192.168.1.1/proxy/test.html 进行访问:

###### 	6.2.1)第一种方法:

```
location /proxy/ {
    proxy_pass http://127.0.0.1/;
}
代理到URL：http://127.0.0.1/test.html
```

###### 	6.2.2)第二种方法（相对于第一种，最后少一个 / ）:

```
location /proxy/ {
    proxy_pass http://127.0.0.1;
}
代理到URL：http://127.0.0.1/proxy/test.html
```

###### 	6.2.3)第三种方法:

```
location /proxy/ {
    proxy_pass http://127.0.0.1/aaa/;
}
代理到URL：http://127.0.0.1/aaa/test.html
```

###### 	6.2.4)第四种方法(相对于第三种，最后少一个 / ）:

```
location /proxy/ {
    proxy_pass http://127.0.0.1/aaa;
}
代理到URL：http://127.0.0.1/aaatest.html
```

#### 7.Niginx配置文件及其跨域原理=>

###### 		① server表示启动一个代理服务器

###### 		② 该代理服务器也是静态文服 (静态文件要通过代理服务器来访问)

  			   1)因为代理服务器只能监听代理服务器的端口
   					  2)所以前端发出的所有请求一定是基于80端口去发出
		   			  3)这样子,前端的所有跨域请求才可以被监听到
   					  4)才能实现 前端和代理服务器之间的不跨域

###### 		 ③ 80 表示监听80端口 所以最终我们的前端资源一定是部署在80端口上

 			    1)通过相对路径 html
  			  		 2)通过绝对路径  静态文服

###### 		 ④ location /cross

   			  1)服务端的接口的uri ,不一定要cross(联想alias,它只是一个规则,并没有表示真正的意图)
    				     http://localhost/cross/cross 后面的cross才是我们正要去访问的uri

###### 		  ⑤ proxy_pass

​    			  1) 表示我们真正想要请求的地址是......

###### 		  ⑥ add_header

   			   2) 就是我们在请求成功之后 响应头要添加的内容

###### 		  ⑦练习:

```
 http://localhost:81/cross/cross/get  (跨域不成功) 端口无法监听到
  http://localhost:81/cross1/cross/get (跨域不成功)找不到路径且端口也不正确
  http://localhost:80/cross/cross/get  (跨域成功)
```

