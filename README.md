# Swagger2-RESTful

### 1. 认识Swagger
 Swagger 是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。总体目标是使客户端和文件系统作为服务器以同样的速度来更新。文件的方法，参数和模型紧密集成到服务器端的代码，允许API来始终保持同步。
 
### 2. 添加依赖
 ```
        <!-- 添加Swagger2依赖 -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.8.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.8.0</version>
        </dependency> 
 ```
 
### 3. 启动Swagger2
  ```
  @Configuration //标记配置类
  @EnableSwagger2 //开启在线接口文档
  public class Swagger2 {
 
  }
 ```
 
### 4. 配置控制器
  ```
   @RestController
   @RequestMapping(value = "/users") // 通过这里配置使下面的映射都在/users下，可去
   public class UserController {
   
   }
  ```

### 5. 访问Swagger-ui
这是去往 [Swagger-ui](http://localhost:8080/swagger-ui.html) 的链接。
