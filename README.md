# Pokemon Text Adventure
RUNNING FROM JAR FILE
1. Download Pokemon Text Adventure v1.0.zip from the releases page
2. Extract with 7zip, winrar, or other extraction software to obtain .jar file
2. Run the .jar program
 
RUNNING FROM ECLIPSE
1. Start Eclipse IDE
2. Navigate to File on the upper toolbar
3. Click on import
4a. Click on "Existing Projects into Workspace" under "General" and select the .project in the 1_code folder
4b. Click on "Projects from Folder or Archive" under general and select the 1_code folder
5. Right click the project name in the Project Explorer
6. Select "Run As"
7. Select "4 Maven Build..."
8. For "Goals", type "compile exec:java -Dexec.mainClass="mainGame.UI"
9. Click "Run"
