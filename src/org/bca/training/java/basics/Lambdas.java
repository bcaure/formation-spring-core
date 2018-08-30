package org.bca.training.java.basics;

public class Lambdas {
  public static void main(String ... args) throws Exception {
    String[] strings = {"miaou", "you shall not pass", "pouet"};

    screamThis(strings, s -> System.out.println(s.toUpperCase()+"!"));
  }

  static void screamThis(String[] strings, Scream function) {
    for (String string : strings) {
      function.scream(string);
    }
  }
}

@FunctionalInterface
interface Scream {
  void scream(String s);
}


