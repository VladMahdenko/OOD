package org.mahdenko.battle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mahdenko.battle.characters.Army;
import org.mahdenko.battle.characters.Defender;
import org.mahdenko.battle.characters.Knight;
import org.mahdenko.battle.characters.Warrior;

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
                        new Army().addUnits(Warrior::new, 3),
                        new Army().addUnits(Warrior::new, 3),
                        true
                ),
                Arguments.of(
                        new Army(), new Army(), false),
                Arguments.of(
                        new Army().addUnits(Defender::new, 2),
                        new Army().addUnits(Knight::new),
                        true
                )

        );
    }
}
