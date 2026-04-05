# Spring Boot Backend Application (CI/CD Demo)

This is a professional Spring Boot backend application integrated with **MongoDB**, designed to demonstrate a full **Master-Worker Jenkins CI/CD Pipeline**.

## 🚀 DevOps Features
* **Automated CI:** Triggered via GitHub Webhooks on every `push`.
* **Pipeline as Code:** Managed via a `Jenkinsfile` in the root directory.
* **Distributed Builds:** Execution is offloaded to an **AWS EC2 Worker Node**.
* **Containerization:** Ready for Docker deployment 

## 🛠️ Tech Stack
* **Backend:** Spring Boot 3.x, Java 21, Maven
* **Database:** MongoDB (Running on EC2 Worker)
* **CI/CD:** Jenkins Master-Worker Architecture

## 🏗️ How the Pipeline Works
1. **Developer** pushes code to GitHub.
2. **GitHub Webhook** sends a payload to the Jenkins Master.
3. **Jenkins Master** schedules a build on the **Worker Node**.
4. **Worker Node** pulls code, compiles with Maven, and runs tests.
