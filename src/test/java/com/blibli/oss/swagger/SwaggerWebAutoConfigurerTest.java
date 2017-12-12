package com.blibli.oss.swagger;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import static org.mockito.Mockito.*;

/**
 * @author Eko Kurniawan Khannedy
 */
public class SwaggerWebAutoConfigurerTest {

  @Test
  public void addViewControllers() throws Exception {
    SwaggerWebAutoConfigurer configurer = new SwaggerWebAutoConfigurer();
    ViewControllerRegistry registry = mock(ViewControllerRegistry.class);
    RedirectViewControllerRegistration registration = mock(RedirectViewControllerRegistration.class);

    when(registry.addRedirectViewController(anyString(), anyString()))
        .thenReturn(registration);

    configurer.addViewControllers(registry);

    verify(registry, times(1))
        .addRedirectViewController("/docs", "/swagger-ui.html");
    verify(registration, times(1))
        .setStatusCode(HttpStatus.MOVED_PERMANENTLY);

    verifyNoMoreInteractions(registry, registration);
  }

}