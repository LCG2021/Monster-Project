package project;


public class Creature {
private String name;
private String description;
private int hp;
private int dmg;


// default values for constructor
public Creature() {
name = "";
description = "";
hp = 0;
dmg = 0;
}

// overloaded constructor w parameters
public Creature(String name, String description, int hp, int dmg){
this.name = name;
this.description = description;
this.hp = hp;
this.dmg = dmg;

}

// this prints the actions being taken
public void attack (Creature creature) {
System.out.println(this.name + " attacks " + creature + ", dealing " + dmg + " damage.");
}

// determines if player/monster is dead
public boolean isAlive() {
return hp > 0;
}

// G E T T E R S
public String getName() {
return this.name;
}
public String getDescription() {
return this.description;
}
public int getHP() {
return this.hp;
}
public int getDMG() {
return this.dmg;
}

// S E T T E R S
public void setName(String name) {
this.name = name;
}
public void setDescription(String description) {
this.name = description;
}

public void setHP(int hp) {
this.hp += hp;
}
public void setDMG(int dmg) {
this.dmg = dmg;
}


// outcome of battle determining new hp for both player and creature
public void takeDamage (int dmg) {
hp -= dmg;
if (hp < 0) {
hp = 0;
}
System.out.println(getName() + " has lost " + dmg + " health");
}
}
