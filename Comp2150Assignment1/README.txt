To compile the classes, copy and paste the following line into the command line:
javac Main.java Commands.java LinkedList.java Node.java NodeData.java User.java Student.java Tutor.java Topic.java Appointment.java
 
To run the program, copy and paste the following line into the command line:
java Main

The console will then ask for text file to open, enter the name of the text file into the console to open. 


To compile the junit tests, copy and paste the following line into the command line:
javac -cp .:junit-platform-console-standalone-1.6.0.jar LinkedListTest.java CommandsTest.java

To run the junit tests, copy and paste the following line into the command line:
java -jar junit-platform-console-standalone-1.6.0.jar --class-path . --scan-class-path