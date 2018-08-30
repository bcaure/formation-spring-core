package org.bca.training.spring.core.beans.data;

//@Component
public class Car implements Model {
  String brand;
  String model;
  Integer year;

  public void parse(String[] values) {
    if (values[0].equalsIgnoreCase("Car")) {
      brand = values[1];
      model = values[2];
      year = Integer.parseInt(values[3]);
    } else {
      throw new RuntimeException();
    }
  }


  public void display() {
    System.out.println(String.format("Car: %s %s %d", brand, model, year));
  }
}
