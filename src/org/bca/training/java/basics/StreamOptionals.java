package org.bca.training.java.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamOptionals {

  public static void main(String ... args) {
    List<Integer> list1 = Arrays.asList(new Integer[]{1, 2, 30, -1});
    List<Integer> list2 =new ArrayList<>();

    max(list1);
    max(list2);
  }

  public static void max(List<Integer> list) {

    // Exercice:
    // afficher le max de la liste ou 0 si la liste est vide avec l'API stream()
    Integer max = null /* list.stream()-----*/

    System.out.println(max);
  }
}
