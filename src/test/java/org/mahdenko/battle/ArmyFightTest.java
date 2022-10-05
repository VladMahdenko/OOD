package org.mahdenko.battle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mahdenko.battle.characters.Army;
import org.mahdenko.battle.characters.Knight;
import org.mahdenko.battle.characters.Warrior;

import static org.junit.jupiter.api.Assertions.*;

public class ArmyFightTest {

    @Test
    @DisplayName("3 warriors vs 3 warriors")
    void test1(){
        Army army1 = new Army();
        army1.addUnits(Warrior::new, 3);
        Army army2 = new Army();
        army2.addUnits(Warrior::new, 3);

        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("2 warriors vs 3 warriors")
    void test2(){
        Army army1 = new Army();
        army1.addUnits(Warrior::new, 2);
        Army army2 = new Army();
        army2.addUnits(Warrior::new, 3);

        var res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("3 knights vs 3 knights")
    void test3(){
        Army army1 = new Army();
        army1.addUnits(Knight::new, 3);
        Army army2 = new Army();
        army2.addUnits(Knight::new, 3);

        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("4 knights vs 5 warriors")
    void test4(){
        Army army1 = new Army();
        army1.addUnits(Knight::new, 4);
        Army army2 = new Army();
        army2.addUnits(Warrior::new, 5);

        var res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("1 knights vs 3 warriors")
    void test5(){
        Army army1 = new Army();
        army1.addUnits(Knight::new);
        Army army2 = new Army();
        army2.addUnits(Warrior::new, 3);

        var res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("0 vs 0")
    void test6(){
        Army army1 = new Army();
        Army army2 = new Army();

        var res = Battle.fight(army1, army2);

        assertFalse(res);
    }
}
