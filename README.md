# ⚽ Spring Foot API (back-foot-project)

Bienvenue sur l'API de gestion de football ! Ce projet est un backend développé avec **Spring Boot** permettant de gérer des équipes, des joueurs, des entraîneurs et des stades.

---

## 🛠️ Technologies utilisées

* **Java** (Version 21)
* **Spring Boot** (Web, Data JPA)
* **PostgreSQL** (Hébergé sur Supabase)
* **Hibernate** (ORM)
* **HikariCP** (Gestionnaire de connexions)

---

## 📋 Architecture du Projet

Le projet respecte une architecture en couches standard pour assurer une bonne séparation des responsabilités :
* **Controllers** : Gestion des points d'accès (Endpoints REST).
* **Services** : Logique métier (gestion des transactions, validation).
* **Repositories** : Interaction avec la base de données PostgreSQL via Spring Data JPA.
* **DTOs (Data Transfer Objects)** : Sécurisation et optimisation des données exposées par l'API (avec mapping).

---

## ⚙️ Configuration et Installation

### 1. Prérequis
Avant de lancer le projet, assure-toi d'avoir installé :
* Un JDK (Java Development Kit) version 21
* Maven

### 2. Variables d'environnement
Pour des raisons de sécurité, les identifiants de la base de données ne sont pas écrits en dur dans le code. Tu dois configurer les variables d'environnement suivantes sur ta machine ou dans ton IDE :

| Variable | Description |
| :--- | :--- |
| `DB_URL` | L'URL JDBC de ta base de données PostgreSQL (ex: Supabase) |
| `DB_USERNAME` | Ton identifiant de base de données |
| `DB_PASSWORD` | Ton mot de passe de base de données |

### 3. Lancement de l'application

**Via le terminal :**
Exécute la commande suivante à la racine du projet :
```bash
./mvnw spring-boot:run
