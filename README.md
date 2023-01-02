
### Readme SF Moviehouse Backend
<p></p>
<p>Installatie backend</p>

<p>Om dit bestand te kunnen bekijken is de volgende software nodig:</p>

Java <br>
https://www.java.com/nl/

Een IDE zoals bijvoorbeeld Intellij <br>
https://www.jetbrains.com/idea/download/#section=windows

Git <br>
https://git-scm.com/downloads

Postgress voor de database <br>
https://www.postgresql.org/

Postman om endpoints te kunnen checken <br>
https://www.postman.com/downloads/

Clone het project van de volgende github link: <br>
https://github.com/dbaldew/sfmoviehouse-backend


In Intellij kan het project geopend worden. <br>
Ga naar File | new | project from  version control


Plak vervolgens de github link die je gecloned hebt in de url. Maak een nieuwe map aan voor het project en klik op clone. Klik vervolgens op ‘trust project’. Het project zal openen in Intellij.


Dit project heeft versiebeheer van Maven. <br>
Ga naar View | Tool windows | Maven  <br>
Er opent zich een zijvenster. Klap de folder uit.  <br>
Ga naar de map ‘lifecycle’. <br>
Selecteer CLEAN en INSTALL (met ctrl) en klik op run. Maven zal het project vervolgens bijwerken.


Open het bestand pom.xml
Vervang de volgende regels met onderstaande:


spring.datasource.url=jdbc:postgresql://localhost:5432/sfmoviehouse

spring.datasource.username=postgres

spring.datasource.password=postgres  <br> <br>

Maak de database aan in postgress


Hierna kan het project worden opgestart.


Er zijn twee standaard users meegeleverd:

Gebruikersnaam: admin  <br>
Wachtwoord: password

Gebruikersnaam: user  <br>
Wachtwoord: password



