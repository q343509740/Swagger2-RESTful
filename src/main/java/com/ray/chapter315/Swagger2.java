package com.ray.chapter315;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ray
 * @date 2018/7/1 0001
 * Swagger2的配置文件，在项目的启动类的同级文件建立
 */
@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档
public class Swagger2 {

    /**
     * 再通过createRestApi函数创建Docket的Bean之后，
     * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义，
     * Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指向自己的controller即可
                .apis(RequestHandlerSelectors.basePackage("com.ray.chapter315.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置文档信息
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题
                .title("SpringBoot中使用Swagger2构建RESTful API")
                //描述
                .description("更多资料, 请查看: https://blog.csdn.net/q343509740")
                //设置作者联系方式,可有可无
                .contact("Ray")
                //版本号
                .version("1.0")
                .build();
    }
}
