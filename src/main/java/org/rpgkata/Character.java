package org.rpgkata;

import java.util.ArrayList;
import java.util.List;

public class Character {

    private double health;
    private final int level;
    private boolean isAlive;
    private int maxRange;
    private Position position;
    private List<Faction> factions = new ArrayList<Faction>();

    public Character(double health, int level, boolean isAlive, int maxRange, Position position) {
        this(health, level, isAlive, maxRange);
        this.position = position;
    }
    public Character(double health, int level, boolean isAlive, int maxRange) {
        this(health, level, isAlive);
        this.maxRange = maxRange;
    }
    public Character(double health, int level, boolean isAlive) {
        this.health = health;
        this.level = level;
        this.isAlive = isAlive;
        position = new Position(0,0);
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
        if(isAlly(character))
            return;
        if(getPosition().getDistance(character.getPosition()) <= character.maxRange) {
            double extraDamage = getDamageFactor(character, character.getLevel(), level);
            double minusDamage = getDamageFactor(character, level, character.getLevel());

            if (character != this) {
                double damage = character.dealsDamage();
                damage = damage + extraDamage - minusDamage;
                takeDamage(damage);
            }
        }
    }

    private double getDamageFactor(Character character, int level, int level2) {
        double minusDamage = 0;
        if (level - level2 >= 5) {
            minusDamage = character.dealsDamage() * 0.05;
        }
        return minusDamage;
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

    public boolean isMemberOf(Faction fire) {
        for (int i = 0; i < factions.size(); i++){
            if (factions.get(i).getFactionName() == fire.getFactionName())
                return true;
        }
        return false;
    }

    public void addFaction(Faction faction) {
        factions.add(faction);
    }


    public void removeFaction(Faction faction) {
        factions.remove(faction);
    }

    public boolean isAlly(Character character) {
        for (int i = 0; i < factions.size(); i++) {
            if (character.isMemberOf(factions.get(i))) {
                return true;
            }
        }
        return false;

    }

    public void isHealedBy(Character character) {

    }
}
