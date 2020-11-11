package org.rpgkata;

public class MeleeCharacter extends Character {

    public MeleeCharacter(double health, int level, boolean isAlive, Position position) {
        super(health, level, isAlive, 2, position);
    }

    public MeleeCharacter(double health, int level, boolean isAlive) {
        super(health, level, isAlive, 2, new Position(0, 0));
    }
}
