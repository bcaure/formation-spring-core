#### Exercice 1:
* S'inspirer de l'injection de l'objet CsvFileDatasource pour injecter un objet Model : soit Car, soit Animal, etc.
* L'application devrait réussir à lire les lignes correspondant à l'objet choisi et ingore les autres

#### Exercice 2:
* supprimer la configuration de l'exercice 1
* changer l'objet Model à injecter en ne modifiant que le fichier Config.java (compléter la méthode factory)
* L'application devrait réussir à lire les lignes correspondant à l'objet choisi et ingore les autres

#### Exercice 3:
* supprimer la configuration de l'exercice 2
* on veut maintenant que l'application injecte dynamiquement le type d'objet décrit à chaque ligne du fichier data.csv
* décommenter les lignes de CsvFileDatasource et compléter la partie manquante
* L'application devrait réussir à lire toutes les lignes en instanciant le bon obje

#### [Solutions](solution.md)
