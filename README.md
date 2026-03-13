This virtual point-and-click pet game resembles the real-life experience of taking care of a pet, but with a twist. You can choose from 3 different types of pets and name them to your liking. In this game, you are tasked with feeding and playing with your pet. However, not taking care of your pet can lead to his hunger, happiness, health, and sleep decreasing and eventually lead to his dying. Taking care of your pet allows you to gain both XP and money to unlock new items and purchase various foods for your pet from the shop. Each pet adds a new level of difficulty to the game with different stats and settings to make the game a challenge. Parents can also set restrictions on children and reset the pet if it ever dies. 


The required list of libraries and third-party tools required to run or build the software includes:


- SceneBuild - Third-party software to create all GUI screens. 

- JavaFX 23.0.1 - A set of Graphics media packages to create, test, debug and deploy applications.

- Json Simple 1.1.1 - A toolkit to encode and decode in json. 

- Gson 2.10.1 - Allows us to convert Java objects to JSON. 

- Java Development Kit (JDK 23) - Allows us to run and compile the program 

- Maven - Used to manage dependencies for the project. 

To start, a JDK 23 must be downloaded from https://www.oracle.com/java/technologies/downloads/?er=221886. Next, to using VSCode as an IDE to create a Maven project with JavaFX, go to Help → Show all Commands → Java: create Java project… → JavaFX → com.example → name the file. If errors were to occur with this process, download Maven manually using https://maven.apache.org/download.cgi, then go to downloads and click the link for the binary zip.archive. Once the file is unzipped, place the folder anywhere and follow this guide https://phoenixnap.com/kb/install-maven-windows. After this is complete, we must include all our dependencies to ensure the rest of it works. This would include JSON Simple, GSON. Go to “Pom.xml” and include the following dependencies between the < dependencies> tags: 


< dependency> < groupId>org.openjfx< /groupId> < artifactId>javafx-media< /artifactId> < version>23.0.1< /version> < /dependency> < dependency> < groupId>com.googlecode.json-simple< /groupId> < artifactId>json-simple< /artifactId> < version>1.1.1< /version> < /dependency> < dependency> < groupId>com.google.code.gson< /groupId> < artifactId>gson< /artifactId> < version>2.10.1< /version> < /dependency>


Next, in the “module-info.java” file, include the following: 

Requires javafx.media; 
requires json.simple; 
requires com.google.gson;

The file is now ready for use. To start the program and run it, click on the top right run button inside VSCODE while on the “App.java” file. 

The software begins on the main menu, where you can select either start game or load game. If you already have a game, you can continue it or start a new game. Once you start a new game, you can select which pet you want to use, all with different difficulties and then choose its name. To satisfy your pet's hunger, you must feed it, where you can purchase different food items from the shop that all have various effects, good or bad and will increase its hunger. You can play with it by clicking on the screen resembling you petting it, where you will earn money and xp to buy new gifts, toys or foods. You can also put it to sleep to increase its sleep state, play and exercise with it to increase happiness or give it a gift to increase happiness. However, once you play with it, a cool down starts, and you won't be able to play with it until it's done. Your pet will automatically sleep if it runs out of energy, or will get mad if its happiness goes down, and limitations will be put on the user. You can also take it to the vet to increase its health. 

The parental menu, once clicked on will prompt the user with a password to access it. The password is: goofy. Where parents can set restrictions on the child to allow them to set a certain time of play. They are also able to revive dead pets and see the user's game statistics (how long their session is, etc.). 

