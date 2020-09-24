package com.sjht.school.common.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
    Predicate<RequestHandler> swaggerSelector = RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class);

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/META-INF/resources/");
    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).securitySchemes(securitySchemes()).securityContexts(securityContexts())
            .apiInfo(apiInfo()).groupName("CREDIT-BUSSINESS-API")
            .select()
            //加了ApiOperation注解的类，才生成接口文档
            // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            //包下的类，才生成接口文档
            // .apis(RequestHandlerSelectors.basePackage("com.fg"))
            .apis(swaggerSelector)
            .paths(PathSelectors.any()).build();
    }
    @Bean
    public Docket createAppRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).securitySchemes(securitySchemes()).securityContexts(securityContexts())
                .apiInfo(apiInfo()).groupName("CREDIT-APP-API")
                .select()
                //加了ApiOperation注解的类，才生成接口文档
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，才生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.credit"))
                .apis(swaggerSelector)
                .paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("校园足球管理系统")
            .description("描述:接口开发文档").contact(new Contact("maojianyun", "jianyun.mao@hualongdata.com", ""))
            .termsOfServiceUrl("")
            .version("1.0.0").license("重庆数据汇通信息技术有心公司版权所有")
            .build();
    }

    @SuppressWarnings("unused")
	private List<ApiKey> security() {
        return newArrayList(new ApiKey("token", "token", "header")
        );
    }
    private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("token", "token", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("/*.*"))
                        .build()
        );
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("token", authorizationScopes));
    }
    @SuppressWarnings("unused")
	private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
}