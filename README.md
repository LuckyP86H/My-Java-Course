# My-Java-Course

<sub>Training courses for improve my coding in Java</sub>

## Week01 作业题目：
1.（选做）自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论。

2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。

3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

4.（选做）检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap 查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。

注意：如果没有线上系统，可以自己 run 一个 web/java 项目。

5.（选做）本机使用 G1 GC 启动一个程序，仿照课上案例分析一下 JVM 情况。

## Week02 作业题目：

1.（选做）使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。

2.（选做）使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。

3.（选做）如果自己本地有可以运行的项目，可以按照 2 的方式进行演练。

4.（必做）根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结，提交到 GitHub。

5.（选做）运行课上的例子，以及 Netty 的例子，分析相关现象。
6.（必做）写一段代码，使用 HttpClient 或 OkHttp 访问  http://localhost:8801 ，代码提交到 GitHub。

## Week03 作业题目
1.（必做）整合你上次作业的 httpclient/okhttp。

2.（选做）使用 netty 实现后端 http 访问（代替上一步骤）。

3.（必做）实现过滤器。

4.（选做）实现路由。

5.（选做）跑一跑课上的各个例子，加深对多线程的理解。

6.（选做）完善网关的例子，试着调整其中的线程池参数。

## Week04 作业题目

1.（选做）把示例代码，运行一遍，思考课上相关的问题。也可以做一些比较。

2.（必做）思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
个方法的返回值后，退出主线程? 写出你的方法，越多越好，提交到 GitHub。
一个简单的代码参考:  https://github.com/kimmking/JavaCourseCodes/tree/main/03concurrency/0301 /src/main/java/java0/conc0303/Homework03.java

3.（选做）列举常用的并发操作 API 和工具类，简单分析其使用场景和优缺点。

4.（选做）请思考: 什么是并发? 什么是高并发? 实现高并发高可用系统需要考虑哪些 因素，对于这些你是怎么理解的?

5.（选做）请思考: 还有哪些跟并发类似 / 有关的场景和问题，有哪些可以借鉴的解决 办法。

6.（必做）把多线程和并发相关知识梳理一遍，画一个脑图，截图上传到 GitHub 上。 可选工具:xmind，百度脑图，wps，MindManage，或其他。


## Week5 作业题目
1.（选做）使 Java 里的动态代理，实现一个简单的 AOP。

2.（必做）写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 GitHub。

3.（选做）实现一个 Spring XML 自定义配置，配置一组 Bean，例如：Student/Klass/School。

4.（选做，会添加到高手附加题）

1) (挑战）讲网关的 frontend/backend/filter/router 线程池都改造成 Spring 配置方式；
2) (挑战）基于 AOP 改造 Netty 网关，filter 和 router 使用 AOP 方式实现； 
3) （中级挑战）基于前述改造，将网关请求前后端分离，中级使用 JMS 传递消息； 
4) （中级挑战）尝试使用 ByteBuddy 实现一个简单的基于类的 AOP； 
5) （超级挑战）尝试使用 ByteBuddy 与 Instrument 实现一个简单 JavaAgent 实现无侵入下的 AOP。

5.（选做）总结一下，单例的各种写法，比较它们的优劣。

6.（选做）maven/spring 的 profile 机制，都有什么用法？

7.（选做）总结 Hibernate 与 MyBatis 的各方面异同点。

8.（必做）给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。

9.（选做）学习 MyBatis-generator 的用法和原理，学会自定义 TypeHandler 处理复杂类型。

10.（必做）研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法：

1) 使用 JDBC 原生接口，实现数据库的增删改查操作。 
2) 使用事务，PrepareStatement 方式，批处理方式，改进上述操作。 
3) 配置 Hikari 连接池，改进上述操作。提交代码到 GitHub。

附加题（可以后面上完数据库的课再考虑做
1. (挑战) 基于 AOP 和自定义注解，实现 @MyCache(60) 对于指定方法返回值缓存 60 秒。
2. (挑战) 自定义实现一个数据库连接池，并整合 Hibernate/Mybatis/Spring/SpringBoot。
3. (挑战) 基于 MyBatis 实现一个简单的分库分表 + 读写分离 + 分布式 ID 生成方案。

<sub> &copy; 2021 Paul Xu Learning Purpose; provided by GeekU</sub>