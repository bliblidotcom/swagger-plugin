package com.blibli.oss.swagger.plugin;

import com.blibli.oss.swagger.ModelSubstitute;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Eko Kurniawan Khannedy
 */
@Configuration
@ConditionalOnClass({ResponseEntity.class, DeferredResult.class})
public class SwaggerWebConfiguration {

  @Bean
  public ModelSubstitute deferredResultModelSubstitute() {
    return ModelSubstitute.builder().clazz(DeferredResult.class).build();
  }

  @Bean
  public ModelSubstitute responseEntityModelSubstitute() {
    return ModelSubstitute.builder().clazz(ResponseEntity.class).build();
  }

}
