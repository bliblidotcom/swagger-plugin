package com.blibli.oss.swagger;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eko Kurniawan Khannedy
 */
@Configuration
@EnableSwagger2
public class SwaggerAutoConfigurer {

  @Bean
  @ConditionalOnMissingBean(ApiInfo.class)
  public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Blibli Swagger Plugin")
        .build();
  }

  @Bean
  @Autowired
  public Docket api(ApplicationContext applicationContext, ApiInfo apiInfo) {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo)
        .useDefaultResponseMessages(false)
        .genericModelSubstitutes(getModelSubstituteClasses(applicationContext))
        .ignoredParameterTypes(getIgnoredParameterClasses(applicationContext))
        .globalOperationParameters(getParameterList(applicationContext));
  }

  private List<Parameter> getParameterList(ApplicationContext applicationContext) {
    List<Parameter> parameters = new ArrayList<>();
    applicationContext.getBeansOfType(GlobalParameter.class).values().forEach(globalParameter -> {
      parameters.addAll(globalParameter.getParameters());
    });
    return parameters;
  }

  private Class[] getModelSubstituteClasses(ApplicationContext applicationContext) {
    List<? extends Class<?>> collect = applicationContext.getBeansOfType(ModelSubstitute.class).values()
        .stream().map(ModelSubstitute::getClazz).collect(Collectors.toList());

    return collect.toArray(new Class[collect.size()]);
  }

  private Class[] getIgnoredParameterClasses(ApplicationContext applicationContext) {
    List<? extends Class<?>> collect = applicationContext.getBeansOfType(IgnoredParameter.class).values()
        .stream().map(IgnoredParameter::getClazz).collect(Collectors.toList());

    return collect.toArray(new Class[collect.size()]);
  }

}
