package org.rpgkata;

public class Tree implements Prop {
    private double health;

    public Tree(double initialHealth) {
        this.health = initialHealth;
    }

    public double getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takesDamage(int damage) {
        health = health - damage;
    }

    public void isAttackedBy(Character character) {
        health -= character.dealsDamage();
    }
}
