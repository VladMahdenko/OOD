package org.mahdenko.battle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mahdenko.battle.characters.warrior.Warrior;

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
                Arguments.of(Warrior.newWarrior(),Warrior.newWarrior(), true),
                Arguments.of(Warrior.newKnight(), Warrior.newKnight(), true),
                Arguments.of(Warrior.newKnight(), Warrior.newWarrior(), true),
                Arguments.of(Warrior.newWarrior(), Warrior.newKnight(), false),
                Arguments.of(Warrior.newRookie(), Warrior.newRookie(), true),
                Arguments.of(Warrior.newKnight(), Warrior.newRookie(), true),
                Arguments.of(Warrior.newWarrior(), Warrior.newRookie(), true),
                Arguments.of(Warrior.newRookie(), Warrior.newWarrior(), false),
                Arguments.of(Warrior.newRookie(), Warrior.newKnight(), false),
                Arguments.of(Warrior.newDefender(), Warrior.newDefender(), true),
                Arguments.of(Warrior.newKnight(), Warrior.newDefender(), true),
                Arguments.of(Warrior.newWarrior(), Warrior.newDefender(), false),
                Arguments.of(Warrior.newRookie(), Warrior.newDefender(), false),
                Arguments.of(Warrior.newDefender(), Warrior.newKnight(), false),
                Arguments.of(Warrior.newDefender(), Warrior.newWarrior(), true),
                Arguments.of(Warrior.newDefender(), Warrior.newRookie(), true),
                Arguments.of(Warrior.newVampire(), Warrior.newVampire(), true),
                Arguments.of(Warrior.newDefender(), Warrior.newVampire(), true),
                Arguments.of(Warrior.newKnight(), Warrior.newVampire(), true),
                Arguments.of(Warrior.newWarrior(), Warrior.newVampire(), true),
                Arguments.of(Warrior.newRookie(), Warrior.newVampire(), false),
                Arguments.of(Warrior.newVampire(), Warrior.newDefender(), false),
                Arguments.of(Warrior.newVampire(), Warrior.newKnight(), false),
                Arguments.of(Warrior.newVampire(), Warrior.newWarrior(), true),
                Arguments.of(Warrior.newVampire(), Warrior.newRookie(), true),
                Arguments.of(Warrior.newLancer(), Warrior.newLancer(), true),
                Arguments.of(Warrior.newLancer(), Warrior.newWarrior(), true),
                Arguments.of(Warrior.newLancer(), Warrior.newRookie(), true),
                Arguments.of(Warrior.newLancer(), Warrior.newKnight(), false),
                Arguments.of(Warrior.newLancer(), Warrior.newDefender(), true),
                Arguments.of(Warrior.newLancer(), Warrior.newVampire(), true),
                Arguments.of(Warrior.newWarrior(), Warrior.newLancer(), false),
                Arguments.of(Warrior.newRookie(), Warrior.newLancer(), false),
                Arguments.of(Warrior.newKnight(), Warrior.newLancer(), true),
                Arguments.of(Warrior.newDefender(), Warrior.newLancer(), false),
                Arguments.of(Warrior.newVampire(), Warrior.newLancer(), false),
                Arguments.of(Warrior.newHealer(), Warrior.newWarrior(), false),
                Arguments.of(Warrior.newHealer(), Warrior.newKnight(), false),
                Arguments.of(Warrior.newHealer(), Warrior.newRookie(), false),
                Arguments.of(Warrior.newHealer(), Warrior.newDefender(), false),
                Arguments.of(Warrior.newHealer(), Warrior.newVampire(), false),
                Arguments.of(Warrior.newHealer(), Warrior.newLancer(), false),
                Arguments.of(Warrior.newWarrior(), Warrior.newHealer(), true),
                Arguments.of(Warrior.newKnight(), Warrior.newHealer(), true),
                Arguments.of(Warrior.newRookie(), Warrior.newHealer(), true),
                Arguments.of(Warrior.newDefender(), Warrior.newHealer(), true),
                Arguments.of(Warrior.newVampire(), Warrior.newHealer(), true),
                Arguments.of(Warrior.newLancer(), Warrior.newHealer(), true)
                );
    }

}
