-------------------------------- Mises en route ------------------------------

Activer les trois microservices 

IDE utilsé: Eclipse

Ordre de démarage:

1- ms-produit
2- ms-personnel
3- ms-emprunt
4- api-gateway

Faire des insertions et select via postman
( référence: le dossier Captures Ecran Photos )

------------------------------- Mettre en place des pipeline CI/CD dans chaque microservice -----------------

1 - Placer le fichier: Dockerfile, à la racine de chaque microservice.
2 - Avoir un compte: Docker Hub.
3 - Créer les variables secrets dans le repository du projet:

	DOCKER_USERNAME = ton_user
	DOCKER_PASSWORD = ton_password
	
4 - Ajouter le fichier pipeline GitHub Actions à chaque microservice.

----------------------------------- Test en Local (en cmd) --------------------------------

Exemple:
mvn clean package
docker build -t ms-emprunt .
docker run -p 8082:8082 ms-emprunt

lancer le pipeline
git add .
git commit -m "CI/CD setup"
git push

----------------------------------- Lancer Tous les microservices via le fichier Compose.yml (en cmd) --------------------------------

docker-compose up --build

----------------------------------- Tester les microservices --------------------------------

http://localhost:8080/api/produits
http://localhost:8080/api/personnes ou http://localhost:8080/api/services
http://localhost:8080/api/emprunts
