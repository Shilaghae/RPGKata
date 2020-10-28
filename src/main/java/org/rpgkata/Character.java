package org.rpgkata;

public class Character {

    private int health;
    private int level;
    private boolean isAlive;

    public Character(int health, int level, boolean isAlive) {
        this.health = health;
        this.level = level;
        this.isAlive = isAlive;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void takeDamage(Integer damage) {
        health = health - damage;

        if(health <= 0){
            health = 0;
            isAlive = false;
        }
    }

    public void isAttackedBy(Character characterB) {
        var damage = characterB.dealsDamage();
        takeDamage(damage);
    }

    private int dealsDamage() {
        return 20;
    }
}
