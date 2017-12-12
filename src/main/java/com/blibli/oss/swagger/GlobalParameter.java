package com.blibli.oss.swagger;

import lombok.Builder;
import lombok.Data;
import springfox.documentation.service.Parameter;

import java.util.List;

/**
 * @author Eko Kurniawan Khannedy
 */
@Data
@Builder
public class GlobalParameter {

  private List<Parameter> parameters;

}
