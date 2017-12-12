package com.blibli.oss.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Eko Kurniawan Khannedy
 */
@Configuration
public class SwaggerWebAutoConfigurer extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addRedirectViewController("/docs", "/swagger-ui.html")
        .setStatusCode(HttpStatus.MOVED_PERMANENTLY);
  }
}
