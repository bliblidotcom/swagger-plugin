package com.blibli.oss.swagger;

import lombok.Builder;
import lombok.Data;

/**
 * @author Eko Kurniawan Khannedy
 */
@Data
@Builder
public class IgnoredParameter {

  private Class<?> clazz;

}
