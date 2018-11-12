package org.bca.training.java.basics;

import java.util.Optional;

public class Optionals {

  public static void main(String ... args) {
    String string = "toto";
    Optional<String> stringOptional = Optional.of(string);

    if (string != null) {
      System.out.println(string);
    } else {
      System.out.println("string is null");
    }

    if (stringOptional.isPresent()) {
      System.out.println(stringOptional.get());
    }

    System.out.println(stringOptional.orElse("string is null"));
  }

}
