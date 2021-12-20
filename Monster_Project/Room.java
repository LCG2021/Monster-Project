package project;

public class Room {
private int roomIndex;
private String description;


private Monster monster;

// room constructor
public Room(int roomIndex, String description, Monster monster) {
this.roomIndex = roomIndex;
this.description = description;
this.monster = monster;
}


//checks if room is completed
public boolean isComplete() {
if (monster.isAlive() == false) {
return false;}
return true;
}



// room name, monster inside, battle start
public void enter(Player player) {
if (monster.isAlive() == true) {
System.out.println(player.getName() + ", this room is " + this.description + " and has an " + monster.getName());
}
}

// G E T T E R S
public int getRoomIndex() {
return this.roomIndex;
}
public String getDescription() {
return this.description;
}
public Monster getMonster() {
return this.monster;
}

// S E T T E R S
public void setRoomIndex(int roomIndex) {
this.roomIndex = roomIndex;
}
public void setDescription(String description) {
this.description = description;
}
public void setMonster(Monster monster) {
this.monster = monster;
}

@Override
public String toString() {
return String.format("roomIndex %5d, description %20s, monster %10s", roomIndex, description, monster.getName());
}


}
