package com.blibli.oss.swagger.plugin;

import com.blibli.oss.swagger.ModelSubstitute;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rx.Observable;
import rx.Single;

/**
 * @author Eko Kurniawan Khannedy
 */
@Configuration
@ConditionalOnClass({Single.class, Observable.class})
public class SwaggerRxJavaConfiguration {

  @Bean
  public ModelSubstitute singleModelSubstitute() {
    return ModelSubstitute.builder().clazz(Single.class).build();
  }

  @Bean
  public ModelSubstitute observableModelSubstitute() {
    return ModelSubstitute.builder().clazz(Observable.class).build();
  }
}
