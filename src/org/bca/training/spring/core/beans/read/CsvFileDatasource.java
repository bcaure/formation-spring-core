package org.bca.training.spring.core.beans.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.bca.training.spring.core.beans.data.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CsvFileDatasource implements Datasource {

  @Autowired
  ApplicationContext ctx;

  Model model;

  public List<Model> read() throws Exception {

    List<Model> result = new ArrayList<>();

    File file = new File("data.csv");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String s;
      for (int i = 0; (s = reader.readLine()) != null; i++) {

        try {
          String[] values = s.split("[;,]");

          ///
          // String beanName = values[0];
          // model = <à compléter>
          ///

          model.parse(values);
          result.add(model);

        } catch (RuntimeException e) {
          System.err.println(String.format("Ligne %d ignorée", i));
        }
      }
    }

    return result;
  }

}
