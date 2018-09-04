package org.bca.training.java.basics;

/** Description de la fonction "Scream" avec une interface de fonction */
@FunctionalInterface
interface Scream {
  void scream(String s);
}

public class Lambdas {

  /** Cette méthode prend une fonction "Scream" en paramètre et l'applique aux messages */
  static void screamThis(String[] messages, Scream function) {
    for (String message : messages) {
      function.scream(message);
    }
  }

  public static void main(String ... args) throws Exception {

    String[] messages = {"miaou", "you shall not pass", "pouet"};

    // Exercice : utiliser une fonction lambda pour afficher toutes les valeurs de messages en majuscule
    // screamThis(messages, ...);

  }
}
