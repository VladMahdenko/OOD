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
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 1),
                        new Army().addUnits(Warrior::newWarrior, 2),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 2),
                        new Army().addUnits(Warrior::newWarrior, 3),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 5),
                        new Army().addUnits(Warrior::newWarrior, 7),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 20),
                        new Army().addUnits(Warrior::newWarrior, 21),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 10),
                        new Army().addUnits(Warrior::newWarrior, 11),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 11),
                        new Army().addUnits(Warrior::newWarrior, 7),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 5).addUnits(Warrior::newDefender, 4),
                        new Army().addUnits(Warrior::newDefender, 5).addUnits(Warrior::newWarrior, 4),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender, 5).addUnits(Warrior::newWarrior, 20),
                        new Army().addUnits(Warrior::newWarrior, 21).addUnits(Warrior::newDefender, 4),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 10).addUnits(Warrior::newDefender, 5),
                        new Army().addUnits(Warrior::newDefender, 5).addUnits(Warrior::newWarrior, 10),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender, 2).addUnits(Warrior::newWarrior, 1),
                        new Army().addUnits(Warrior::newDefender, 1).addUnits(Warrior::newWarrior, 5),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender, 5).addUnits(Warrior::newVampire, 6)
                                .addUnits(Warrior::newWarrior, 7),
                        new Army().addUnits(Warrior::newWarrior, 6).addUnits(Warrior::newDefender, 6)
                                .addUnits(Warrior::newVampire, 6),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender, 2).addUnits(Warrior::newVampire, 3)
                                .addUnits(Warrior::newWarrior, 4),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newVampire, 3),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender, 11).addUnits(Warrior::newVampire, 3)
                                .addUnits(Warrior::newWarrior, 4),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newVampire, 13),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newDefender, 9).addUnits(Warrior::newVampire, 3)
                                .addUnits(Warrior::newWarrior, 8),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newVampire, 13),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer, 5).addUnits(Warrior::newVampire, 3)
                                .addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 2),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newVampire, 6).addUnits(Warrior::newLancer, 5),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer, 7).addUnits(Warrior::newVampire, 3)
                                .addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 2),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newVampire, 6).addUnits(Warrior::newLancer, 4),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 2),
                        new Army().addUnits(Warrior::newLancer).addUnits(Warrior::newWarrior),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer, 7).addUnits(Warrior::newVampire,3)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newWarrior, 4)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newDefender, 2),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newVampire,6)
                                .addUnits(Warrior::newLancer, 4),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer).addUnits(Warrior::newWarrior, 3)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newWarrior, 4)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newKnight, 2),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newVampire,6)
                                .addUnits(Warrior::newLancer, 4),
                        false
                )
        );
    }
}
