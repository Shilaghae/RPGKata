package org.rpgkata;

public class Character {

    private int health;
    private int level;
    private boolean isAlive;

    public Character(int health, int level, boolean isAlive) {
        this.health = health;
        this.level = level;
        this.isAlive = isAlive;
        checkStatus();
    }

    private void checkStatus() {
        if (health <= 0) {
            isAlive = false;
            health = 0;
        } else {
            isAlive = true;
        }
        if (health > 1000) {
            health = 1000;
        }
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

        if (health <= 0) {
            health = 0;
            isAlive = false;
        }
    }

    public void isAttackedBy(Character character) {
        if (character != this){
            var damage = character.dealsDamage();
            takeDamage(damage);
        }
    }

    private int dealsDamage() {
        return 20;
    }

    public void heal(int healingPoint) {
        if (this.isAlive)
            this.health = health + healingPoint;
        if (this.health > 1000)
            this.health = 1000;

    }
}
