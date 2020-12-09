package org.rpgkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PropTest {

    @Test
    public void canCreateTree(){
        Tree tree = new Tree(2000);
        Assertions.assertTrue(tree.isAlive());
    }

}
