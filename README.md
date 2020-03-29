项目简介:
该项目主要采用的是springboot、netty搭建的一个httpserver,用于对接第三方服务

项目难点：
netty并没有实现servlet规范，因此springMVC提供的参数绑定、url映射到方法等功能无法使用，
需要去解析http请求的头部、body等内容，在根据对接不同的服务采用不同的业务线程池来实现

项目包结构
business -- 调用讯飞、百度、翻译等其他第三方服务处理类
config   -- 项目中的配置类
constant -- 常量
handler  -- http服务的一些处理器
listener -- 存放监听器类
model    -- 实体类
server   -- netty服务初始化和http解析器相关类
task     -- 调用接口任务类
thread   -- 线程池相关类
utils    -- 工具类
