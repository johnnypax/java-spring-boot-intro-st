# Istruzioni di installazione dipendenze:
Per installare le dipendenze esegui i comandi:

```bash
set MAVEN_HOME=C:\Users\ACADEMY\eclipse-st\apache-maven-3.9.11
set PATH=%PATH%;%MAVEN_HOME%\bin
```

N.B. il path C:\Users\ACADEMY\eclipse-st\apache-maven-3.9.11 deve essere il vostro dove avete installato maven in modalità NO INSTALL: [CLICCA QUI](https://dlcdn.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.zip)

### Risoluzione delle dipendenze
Recati sulla cartella, dopo aver eseguito i comandi di sopra, avete a disposizione questo per la risoluzione:

```bash
mvn dependency:resolve
```

### Procedura per setup NodeJS

```bash
set PATH "%PATH%;C:\StandAlone\node-v24.11.0-win-x64"

npm config set proxy http://localhost:9000
npm config set https-proxy http://localhost:9000
```

### Creazione del progetto Angular:

```bash
npm install -g @angular/cli
ng new MyProject1
cd MyProject1
ng serve -o
```


