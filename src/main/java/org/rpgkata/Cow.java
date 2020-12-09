package org.rpgkata;

public class Cow implements Prop {

    private double health;

    public Cow(double health) {
        this.health = health;
    }

    public void isAttackedBy(Character character) {
        health = health - character.dealsDamage();
    }

    public double getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
