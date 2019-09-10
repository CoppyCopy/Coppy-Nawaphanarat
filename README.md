# SENG201-SpaceExplorer

-Welcome to the Space Explorer-

Before doing anything, you must:
    - Extract the folder called "SpaceExplorer.zip".

To run the game from the source codes:
    - To run the game, you must go on Eclipse or any compatibility software that is supported with java language. For this case, we are focusing on Eclipse.
    - Go on Eclipse, click on "File" on the top left tab, then select "Open Projects from File System".
    - Import your project (where you extracted SpaceExplorer). "Select All" to get all the source codes, then click "Finish".
    - In your "Project Explorer" or your "Workspace" window, go to "SpaceExplorer" folder.
    - Select "SENG201-Assignment/src" folder, then select "GameEnvironment" package, and then double click on "Game.java".
    - Right click in your Game.java window, then select "Run as" -> "Java Application". So, now the game should run it.

To run the game from the game application (.jar) without Terminal (Linux user only):
    - Open "SpaceExplorer" folder, where you extracted it.
    - Double-click on "sna134_cyh29_SpaceExplorer.jar" to run the game application.
    - Just in case if it says "Blocked" or unable to execute the program.
        - you right-click on it, then select "Properties", then go to "Permissions" on the top tab, and then tick "Allow executing file as program".

To run the game from the game application (.jar) with Terminal (Linux user only):
    - Open "SpaceExplorer" folder, where you extracted it.
    - Open the Terminal or you can just right-click inside the "SpaceExplorer" folder, then select "Open in Terminal".
    - If you run the Terminal outside the folder, then you have to redirectory to your extracted folder, using "cd (name of your directory)".
    - In the terminal, you typed in "java -jar sna134_cyh29_SpaceExplorer.jar" to execute the game application.
    - The game should run it now.

The rules of the game:
    - If your Spaceship's hull is at 0, then the game is over.
    - If all of your crew members dies by Space Plague, then the game is over.
    - If the player is able to find all the missing transport parts from the planets, then the game should conclude. 
    - If your crew member(s) is still untreated (Unhealthy) from the Space Plague, then they will take 20 damage from each new day. 
    - Unless, if the crew member's type is "Absolute Unit", then they will take only half of its damage.
    - After the game is concluded, then the score screen will appears with the crew member's list, the crew team's name, the total scores, parts, etc.

The mechanics of the game:
    - In the Pilot Room, there is an option to use "Tactical Jump". That is only available if and only if there is a crew member's type is Tactical Commander in the team. 
    - This allows the Spaceship to travel to any planet without any incident in its way. It has 2 days of cooldown after each uses.
    - In the Medic Room, only way to access is if and only if there is a crew member's type is Medic in the team.
    - For the inventory storage, the player can holds up to 10 items. Unless, the searching member finds 2 items when the storage is at 9 items, then 11 items is acceptable.
    - Even so if your inventory is full and you found the items from the searching member, then your score is still applies.

-Happy Gaming!-
