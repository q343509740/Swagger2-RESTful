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

---

# 使用Swagger2Markup实现API文档的静态部署

### 1. 认识Swagger2Markup
  Swagger2Markup是Github上的一个开源项目。该项目主要用来将Swagger自动生成的文档转换成几种流行的格式以便于静态部署和使用，比如：AsciiDoc、Markdown、Confluence。
  这是去往 [Swagger2Markup](https://github.com/Swagger2Markup/swagger2markup) 的链接。
  
### 2. 添加依赖
 ```
         <!-- 添加Swagger2markup依赖 -->
        <dependency>
            <groupId>io.github.swagger2markup</groupId>
            <artifactId>swagger2markup</artifactId>
            <version>1.3.1</version>
        </dependency>
 ```
 
 ### 3. 单元测试类
 ```
 /**
 * 编写一个单元测试用例来生成执行生成文档的代码
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter315ApplicationTests {
}
```

 ### 4. 生成HTML
 修改pom.xml
 ```
     <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <!-- 生成Asciidoc -->
            <plugin>
                <groupId>io.github.swagger2markup</groupId>
                <artifactId>swagger2markup-maven-plugin</artifactId>
                <version>1.3.1</version>
                <configuration>
                    <swaggerInput>http://localhost:8080/v2/api-docs</swaggerInput>
                    <outputDir>src/docs/asciidoc/generated</outputDir>
                    <config>
                        <swagger2markup.markupLanguage>ASCIIDOC</swagger2markup.markupLanguage>
                    </config>
                </configuration>
            </plugin>
            <!-- 生成HTML -->
            <plugin>
                <groupId>org.asciidoctor</groupId>
                <artifactId>asciidoctor-maven-plugin</artifactId>
                <version>1.5.6</version>
                <configuration>
                    <sourceDirectory>src/docs/asciidoc/generated</sourceDirectory>
                    <outputDirectory>src/docs/asciidoc/html</outputDirectory>
                    <backend>html</backend>
                    <sourceHighlighter>coderay</sourceHighlighter>
                    <attributes>
                        <toc>left</toc>
                    </attributes>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
执行该插件的asciidoctor:process-asciidoc

