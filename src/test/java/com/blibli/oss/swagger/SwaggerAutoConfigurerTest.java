package com.blibli.oss.swagger;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Single;
import springfox.documentation.service.Parameter;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author Eko Kurniawan Khannedy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SwaggerAutoConfigurerTest {

  @Autowired
  private Docket docket;

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void testDocket() throws Exception {
    assertNotNull(docket);
  }

  @Test
  public void testModelSubtituteSingle() throws Exception {
    ModelSubstitute substitute = applicationContext.getBean("singleModelSubstitute", ModelSubstitute.class);
    assertEquals(Single.class, substitute.getClazz());
  }

  @Test
  public void testModelSubtituteObservable() throws Exception {
    ModelSubstitute substitute = applicationContext.getBean("observableModelSubstitute", ModelSubstitute.class);
    assertEquals(Observable.class, substitute.getClazz());
  }

  @Test
  public void testModelSubtituteDeferredResult() throws Exception {
    ModelSubstitute substitute = applicationContext.getBean("deferredResultModelSubstitute", ModelSubstitute.class);
    assertEquals(DeferredResult.class, substitute.getClazz());
  }

  @Test
  public void testModelSubtituteResponseEntity() throws Exception {
    ModelSubstitute substitute = applicationContext.getBean("responseEntityModelSubstitute", ModelSubstitute.class);
    assertEquals(ResponseEntity.class, substitute.getClazz());
  }
}