package org.bca.training.spring.core.beans.data;

//@Component
public class CupCake implements Model {

  String name;
  Double price;


  public void parse(String[] values) {
    if (values[0].equalsIgnoreCase("CupCake")) {
      name = values[1];
      price = Double.parseDouble(values[2]);
    } else {
      throw new RuntimeException();
    }
  }


  public void display() {
    System.out.println(String.format("CupCake: %s %f", name, price));
  }
}
