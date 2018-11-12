package org.bca.training.java.basics;

import java.util.Arrays;
import java.util.List;

public class Lambdas {

  public static void main(String ... args) throws Exception {

    String[] messages = {"miaou", "you shall not pass", "pouet", "pioupiou"};

    List<String> messageList = Arrays.asList(messages);

    System.out.println(messageList.stream()
        .map(message -> message.toUpperCase())
        .filter(message -> message.startsWith("p"))
        .reduce((message1, message2) -> String.format("%s %s!"))
        .orElse(""));

  }
}
