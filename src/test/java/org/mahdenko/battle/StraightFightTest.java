package org.mahdenko.battle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mahdenko.battle.characters.Army;
import org.mahdenko.battle.characters.warrior.Warrior;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightFightTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("StraightFightTest")
    void armyTest(Army attackers, Army defenders, boolean expected){
        var res = Battle.straightFight(attackers, defenders);

        assertEquals(expected, res);
    }

    static Stream<Arguments> armyTest(){
        return Stream.of(
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 3).organiseForStraightFight(),
                        new Army().addUnits(Warrior::newWarrior, 3).organiseForStraightFight(),
                        true
                ),
                Arguments.of(
                        new Army().organiseForStraightFight(),
                        new Army().organiseForStraightFight(),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newWarrior, 10).organiseForStraightFight(),
                        new Army().addUnits(Warrior::newWarrior, 6).addUnits(Warrior::newLancer, 5).organiseForStraightFight(),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer, 5).addUnits(Warrior::newVampire, 3)
                                .addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 2)
                                .organiseForStraightFight(),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender,4)
                                .addUnits(Warrior::newVampire,6).addUnits(Warrior::newLancer, 5)
                                .organiseForStraightFight(),
                        false
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer, 7).addUnits(Warrior::newVampire, 3)
                                .addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 2)
                                .organiseForStraightFight(),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender,4)
                                .addUnits(Warrior::newVampire,6).addUnits(Warrior::newLancer, 5)
                                .organiseForStraightFight(),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer, 7).addUnits(Warrior::newVampire,3)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newWarrior, 4)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newDefender, 2)
                                .organiseForStraightFight(),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newVampire,6)
                                .addUnits(Warrior::newLancer, 4)
                                .organiseForStraightFight(),
                        true
                ),
                Arguments.of(
                        new Army().addUnits(Warrior::newLancer, 4).addUnits(Warrior::newWarrior, 3)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newWarrior, 4)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newKnight, 2)
                                .organiseForStraightFight(),
                        new Army().addUnits(Warrior::newWarrior, 4).addUnits(Warrior::newDefender, 4)
                                .addUnits(Warrior::newHealer).addUnits(Warrior::newVampire,2)
                                .addUnits(Warrior::newLancer, 4)
                                .organiseForStraightFight(),
                        true
                )
        );
    }
}
