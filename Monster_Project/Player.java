package project;


public class Player extends Creature{

private int healAmount;

// gets parameters from creature
public Player(String name, String description, int hp, int dmg, int healAmount) {
super(name, description, hp, dmg);
this.healAmount = healAmount;
}
//increases player health by healAmount
public void heal() {
setHP(healAmount);
}


}
