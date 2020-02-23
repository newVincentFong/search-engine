# Lucene 搜索引擎
## 涉及到
* Maven仓库管理(需要什么jar包，自动帮你下)
* Spring Boot(能自动化构建工程，不像SSM要手配)
## 参考
* 一篇 [Spring Boot 快速入门文章](https://blog.csdn.net/qq_40147863/article/details/84194493)
* 根据需要，是否配置数据库链接 [myBatis、jdbc](https://www.cnblogs.com/ecology-lee/p/9984545.html)
## 模块
### 爬虫 (Spyder)
* 爬虫要链接目标地址，所以在网上搬了一段简单的HTTPClient工具类来用
* 目标地址首页 `bilibili` 还是HTTPS链接，所以需要构造SSL证书类，同理网上复制一段能用的就完事
* 注意要给请求添加一下 `User-Agent`
* `Jsoup` 解析HTML