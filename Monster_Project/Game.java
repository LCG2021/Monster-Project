package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Game {

private boolean active = true;
public Player player;
public Battle fight1;
public Battle fight2;
public Battle fight3;
public Room[] dungeon;
private Monster monster1;
private Monster monster2;
private Monster monster3;
private Room room1;
private Room room2;
private TreasureRoom treasureRoom;



//checks if file exists
public Game() {


File playerInfo = new File("PlayerInfo.txt");

if(playerInfo.exists()) {

System.out.println("File exists");
} else {
System.out.println("File doesn't exist");
}

playerInfo.canRead();


try {
BufferedReader br = new BufferedReader( new FileReader(playerInfo));

//String line;
try {


String name = br.readLine();
String description = br.readLine();
int hitPoints = Integer.parseInt(br.readLine());
int damage = Integer.parseInt(br.readLine());
int healAmount = Integer.parseInt(br.readLine());

player = new Player(name,description,hitPoints,damage,healAmount);



} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
//player = new Player("Angeline", "Scary", 100, 15, 25);
monster1 = new Monster("Orc","covered with green blood", 20,5,0, active );
fight1 = new Battle(player, monster1);
room1 = new Room(0,"a room with an unbearable smell",monster1);
monster2 = new Monster("Skeleton","funny how it moves", 40,10,10, active );
fight2 = new Battle(player, monster2);
room2 = new Room(1,"dark and cold",monster2);
monster3 = new Monster("Fire dragon","spout fire with each breath", 100,20,40, active );
fight3 = new Battle(player, monster3);
treasureRoom = new TreasureRoom(2,"a giant hall with something shiny on the other end",monster3,"a large pile of gold");

dungeon = new Room[] {room1,room2,treasureRoom};



}

public void play() {

while(active) {
if(monster1.isAlive()) {
room1.enter(player);
fight1.run();

}
if(monster2.isAlive()) {
room2.enter(player);
fight2.run();
}
if(monster3.isAlive()) {
treasureRoom.enter(player);
fight3.run();
}

if(!(monster1.isAlive() && monster2.isAlive() && monster3.isAlive()) || !player.isAlive() ) {
this.active = false;
}
}
}
public void writeToNewFile(String fileName, String fileContent){
PrintWriter outStream =null;//use the PrintWriter to create our output stream
try {
outStream = new PrintWriter(fileName);//create & connect the output stream to the file using the String fileName
outStream.println(fileContent);//write the String to the file
System.out.println("Successfully wrote to the file "+fileName);
} catch (FileNotFoundException e) {
e.printStackTrace();

System.out.println("Inside writeToNewFile method problem creating/write the file "+fileName);
}
finally{
if(outStream != null){//if not closed
outStream.close(); //close it
}
System.out.println("All done with writeToNewFile method");
}
}

public static void main(String[] args) {

Game game = new Game();


game.play();
}


}