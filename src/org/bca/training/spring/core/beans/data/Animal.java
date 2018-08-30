package org.bca.training.spring.core.beans.data;

//@Component
public class Animal implements Model {
  String name;
  String race;
  Integer age;


  public void parse(String[] values) {
    if (values[0].equalsIgnoreCase("Animal")) {
      name = values[1];
      race = values[2];
      age = Integer.parseInt(values[3]);
    } else {
      throw new RuntimeException();
    }
  }


  public void display() {
    System.out.println(String.format("Animal: %s %s %d", name, race, age));
  }
}
