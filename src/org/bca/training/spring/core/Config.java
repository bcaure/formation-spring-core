package org.bca.training.spring.core;

import org.bca.training.spring.core.beans.data.Car;
import org.bca.training.spring.core.beans.data.Model;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.bca.training.spring.core")
public class Config {

  Model modelFactory() {
    return new Car();
  }

}
