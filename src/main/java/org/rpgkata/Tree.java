package org.rpgkata;

public class Tree {
    private int health;
    public Tree(int initialHealth) {
        this.health = initialHealth;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return true;
    }

    public void takesDamage(int damage) {
        health = health - damage;
    }

    public void isAttackedBy(Character character) {
        health -= character.dealsDamage();
        assertEquals()
    }
}
