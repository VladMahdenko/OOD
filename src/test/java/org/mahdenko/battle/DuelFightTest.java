package org.mahdenko.battle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mahdenko.battle.characters.Defender;
import org.mahdenko.battle.characters.Knight;
import org.mahdenko.battle.characters.Rookie;
import org.mahdenko.battle.characters.Warrior;

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
                Arguments.of(new Knight(), new Warrior(), true),
                Arguments.of(new Warrior(), new Knight(), false),
                Arguments.of(new Knight(), new Knight(), true),
                Arguments.of(new Knight(), new Rookie(), true),
                Arguments.of(new Warrior(), new Rookie(), true),
                Arguments.of(new Rookie(), new Warrior(), false),
                Arguments.of(new Rookie(), new Knight(), false),
                Arguments.of(new Knight(), new Defender(), true),
                Arguments.of(new Warrior(), new Defender(), false),
                Arguments.of(new Rookie(), new Defender(), false),
                Arguments.of(new Defender(), new Knight(), false),
                Arguments.of(new Defender(), new Warrior(), true),
                Arguments.of(new Defender(), new Rookie(), true)
        );
    }

}
