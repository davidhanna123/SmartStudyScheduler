Needed Configurations:


JavaFX - GUI

These directions are for Eclipse IDE. Iy you do not have Eclipse IDE, go to https://www.eclipse.org/downloads/ to download and install it  on your system.

Windows:

step 1: go to https://openjfx.io/
step 2: click on download 
![image](https://github.com/davidhanna123/SmartStudyScheduler/assets/127888836/9b672945-0867-4a1e-b814-e86c2f6f357b)
        scroll down and find the Windows SDK version and download it
![image](https://github.com/davidhanna123/SmartStudyScheduler/assets/127888836/fab3fff6-d00f-4ecb-bfa6-3c22d2966c63)
step 3: extract the zip folder that was downloaded (remember it's location...you will need it later on)
step 4: In Eclipse, go to:
        Window -> Preferences -> Java -> Build Path - User Libraries -> Name it "JavaFX" -> CLick Add External JARs 
        
        Now in the new window that is opened, find the location where the SDK was extracted to and go to:
        
        javafx-sdk-15.0.1 (or a different version depending on when you are installing it) -> lib 
        
        Select all the executabvle JAR files in that folder and click on Open.

        Back in Eclipse, click on Apply and Close.

step 5: Go to the project that you imported in Eclipse and right click on it. Go to:
      Build Path -> Add Libraries -> User Library -> Selectt JavaFX -> Click Finish
step 6: Right CLick on the project in Eclipse and go to
      Run As -> Run Configurations -> Arguments 

      Copy this: --module-path "PATH_TO_lib" --add-modules javafx.controls,javafx.fxml

      Paste it into The Section VM arguments and replace PATH_TO_lib with the actual path to the lib folder in the SDK that you extracted previously. 
      ![image](https://github.com/davidhanna123/SmartStudyScheduler/assets/127888836/8b19dde5-c677-43d8-9a55-d22a680d059c)

      Click on Run.

MacOS:

Follow the same steps as for Windows but replace these steps:

step 2: click on download 
![image](https://github.com/davidhanna123/SmartStudyScheduler/assets/127888836/9b672945-0867-4a1e-b814-e86c2f6f357b)
        scroll down and find the MacOS SDK version and download it
![image](https://github.com/davidhanna123/SmartStudyScheduler/assets/127888836/6d9cdfb4-eb0e-4fd3-bc0e-b3d5d5e6c28b)

step 4: In Eclipse, go to:
        Eclipse -> Preferences -> Java -> Build Path - User Libraries -> Name it "JavaFX" -> CLick Add External JARs 
        
        Now in the new window that is opened, find the location where the SDK was extracted to and go to:
        
        javafx-sdk-15.0.1 (or a different version depending on when you are installing it) -> lib 
        
        Select all the executabvle JAR files in that folder and click on Open.

        Back in Eclipse, click on Apply and Close.

step 6: Right CLick on the project in Eclipse and go to
      Run As -> Run Configurations -> Arguments 

      Copy this: --module-path PATH_TO_lib --add-modules javafx.controls,javafx.fxml

      Paste it into The Section VM arguments and replace PATH_TO_lib with the actual path to the lib folder in the SDK that you extracted previously. 
     ![image](https://github.com/davidhanna123/SmartStudyScheduler/assets/127888836/e6a41b8e-9e89-41c2-8035-845e499d2bb0)


      Click on Run.
      
PostgreSQL and db.properties - Database

step 1:
create a database and name it main.

step 2:
using the sss.sql code provided in src -> Database, create the tables using the sql commands provided.

<img width="619" alt="Screenshot 2024-03-31 at 9 25 26 PM" src="https://github.com/davidhanna123/SmartStudyScheduler/assets/79872036/fb83c8f2-df85-4024-802e-9f55a76291d4">


step 3:
you will find a db.properties file (src -> Database -> db.properties), in lines 2-3 you will see db.username = "xxxx" and
db.password = xxx modify those lines of code to suit the server that you created in PostgreSQL.

