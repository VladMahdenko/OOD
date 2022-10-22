package org.mahdenko.battle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mahdenko.battle.characters.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DuelFightTest {
    @ParameterizedTest(name = "[{index}] ({0}) against ({1}), first wins?: {2}")
    @MethodSource
    @DisplayName("Duel test")
    void duelTest(Warrior warrior1, Warrior warrior2, boolean expected){
        var res = Battle.fight(warrior1, warrior2);
        assertEquals(expected, res);
    }

    static Stream<Arguments> duelTest(){
        return Stream.of(
                Arguments.of(new Warrior(), new Warrior(), true),
                Arguments.of(new Knight(), new Knight(), true),
                Arguments.of(new Knight(), new Warrior(), true),
                Arguments.of(new Warrior(), new Knight(), false),
                Arguments.of(new Rookie(), new Rookie(), true),
                Arguments.of(new Knight(), new Rookie(), true),
                Arguments.of(new Warrior(), new Rookie(), true),
                Arguments.of(new Rookie(), new Warrior(), false),
                Arguments.of(new Rookie(), new Knight(), false),
                Arguments.of(new Defender(), new Defender(), true),
                Arguments.of(new Knight(), new Defender(), true),
                Arguments.of(new Warrior(), new Defender(), false),
                Arguments.of(new Rookie(), new Defender(), false),
                Arguments.of(new Defender(), new Knight(), false),
                Arguments.of(new Defender(), new Warrior(), true),
                Arguments.of(new Defender(), new Rookie(), true),
                Arguments.of(new Vampire(), new Vampire(), true),
                Arguments.of(new Defender(), new Vampire(), true),
                Arguments.of(new Knight(), new Vampire(), true),
                Arguments.of(new Warrior(), new Vampire(), true),
                Arguments.of(new Rookie(), new Vampire(), false),
                Arguments.of(new Vampire(), new Defender(), false),
                Arguments.of(new Vampire(), new Knight(), false),
                Arguments.of(new Vampire(), new Warrior(), true),
                Arguments.of(new Vampire(), new Rookie(), true)
                );
    }

}
