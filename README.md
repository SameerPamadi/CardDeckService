# CardDeckService

SpringBoot Project, built using Gradle

*	Install java8
*	Install Gradle
*	download / clone this repo
*	SpringBoot runs on tomcat internally and no need to separately starting a server.

# How to access application ?
## option 1: build and run/boot application using Gradle
*	from project folder run the application using
	**gradlew bootrun** (for windows) or 
	**./gradlew bootRun** (from linux)

## option 2: directly run using the jar (simplest way)
*	java -jar build/libs/gs-rest-service-0.1.0.jar

## option 3: eclipse or other IDE.
*	Import the project as 'Gradle Project'.
*	Run src/main/java/cardGame/Application.java as 'Java Application'.

## option 4: AWS Cloud
*	Have uploaded to AWS Elastic Beanstalk (EB will take care of spinning up an instance with Java installed, assigning a security group etc).
*	url of EB -> http://custom-env.fnv3uuraa4.us-east-1.elasticbeanstalk.com (replace http://localhost:8080 with this url)
	ex: Get all the stored cards - http://custom-env.fnv3uuraa4.us-east-1.elasticbeanstalk.com/cards/decks


# Details:

POST is for adding/creating new Resource. PUT is for updating a Resource. 
Please note, this change in assumption.

## urls (tobe run through Postman or using CURL):
none of them need a request body and special Headers.

1) POST http://localhost:8080/cards/decks/{deckName}

Add a new Deck with a name - deckName
	
	
2) PUT  http://localhost:8080/cards/decks/{deckName}/shuffle/{shuffleType}

Shuffle the Deck with *deckName* and shuffle Type *shuffleType*
	
	
3) PUT  http://localhost:8080/cards/decks/{deckName}/shuffle/{shuffleType}?shuffleCount=15

the number of time shuffling needs to be repeated is controlled by *shuffleCount*. 
By default it is 10, if not provided as queryParam *shuffleCount*. 
Have made this assumption to provide more control over the selection of shuffling and its iterations.
a 404 is returned response StatusCode if the specified *deckName* is not available or shuffleType is invalid. 
(another way is just to Random shuffle by default if wrong shuffleType is given by user or is not provided)
	
	
4) GET http://localhost:8080/cards/decks

Get all named decks available
	
	
5) GET http://localhost:8080/cards/decks/{deckName}

Get a named Deck 
	

6) DELETE http://localhost:8080/cards/decks/{deckName}

Delete a deck with *deckName*
	
	
	
## Implementation details.

### DeckService.java

This class creates new Named deck and also provide methods to shuffle decks.
Each card (viz. 5-heart, K-spade) is represented as String, which are stored in a Deck. 
for more complex shuffle algorithms,  prioritied handling of cards is required, each card in a deck can be Object instead of just String.
	
### CardService.java
	
This class maintains all DeckofCards - Decks in a Map.
Helps in calling DeckService for creating a new Deck and call appropriate Shuffle algorithms based on user selection.
	
