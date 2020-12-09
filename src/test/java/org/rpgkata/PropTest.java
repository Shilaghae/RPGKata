package org.rpgkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        assertEquals(800, tree1.getHealth());
    }

}
