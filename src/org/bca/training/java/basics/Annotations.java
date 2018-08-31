package org.bca.training.java.basics;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Date;

public class Annotations {

  @JsonField(key="startDate", format="'%tD'")
  Date date = new Date();

  public static void main(String ... args) throws Exception {

    Annotations annotations = new Annotations();

    Field dateField = annotations.getClass().getDeclaredField("date");

    JsonField annotation = dateField.getAnnotation(JsonField.class);

    String json = String.format("{ %s : %s }", annotation.key(), String.format(annotation.format(), annotations.date));

    System.out.println(json);
  }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
  public String key() default "";
  public String format() default "";
}

