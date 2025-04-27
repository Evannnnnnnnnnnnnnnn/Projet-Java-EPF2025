### Prérequis

- Java 21
- Maven
- MySQL Server
- Apache Tomcat 10.1.x
- Node.js (pour le frontend)

## Configuration de la base de données

1. Créer une base de données MySQL nommée 'pvz'
2. Exécuter les scripts SQL dans l'ordre suivant :
   - `SQL/init.sql` pour créer les tables
   - `SQL/values.sql` pour peupler la base avec les données initiales

## Configuration du projet

1. Configurer les informations de connexion à la base de données dans `src/main/java/com/epf/config/SpringConifg.java`
   - Par défaut :
     - URL: jdbc:mysql://localhost:3306/pvz
     - Username: root
     - Password: ""

### Lancer le back

Récuperer le fichier `CoursEpfBack.war` qui se trouve dans TP 4\target\CoursEpfBack.war
L'ajouter dans le fichier webapp de tomcat
Executer startup.bat dans tomcat
Il est sur le localhost:8080

### Lancer le front

Executer `npm install` dans le repertoire du front (pas sur ce git car inchangé)
Executer `npm run start:dev` dans le meme repertoire
Se rendre sur le port localhost donné dans le terminal pour acceder au front qui est connecté au back

### Contenu

Architecture en 3 couches - 100%
CRUD - 100%
Validation - 70% (J'ai verifier la plus part des choses, mais j'en ai surement oublié)
Test - 1% (J'en ai fait qu'un pour tester (DaoMapTest))
