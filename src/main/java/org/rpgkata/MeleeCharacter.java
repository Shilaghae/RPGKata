package org.rpgkata;

public class MeleeCharacter extends Character {

    public MeleeCharacter(double health, int level, boolean isAlive, Position position) {
        this(health, level, isAlive);
    }

    public MeleeCharacter(double health, int level, boolean isAlive) {
        super(health, level, isAlive, 2);
    }
}
