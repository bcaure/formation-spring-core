package org.bca.training.spring.core;

import java.util.List;
import org.bca.training.spring.core.beans.data.Model;
import org.bca.training.spring.core.beans.read.Datasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {

  @Autowired
  Datasource datasource;

  public static void main(String ... args) throws Exception {

    /// INITIALISATION

    // On initialise un contexte qui est le moteur d'injection Spring, en utilisant la configuration de la classe Config
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    // On instancie un objet Application depuis ce contexte, ainsi l'injection fonctionnera
    // ce qui n'aurait pas été le cas si on avait fait Application app = new Application();
    Application app = context.getBean(Application.class);

    /// TRAITEMENT METIER
    //
    // Cette application utilise CsvFileDatasource pour lire le fichier data.csv,
    // dont chaque ligne décrit un objet "Model" : soit Car, Animal, CupCake ou Human
    //
    // On va utiliser l'injection de dépendance Spring pour modifier le comportement
    // de l'application avec uniquement des annotations, sans toucher aux algorithmes.

    List<Model> list = app.datasource.read();
    list.forEach(Model::display);

  }


}
