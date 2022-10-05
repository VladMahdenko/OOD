package org.mahdenko.battle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mahdenko.battle.characters.Knight;
import org.mahdenko.battle.characters.Warrior;

import static org.junit.jupiter.api.Assertions.*;

public class DuelFightTest {

    @Test
    @DisplayName("Warrior vs Knight")
    void test1(){
        var carl = new Warrior();
        var jim = new Knight();

        var res = Battle.fight(carl, jim);

        assertFalse(res);
    }


    @Test
    @DisplayName("Knight vs Warrior")
    void test2(){
        var carl = new Warrior();
        var jim = new Knight();

        var res = Battle.fight(jim, carl);

        assertTrue(res);
    }


    @Test
    @DisplayName("Warrior vs Warrior")
    void test3(){
        var carl = new Warrior();
        var jim = new Warrior();

        var res = Battle.fight(carl, jim);

        assertTrue(res);
    }

    @Test
    @DisplayName("Warrior vs Knight vs Warrior")
    void test4(){
        var carl = new Warrior();
        var jim = new Knight();
        var alex = new Warrior();

        Battle.fight(carl, jim);
        var res = Battle.fight(jim, alex);

        assertFalse(res);
    }
}
