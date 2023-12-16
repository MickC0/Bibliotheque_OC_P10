# BIBLIOTHEQUE-OC-P7

# Projet réalisé dans le cadre de la formation Développeur d'application JAVA OpenClassrooms.

	Création d'un site de gestion des bibliothèques de la ville.

# Contexte :

Vous travaillez au sein de la Direction du Système d’Information (DSI)  de la mairie d’une grande ville,
sous la direction de Patricia, la responsable du service. La DSI est en charge de tous les traitements numériques
pour la mairie et les structures qui lui sont rattachées, comme la gestion du site web de la ville par exemple.
À ce titre, Patricia est contactée par le service culturel de la ville qui souhaite moderniser la gestion de ses bibliothèques.
John, architecte logiciel, sera chargé de la validation technique du projet.


## Le projet :



**Le batch**<br/>
Le site web ainsi que le batch communiqueront avec ce logiciel en REST afin de connaitre
les informations liées à la Base de donnée.

	
## Les contraintes fonctionnelles


	- Batch : le bacth est responsable de l'envoi journalier de mail lors des retards.
	- Packaging avec Maven.


## Développement

Les outils utilisés pour le développement sont :

IDE : IntelliJ IDEA
Framework Spring : Spring MVC - Spring WEB - Spring SECURITY - Spring DATA
Moteur de template : Thymeleaf
BDD : PostgreSQL V11.5-2


## Déploiement de l'application

**Lancement du batch**

1-Télécharger le repository.
2-Chercher le fichier "application.properties" et modifier les informations suivantes si besoin : 
```
	#To modify if necessary 
	spring.mail.username= your email
	spring.mail.password= your password
```

3-Exécuter la commande maven :
```
	mvn clean package
```
	Le fichier library-batch.jar devrait être créé dans le dossier "target" du repository.
	
4-Copier/coller le fichier obtenu à l'endroit de votre choix sur votre serveur.

5-Lancer l'application batch en utilisant la commande (en étant dans le dossier où se trouve le fichier library-batch.jar): 
```
	java -jar library-batch.jar
```
ATTENTION : il faut que l'API soit lancée. Si une erreur se produit, arrêter le batch, relancer l'api puis relancer le batch.


## Auteur

M.COZ 
