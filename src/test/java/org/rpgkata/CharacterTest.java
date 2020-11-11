package org.rpgkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testCharacterHealing() {
    	Character characterA = new Character(800, 1, true);
    	characterA.heal(100);
    	assertEquals(900, characterA.getHealth());
    	
    }
    
    @Test
    public void testCharacterCantBeHealed() {
    	Character characterA = new Character(0, 1, false);
    	characterA.heal(100);
    	assertEquals(0, characterA.getHealth());
    	assertFalse(characterA.isAlive());
    }
    
    @Test
    public void testCharacterHealingAbove() {
    	Character characterA = new Character(800, 1, true);
    	characterA.heal(300);
    	assertEquals(1000, characterA.getHealth());
    	
    }
    
    @Test
    public void setCorrectParameters() {
    	Character characterA = new Character(0, 1, true);
    	assertEquals(0, characterA.getHealth());
    	assertFalse(characterA.isAlive());
    }

    @Test
    public void setCharacterIsAlive() {
    	Character characterA = new Character(100, 1, false);
    	assertEquals(100, characterA.getHealth());
    	assertTrue(characterA.isAlive());
    }

    @Test
    public void setCharacterIsAliveAndTheHealthDoesNotExceedTheMaximum() {
    	Character characterA = new Character(2000, 1, true);
    	assertEquals(1000, characterA.getHealth());
    	assertTrue(characterA.isAlive());
    }

    @Test
    public void testCharacterIsAlreadyAtMaximumHealing(){
        Character characterA = new Character(1000, 1, true);

        characterA.heal(20);

        assertEquals(1000, characterA.getHealth());
    }

    @Test
    public void testCharactersCannotAttackThemselves(){
        Character characterA = new Character(800, 1, true);

        characterA.isAttackedBy(characterA);

        assertEquals(800, characterA.getHealth());
    }

    @Test
    public void testCharacterTakes50PercentMoreDamageWhenAttackerHas5LevelsMore(){
        Character characterA = new Character(1000, 1, true);
        Character characterB = new Character(1000, 6, true);

        characterA.isAttackedBy(characterB);
        assertEquals(979, characterA.getHealth());
    }

    @Test
    public void testCharacterTakes50PercentLessDamageWhenAttackerHas5LevelsLess(){
        Character characterA = new Character(1000, 6, true);
        Character characterB = new Character(1000, 1, true);

        characterA.isAttackedBy(characterB);
        assertEquals(981, characterA.getHealth());
    }

    @Test
    public void testCharacterHasAnAttackMaxRange(){
        Character characterA = new Character(1000, 6, true, 2);

        assertEquals(2, characterA.getMaxRange());
    }

    @Test
    public void testMeleeCharacterHasAnTwoMetersMaxRange(){
        Character melee = new MeleeCharacter(1000, 6, true);

        assertEquals(2, melee.getMaxRange());
    }

    @Test
    public void testRangedCharacterHasAnTwentyMetersMaxRange(){
        Character rangedFighter = new RangedCharacter(1000, 6, true);

        assertEquals(20, rangedFighter.getMaxRange());
    }

    @Test
    public void testCharactersAreInRangeToDealDamage(){
        Character melee = new MeleeCharacter(1000, 6, true, new Position(1,2));
        Character rangedFighter = new RangedCharacter(1000, 6, true, new Position(3,4));


    }

}

