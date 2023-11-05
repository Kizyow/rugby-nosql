# Coupe du monde de rugby
#### Alexandre PERROT S5-RAIL2

## Description
Un projet pour l'IUT Nancy-Charlemagne en S5 dans le module de Nouveaux paradigmes BD
où on doit mettre en place une application permettant de gérer une coupe du monde du rugby via MongoDB sous une interface graphique

## Fonctionnalités

- Système d'authentification pour la base de donnée ainsi que le stockage des données
#### Vous pouvez effectuer les opérations suivantes :
-  a. Afficher pour tous les joueurs de l'équipe E : leur temps de jeu, le nombre
  d'essais marqués, le nombre de points marqués, et le coefficient (nombre de
  points/durée de jeu). On classera les joueurs par ordre décroissant du
  coefficient.
-  b. Rechercher tous les matchs qui se sont déroulés à une date D et dans lesquels
  le score d'une des équipes a dépassé un nombre P de points.
-  c. Rechercher les équipes qui recevaient et qui ont été arbitrés par un arbitre A.
-  d. Rechercher tous les joueurs de l'équipe E1 qui ont débuté le match à la date
  D contre l’équipe E2.
-  e. Afficher les joueurs de l'équipe E qui sont entrés en cours de jeu.
-  f. Donner pour chaque joueur de l'équipe E le nombre de matchs qu'il a joué,
  ainsi que le nombre de points et le nombre d'essais marqués.
-  g. Afficher le nom des joueurs de l'équipe E1 qui ont joué à la fois contre les
équipes E2 et E3.
-  h. Afficher les joueurs de l'équipe E qui n'ont joué aucun match.
-  i. Afficher tous les joueurs de l’équipe E qui ont joué tous les matchs de leur
  équipe.
-  j. Afficher quel est le joueur de la coupe du monde qui a marqué le plus d'essais,
  et celui qui a marqué le plus de points.
-  k. Insérer un arbitre A pour un match M tout en vérifiant que la nationalité de
  A n’appartient pas au même pays qu’une des deux équipes.

## Détails technique

L'application est écrite en Java 17 (avec JavaFX 17 et Gradle en gestionnaire de dépendances)
Pour pouvoir utiliser ce projet, vous devez lancer un gradle init (attendez qu'il download toutes les dépendences)

**Et vous pouvez lancer l'application à partir du Main** (dans src/main/java/fr/perrot54u/rugby/Main.java)

Vous pouvez créer vous-même la database et la collection du nom au choix et je vous ai fourni un fichier
JSON contenant les données dans 'resources/data/matchs.json'

Sinon vous pouvez exécuter les commande du script que j'ai fourni pour importer les données.


