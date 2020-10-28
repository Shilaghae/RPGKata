package org.rpgkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.accessibility.AccessibleStateSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    @Test
    public void testInitialiseCharacter() {
        Character characterA = new Character(1000, 1, true);
        assertEquals(1000, characterA.getHealth());
        assertEquals(1, characterA.getLevel());
        Assertions.assertTrue(characterA.isAlive());
    }

    @Test
    public void testTakeDamage() {
        Character characterA = new Character(1000, 1, true);
        characterA.takeDamage(200);
        assertEquals(800, characterA.getHealth());
    }

    @Test
    public void testCharacterDies(){
        Character characterA = new Character(1000, 1, true);
        characterA.takeDamage(1010);
        assertEquals(0, characterA.getHealth());
        assertEquals(false, characterA.isAlive());
    }

    @Test
    public void testCharacterDealsDamage(){
        Character characterA = new Character(1000, 1, true);
        Character characterB = new Character(1000, 1, true);

        characterA.isAttackedBy(characterB);
        assertEquals(980, characterA.getHealth());
    }

}
