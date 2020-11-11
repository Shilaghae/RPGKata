package org.rpgkata;

public class RangedCharacter extends Character {
    public RangedCharacter(double health, int level, boolean isAlive, Position position) {
        super(health, level, isAlive, 20, position);
    }

    public RangedCharacter(double health, int level, boolean isAlive) {
        super(health, level, isAlive, 2, new Position(0, 0));
    }
}
