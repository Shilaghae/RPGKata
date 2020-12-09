package org.rpgkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PropTest {

    @Test
    public void canCreateTree(){
        Tree tree = new Tree(2000);
        Assertions.assertTrue(tree.isAlive());
    }

    @Test
    public void testPropTakesDamage(){
        Tree tree1 = new Tree(2000);
        tree1.takesDamage(200);
        assertEquals(1800, tree1.getHealth());
    }

    @Test
    public void testCharacterCanAttackTree() {
        Character character = new Character(2000, 5, true);
        Tree tree = new Tree(200);
        tree.isAttackedBy(character);
        assertEquals(180, tree.getHealth());
    }

}
