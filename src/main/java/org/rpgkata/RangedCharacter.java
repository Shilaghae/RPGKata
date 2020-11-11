package org.rpgkata;

public class RangedCharacter extends Character {
    public RangedCharacter(double health, int level, boolean isAlive, Position position) {
        this(health, level, isAlive);
    }

    public RangedCharacter(double health, int level, boolean isAlive) {
        super(health, level, isAlive, 20);
    }
}
