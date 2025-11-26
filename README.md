# Architecture Microservices avec Spring Cloud

## 📋 Description du Projet

Ce projet implémente une architecture microservices complète en suivant les principes de Spring Cloud. Il comprend plusieurs microservices métier ainsi que des services d'infrastructure pour la gestion de la configuration et la découverte de services.

## 🎯 Travail Réalisé

### 1. Création du micro-service Customer-Service
Le micro-service Customer-Service permet de gérer les clients du système. Il expose une API REST pour consulter la liste des clients et leurs informations détaillées.

**Capture d'écran - Liste des clients:**

![Customer Service API](./images/customer.png)

Cette capture montre l'API REST du service Customer qui retourne la liste des clients avec leurs informations (id, nom, email). On peut observer quatre clients enregistrés : Kholoud, Anas, Imane, et Mona, chacun avec son identifiant unique et son adresse email.

---

### 2. Création du micro-service Inventory-Service
Le micro-service Inventory-Service gère l'inventaire des produits disponibles dans le système.

**Capture d'écran - Liste des produits:**

![Inventory Service API](./images/inventory.png)

Cette capture présente l'API du service Inventory qui retourne la liste des produits en stock. On peut voir quatre produits : Computer (quantité: 10), Printer (quantité: 8), Smartphone (quantité: 12), et Smart Watch (quantité: 14). Chaque produit possède un identifiant unique UUID.

---

### 3. Configuration du Spring Cloud Config Server
Mise en place d'un serveur de configuration centralisée qui gère les propriétés de tous les microservices via un repository GitHub.

**Capture d'écran - Configuration Application:**

![Config Server - Application](./images/config1.png)

Cette capture montre la configuration globale de l'application récupérée depuis le Config Server. On y trouve les paramètres partagés (global.params.p1=555, global.params.p2=777), la configuration Spring H2 Console, et l'URL du service Eureka. Le repository GitHub utilisé est : `https://github.com/kholoudam/config-ecom-app/application.properties`

**Capture d'écran - Configuration Customer-Service:**

![Config Server - Customer Service](./images/config2.png)

Cette capture affiche la configuration spécifique au Customer-Service. Elle contient deux sources de configuration : une depuis le repository customer-service.properties et une autre depuis application.properties. On y voit les paramètres spécifiques au service customer (customer.params.x=11, customer.params.y=22) ainsi que la configuration de la base de données H2.

---

### 4. Création de l'annuaire Eureka Discovery Service
Mise en place du serveur Eureka pour l'enregistrement et la découverte automatique des microservices.

**Capture d'écran - Tableau de bord Eureka:**

![Eureka Dashboard](./images/eureka.png)

Cette capture présente le tableau de bord Eureka Server qui affiche l'état du système. On peut voir :
- **System Status:** Environment test, Uptime de 00:34, avec un seuil de renouvellement de 8
- **DS Replicas:** localhost
- **Instances registered:** Quatre services enregistrés (BILLING-SERVICE, CUSTOMER-SERVICE, GATEWAY-SERVICE, INVENTORY-SERVICE), chacun avec 1 instance active en statut UP
- **General Info:** 93mb de mémoire disponible et 4 CPUs

Un message d'urgence en rouge indique que Eureka peut incorrectement signaler que des instances sont actives quand les renouvellements sont inférieurs au seuil configuré.

---

### 5. Création du service de facturation Billing-Service avec Open Feign
Le Billing-Service gère la facturation en combinant les données des clients (Customer-Service) et des produits (Inventory-Service) grâce à Open Feign.

**Capture d'écran - Détails d'une facture:**

![Billing Service API](./images/billing.png)

Cette capture montre une facture complète générée par le Billing-Service. La facture (id: 1) datée du 26-11-2025 appartient au client Kholoud (customerId: 1). Elle contient la liste des articles commandés avec leurs détails complets. Par exemple, le premier article est un Computer (productId: c6821c35...) avec une quantité de 1 et un prix unitaire de 3200. Le service utilise Open Feign pour récupérer automatiquement les informations du client depuis Customer-Service et les détails des produits depuis Inventory-Service.

---

## 🏗️ Architecture du Système

Le système suit une architecture microservices avec les composants suivants :

1. **Config Server** - Centralise la configuration de tous les services
2. **Eureka Server** - Annuaire de découverte des services
3. **Customer-Service** - Gestion des clients
4. **Inventory-Service** - Gestion des produits
5. **Billing-Service** - Gestion de la facturation (utilise Open Feign)
6. **Gateway-Service** - Point d'entrée unique (routage statique et dynamique)

## 🔧 Technologies Utilisées

- Spring Boot
- Spring Cloud Config
- Netflix Eureka (Service Discovery)
- Spring Cloud Gateway
- Spring Data REST
- OpenFeign (Communication inter-services)
- H2 Database
- GitHub (Repository de configuration)

## 🚀 Ports des Services

- **Config Server:** 8085
- **Eureka Server/ Discovery-Service:** 8083
- **Customer-Service:** 8080
- **Inventory-Service:** 8081
- **Billing-Service:** 8084
- **Gateway-Service:** 8082

## 📝 Ordre de Démarrage

Pour démarrer le système correctement, respecter l'ordre suivant :

1. Config Server
2. Eureka Server
3. Customer-Service
4. Inventory-Service
5. Billing-Service
6. Gateway-Service
