# Dispenser Backend Patient Service (DPB) - Pillwatcher ![](https://travis-ci.com/PillWatcher/pillwatcher-dpb-patient-service.svg?branch=master)

<img src="https://sonarcloud.io/api/project_badges/quality_gate?project=PillWatcher_pillwatcher-dpb-patient-service" align="right"
     alt="Sonar Cloud Quality Gate Status" width="120" height="178">

DPB Service is an API aimed at feeding any patient's Medication and Prescription control platforms. It can be consumed by both mobile and electronic components.

* Validated through **Travis CI** and **SonarCloud**.
* Fully documented with **Swagger**
* **Cloud deployed** to fit different users
* Implements **HATEOAS** pattern

<p align="center">
  <img src="https://github.com/PI2-Grupo-3/pillwatcher-dpb-service/blob/master/images/pillwatcher_logo.jpg" alt="PillWatcher Logo" width="738">
</p>

## Usage

### Java + Maven Endpoint

**DPB Service** uses some Maven provided plugins. It can be build and run through Java 8 and Maven. In that case, those links will be useful:

<details><summary><b>Windows</b></summary>
1. <a href="https://www.java.com/pt_BR/download/help/windows_manual_download.xml">Installing Java on Windows</a>

2. <a href="https://www.baeldung.com/install-maven-on-windows-linux-mac">Install Maven on Windows</a>
</details>

<details><summary><b>Ubuntu</b></summary>
1. <a href="https://www.digitalocean.com/community/tutorials/como-instalar-o-java-com-apt-get-no-ubuntu-16-04-pt">Installing Java on Ubuntu</a>

2. <a href="https://www.baeldung.com/install-maven-on-windows-linux-mac">Installing Maven on Linux</a>
</details>  
  
<details><summary><b>MacOS</b></summary>
1. <a href="https://www.java.com/pt_BR/download/help/mac_install.xml">Installing Java on MacOS</a>

2. <a href="https://www.baeldung.com/install-maven-on-windows-linux-mac">Installing Maven on MacOS</a>
</details>  

### All set, use the following commands:

```sh
$ mvn clean install   # This command will install all maven dependencies
$ mvn clean compile   # This command will run CodeGen to create necessary Interfaces
$ mvn spring-boot:run # This command will run the Project
```

### Docker Endpoint
<details><summary><b>Windows</b></summary>
1. <a href="https://docs.docker.com/docker-for-windows/install/">Installing Docker on Windows</a>
</details>

<details><summary><b>Ubuntu</b></summary>
1. <a href="https://runnable.com/docker/install-docker-on-linux">Installing Docker on Ubuntu</a>
</details>  
  
<details><summary><b>MacOS</b></summary>
1. <a href="https://docs.docker.com/docker-for-mac/install/">Installing Docker on MacOS</a>
</details>  

### All set, use the following commands:

```docker
$ docker-compose up    # This command will start both database and Spring Project (no Java or Maven download necessary)
$ docker-compose up -d # This command will do the same but without logs and you will be able to use same terminal instance
```

<p align="center">
  <img src="https://github.com/PI2-Grupo-3/pillwatcher-dpb-service/blob/master/images/pillwatcher_docker.gif" alt="PillWatcher Logo" width="738">
</p>

> To see docker-compose logs using -d flag, use the command _docker-compose --logs_
