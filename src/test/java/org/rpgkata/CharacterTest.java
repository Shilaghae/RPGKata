package org.rpgkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.accessibility.AccessibleStateSet;

public class CharacterTest {

    @Test
    public void test() {
        Character characterA = new Character(1000, 1, true);
        Assertions.assertEquals(1000, characterA.getHealth());
        Assertions.assertEquals(1, characterA.getLevel());
        Assertions.assertTrue(characterA.isAlive());
    }

    @Test
    public void takeDamage() {
        Character characterA = new Character(1000, 1, true);
        characterA.takeDamage(200);
        Assertions.assertEquals(800, characterA.getHealth());

    }

}
