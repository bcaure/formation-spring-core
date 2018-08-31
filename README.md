## Les fondamentaux du langage

### La convention JavaBean

Doit implémenter Serializable (sérialization binaire "interne" à Java, pas la sérialization JSON ou XML)
Pourquoi? difficile à dire ... 
_"Serialization was a horrible mistake in 1997"_ (Oracle Chief Architect, Devoxx UK 2018)

    public class PersonBean implements Serializable {

Attributs private : on est sûr que personne ne modifiera les données sans passer par les accesseurs.

        private String name;
        private boolean deceased;
    
Constructeur par défaut ne prenant pas d'arguments

        public PersonBean() {
            // Cela sert aux mécanismes d'injection, car souvent ils n'ont pas de données à fournir lorsqu'ils injectent.
        }

Avoir des accesseurs pour tous les attributs publics

        // Contrairement aux attributs les méthodes permettent :
        // - d'être surchargées, le polymorphisme et la programmation par aspect (AOP)
        public String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

### Les expressions lambda

Avant :

    for (int i = 0; i < list.size(); i++) {
       methode(list.get(i));
    }

    void methode(String string) {
       <....>
    }

Maintenant :

    list.forEach(string -> <....>);

Je peux créer mes [propres méthodes](src/org/bca/training/java/basics/Lambdas.java) qui prennent des lambdas en paramètre.



### Le polymorphisme

L'héritage (```A extends B```) ou l'implémentation d'interfaces (```A implements B```) permet de dire qu'un ensemble de classe offrent toutes le même service.

Par exemple l'interface ```Comparable``` permet de comparer 2 objets entre eux.

Le polymorphisme est souvent utilisé lorsque l'on manipule des objets sans savoir de quelle classe ils sont réellement, on sait juste qu'ils implémentent tous la même interface.

Par exemple j'ai une liste de valeurs de nature différente, mais qui héritent tous de ```Object```

    List<Object> list = new ArrayList<>();
    list.add(new Integer(4));
    list.add(new Float(0.1));
    list.add("toto");
    list.add(new Date());

Je peux tous les afficher car ils implémentent la méthode ```toString()```: même si println ne sait pas de quelle classe est l'objet, elle peux appeler cette méthode :  

    list.forEach(object -> System.out.println(object.toString()));

### Les collections

Tableau ```MyObject[]``` : type de base, peu utilisé

```List<MyObject> list = new ArrayList<>();``` : collection la plus utilisée
* ses éléments ont une position : ```list.get(3)```

```Set<MyObject> set = new HashSet<>();``` : 2e collection la plus utilisée.
* elle sert à avoir une liste garantie sans doublons, car si on ajoute un élement existant il est remplacé.

```Map<MyObject> set = new HashMap<>();``` : collection très utilisée pour associer une clé à une valeur.
* les clés sont garanties sans doublons comme les Set
* on peut utiliser n'importe quel objet comme clé ou comme valeur

**Si vous utilisez une autre collection :**
 soit vous codez quelquechose de très pointu,
soit vous faites une erreur...

Utilisations courantes :
* parcours boucle for : ```for (MyObject o : list)```
* parcours lambdas : ```list.forEach(o -> ...)```
* les "streams" qui sont une collection d'opérations sur les listes : 
  * ```list.stream().map()``` : transformer le stream d'objetA en stream d'objetB
  * ```list.stream().reduce()``` : transformer le stream en un seul objet (somme, concaténation, trouver le max)
  * ```list.stream().collect()``` : transformer le stream en une autre collection (liste, set, map)

### Les Optional

Optional a été inventé principalement pour les streams : cela permet d'éviter les NullPointerException.
Optional contient un objet ou null, mais lui même n'est jamais null.

Par ex je recherche la valeur max d'une liste, mais celle-ci est vide, je peux retourner facilement 0 au lieu de null
    Integer result = list.stream().max().orElse(0).get();

### Principes des annotations

[Cas pratique](src/org/bca/training/java/basics/Annotations.java)

### Serialisation

Transformer les objets en JSON et inversement.

Pas évident: on doit spécifier à Java comment retrouver le type des objets.

Lib pour JSON : Jackson, GSON, Orika


### Les loggers

Slf4j est l'API la plus connue.
Les implémentations sont log4j (historique), logback (moderne).

Configuration - 2 notions : 
* LOGGER : ce qu'on appelle depuis le code ```logger.log()```
* APPENDER : où sont écrits les logs et le format 

## Fondamentaux Web/client-serveur

Serveur Java (ex: Tomcat) : _JVM qui tourne en continue et qui reçoit des requêtes (HTTP GET, POST, ...) et retourne des réponses (JSON, HTML, XML...).
- auparavant les pages HTML sont générées côté serveur avec JSP ou JSF (équivalent à PHP)
- de nos jours on utilise un serveur Java comme "backend", c'est à dire qu'on renvoit les données brutes en JSON

C'est pourquoi on utilise des outils comme postman ou swagger pour tester un serveur Java.
Ces outils se substituent à un frontend Javascript par exemple.

Ce qui traite les requêtes et les réponses sont les Servlets : _Tomcat est un _conteneur de servlet_.
Les _controllers_ sont des servlets améliorées pour implémenter plus facilement les web services REST.

### Fondamentaux ORM

Un modèle relationnel est différent d'un modèle objet.

On utilise un mapping pour spécifier comment enregistrer les objets en base de données.

La plupart du temps, 1 objet = 1 table, 1 attribut = 1 colonne, etc.
Sauf pour les cas particuliers :
- héritage
- relation n-n

L'ORM sert également à ne plus écrire de SQL donc facilite le changement de moteur de base de données.

## Introduction au framework Spring : Spring Core

[Doc officielle](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#spring-core)

### Spring Bean ou Component
**C'est un _JavaBean_, qui est décrit grâce à son nom (attribut _name_ ou _id_) et qui est définit avec un _scope_ particulier**.

Cela peut être fait par annotation ou dans des fichier XML, ce qui permet à ces beans de pouvoir être injectés dans d'autres objets.  

### Injection
**C'est le fait de déléguer l'instanciation d'un objet, de ne pas faire "new" explicitement.**

La classe d'implémentation est donc choisie à l'exécution et non à la compilation.

Pourquoi faire?

Pour rendre le programme configurable, par exemple avec des fichiers de configuration externes à l'application.
- on peut ainsi facilement bouchonner un programme pour exécuter des tests auto **sans modifier le code**
- un même programme **compilé** peut avoir une configuration de production différente de la configuration de développement (logs moins verbeuses, chemin d'accès aux fichiers différents, serveur de base de données différents, etc.)

### Conteneur IoC

**C'est le moteur qui permet d'injecter les bonnes instances des objets** à partir de la configuration du projet.
On l'appelle aussi ApplicationContext.

### Scope

**Lorsque j'injecte un bean, est-ce que je vais réutiliser une instance déjà existante ou est-ce que je vais en créer une autre?**

Le cas d'utilisation le plus courant est le Singleton : je veux être sûr d'utiliser le même bean dans toute mon application, car celui-ci contient des données que j'ai initialisé seulement à cet endroit.

Les scopes Spring pour les applis web : 
- application : quasiment équivalent au Singleton
- session : une seule instance par session utilisateur (entre son authentification et l'expiration de sa session, ou sa déconnexion)
  => ce scope ne doit pas être utilisé lorsque l'on utilise un backend "Stateless", avec un front-end Javascript par exemple
- request : une instance à chaque requête HTTP

### Exercices pratiques

[Injection avec Spring](src/org/bca/training/spring/core/exercices.md)
