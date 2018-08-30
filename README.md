## Rappel sur les expressions lambda

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



## Rappel sur le polymorphisme

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
    
## La convention JavaBean

Doit implémenter Serializable

    public class PersonBean implements Serializable {

Attributs private

        private String name;
        private boolean deceased;
    
Constructeur par défaut ne prenant pas d'arguments

        public PersonBean() {
        }

Avoir des accesseurs

        public String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

## Les collections Java

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


## La sérialisation 

## Fondamentaux ORM

## Introduction au framework Spring : Spring Core

Doc officielle : https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#spring-core

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

