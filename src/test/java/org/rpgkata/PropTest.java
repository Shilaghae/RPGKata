package org.rpgkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PropTest {

    @Test
    public void canCreateTree(){
        Tree tree = new Tree(2000);
        assertTrue(tree.isAlive());
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
    
    @Test 
    public void testObjectIsDestroyed() {
    	 Character character = new Character(2000, 5, true);
         Prop tree = new Tree(20);
         tree.isAttackedBy(character);
         assertEquals(0, tree.getHealth());
         assertFalse(tree.isAlive());
    }

    @Test
    public void testIsDestroyed() {
    	 Character character = new Character(2000, 5, true);
         Prop cow = new Cow(80);
         cow.isAttackedBy(character);
         assertEquals(60, cow.getHealth());
         assertTrue(cow.isAlive());
    }
}
