package org.mahdenko.battle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mahdenko.battle.characters.*;
import org.mahdenko.battle.characters.warrior.Warrior;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ArmyFightTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("ArmyFightTest")
    void armyTest(Army attackers, Army defenders, boolean expected){
        var res = Battle.fight(attackers, defenders);

        assertEquals(expected, res);
    }

    static Stream<Arguments> armyTest(){
        return Stream.of(
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 3),
                        new Army().addUnits(Warrior::newWarrior, 3),
                        true
                ),
                Arguments.of(
                        new Army(), new Army(), false),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender, 2),
                        new Army().addUnits(Warrior::newKnight),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender),
                        new Army().addUnits(Warrior::newVampire, 3),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer),
                        new Army().addUnits(Warrior::newWarrior).addUnits(Warrior::newKnight),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender, 2).addUnits(Warrior::newVampire,2).
                                addUnits(Warrior::newLancer, 4).addUnits(Warrior::newWarrior),
                        new Army().addUnits(Warrior::newWarrior, 2).addUnits(Warrior::newLancer, 2).
                                addUnits(Warrior::newDefender, 2).addUnits(Warrior::newVampire, 2),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior).addUnits(Warrior::newLancer).
                                addUnits(Warrior::newDefender, 2),
                        new Army().addUnits(Warrior::newVampire, 3).addUnits(Warrior::newWarrior).
                                addUnits(Warrior::newLancer, 2),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer),
                        new Army().addUnits(Warrior::newWarrior).addUnits(Warrior::newHealer),
                        false
                )
        );
    }
}
