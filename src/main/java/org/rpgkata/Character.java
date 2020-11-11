package org.rpgkata;

public class Character {

    private double health;
    private int level;
    private boolean isAlive;
    private int maxRange;
    private Position position;

    public Character(double health, int level, boolean isAlive, int maxRange, Position position) {
        this.health = health;
        this.level = level;
        this.isAlive = isAlive;
        this.maxRange = maxRange;
        this.position = position;
        checkStatus();
    }
    public Character(double health, int level, boolean isAlive, int maxRange) {
        this.health = health;
        this.level = level;
        this.isAlive = isAlive;
        this.maxRange = maxRange;
        checkStatus();
    }
    public Character(double health, int level, boolean isAlive) {
        this.health = health;
        this.level = level;
        this.isAlive = isAlive;
        checkStatus();
        position = new Position(0,0);
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

    public double getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void takeDamage(double damage) {
        health = health - damage;

        if (health <= 0) {
            health = 0;
            isAlive = false;
        }
    }

    public void isAttackedBy(Character character) {
        double extraDamage = 0;
        if(getPosition().distance(character.getPosition()) <= character.maxRange) {

            if ((character.getLevel() - level) >= 5) {
                extraDamage = character.dealsDamage() * 0.05;
            }
            double minusDamage = 0;
            if (level - character.getLevel() >= 5) {
                minusDamage = character.dealsDamage() * 0.05;
            }

            if (character != this) {
                double damage = character.dealsDamage();
                damage = damage + extraDamage - minusDamage;
                takeDamage(damage);
            }
        }
    }

    private double dealsDamage() {
        return 20;
    }

    public void heal(int healingPoint) {
        if (this.isAlive)
            this.health = health + healingPoint;
        if (this.health > 1000)
            this.health = 1000;

    }

    public int getMaxRange() {
        return maxRange;
    }

    public Position getPosition() {
        return position;
    }
}
