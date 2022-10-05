package org.mahdenko.battle;

import org.mahdenko.battle.characters.Army;
import org.mahdenko.battle.characters.Warrior;

public class Battle {
    public static boolean fight(Warrior attacker, Warrior defender){
        while (true){
            if (!attacker.isAlive()) return false;
            attacker.hit(defender);
            if (!defender.isAlive()) return true;
            defender.hit(attacker);
        }
    }

    public static boolean fight(Army attackers, Army defenders){
        while (true){
            if (!attackers.hasWarriors()) return false;
            if (!defenders.hasWarriors()) return true;
            if (fight(attackers.peekFirst(), defenders.peekFirst())) defenders.removeFirst();
            else attackers.removeFirst();
        }
    }
}
