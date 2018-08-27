# Introduction au framework Spring : Spring Core

Doc officielle : https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#spring-core

## Bean
**C'est un _objet Spring_, qui peut être injecté grâce à son nom (attribut _name_ ou _id_) et qui est définit avec un _scope_ particulier**

## Injection
**C'est le fait de déléguer l'instanciation d'un objet. **

Pourquoi faire?

Pour rendre le programme configurable, par exemple avec des fichiers de configuration externes à l'application.
- on peut ainsi facilement bouchonner un programme pour exécuter des tests auto par exemple
- avoir une configuration de production différente de la configuration de développement (logs moins verbeuses, chemin d'accès aux fichiers différents, serveur de base de données différents, etc.)

## Conteneur IoC

**C'est le moteur qui permet d'injecter les bonnes instances des objets qu'on manipule à partir de la configuration du projet**

## Scope

**Lorsque j'injecte un bean, est-ce que je vais réutiliser une instance déjà existante ou est-ce que je vais en créer une autre?**

Le cas d'utilisation le plus courant est le Singleton : je veux être sûr d'utiliser le même bean dans toute mon application, car celui-ci contient des données que j'ai initialisé seulement à cet endroit.

Les scopes Spring pour les applis web : 
- application : quasiment équivalent au Singleton
- session : une seule instance par session utilisateur (entre son authentification et l'expiration de sa session, ou sa déconnexion)
  => ce scope ne doit pas être utilisé lorsque l'on utilise un backend "Stateless", avec un front-end Javascript par exemple
- request : une instance à chaque requête HTTP

