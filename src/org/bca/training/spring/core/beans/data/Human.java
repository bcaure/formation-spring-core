package org.bca.training.spring.core.beans.data;

//@Component
public class Human implements Model {
  String firstName;
  String lastName;
  Integer age;

  public void parse(String[] values) {
    if (values[0].equalsIgnoreCase("Human")) {
      lastName = values[1];
      firstName = values[2];
      age = Integer.parseInt(values[3]);
    } else {
      throw new RuntimeException();
    }
  }


  public void display() {
    System.out.println(String.format("Human: %s %s %d", firstName, lastName, age));
  }
}
