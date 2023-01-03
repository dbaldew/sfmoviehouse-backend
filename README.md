
### Readme SF Moviehouse Backend

Installatie backend

Om dit bestand te kunnen bekijken is de volgende software nodig:

Java   
https://www.java.com/nl/

Een IDE zoals bijvoorbeeld Intellij  
https://www.jetbrains.com/idea/download/#section=windows

Git   
https://git-scm.com/downloads

Postgress voor de database   
https://www.postgresql.org/

Postman om endpoints te kunnen checken   
https://www.postman.com/downloads/

Clone het project van de volgende github link:  
https://github.com/dbaldew/sfmoviehouse-backend


In Intellij kan het project geopend worden.  
Ga naar File | new | project from  version control


Plak vervolgens de github link die je gecloned hebt in de url.   
Maak een nieuwe map aan voor het project en klik op clone. 
Klik vervolgens op ‘trust project’. Het project zal openen in Intellij.  

Dit project heeft versiebeheer van Maven.  
Ga naar View | Tool windows | Maven  
Er opent zich een zijvenster. Klap de folder uit.  
Ga naar de map ‘lifecycle’.  
Selecteer CLEAN en INSTALL (met ctrl) en klik op run.   
Maven zal het project vervolgens bijwerken.  


Open vervolgens het bestand application.properties  
Vervang de volgende regels met onderstaande:


spring.datasource.url=jdbc:postgresql://localhost:5432/sfmoviehouse

spring.datasource.username=postgres

spring.datasource.password=postgres  


Maak met deze gegevens een datasource aan in Intellij waarmee de verbinding met een postgress database kan worden gelegd  

Hierna kan het project worden opgestart.

Er zijn twee standaard users meegeleverd:  

Gebruikersnaam: admin / Wachtwoord: password  
Gebruikersnaam: user / Wachtwoord: password



