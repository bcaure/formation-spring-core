package org.bca.training.java.basics;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Date;


// Exercice :
// 1) modifier l'interface JsonField pour qu'elle devienne un annotation
// 2) ajouter @Retention(RetentionPolicy.RUNTIME) pour que l'annotation soit disponible à l'exécution
/*----*/interface JsonField {
  public String key() default "";
  public String format() default "";
}


public class Annotations {

  // Utiliser l'annotation JsonField
  // en l'initialisant avec les paramètres key="startDate", format="'%tD'"
  Date date = new Date();

  public static void main(String ... args) throws Exception {

    Annotations app = new Annotations();

    // On récupère le champ date de l'objet app par introspection
    Field dateField = app.getClass().getDeclaredField("date");

    // On récupère l'annotation
    JsonField annotation = dateField.getAnnotation(JsonField.class);

    // On utilise les paramètres de l'annotation pour sérialiser le champs
    String json = String.format("{ %s : %s }", annotation.key(), String.format(annotation.format(), app.date));

    System.out.println(json);
  }

}