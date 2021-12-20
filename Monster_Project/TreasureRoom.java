package project;

public class TreasureRoom extends Room {
private String treasure;

//constructor
public TreasureRoom (int roomIndex, String description, Monster monster, String treasure) {
super(roomIndex, description, monster);
this.treasure = treasure;
}

public void enter(Player player) {
// gets details if monster is alive
if (getMonster().isAlive() == true) {
System.out.println(player.getName() + " This Room is " + this.getDescription() + " and has " + getMonster().getName());

}
// fix
if (getMonster().isAlive() == false) {
System.out.print("You explored the room and found the hidden treasure! " + this.treasure);
}
}

}