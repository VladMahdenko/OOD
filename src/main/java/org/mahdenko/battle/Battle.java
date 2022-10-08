package org.mahdenko.battle;

import org.mahdenko.battle.characters.Army;
import org.mahdenko.battle.characters.Warrior;

import java.util.Iterator;

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
        Iterator<Warrior> itAttackers = attackers.firstAlive();
        Iterator<Warrior> itDefenders = defenders.firstAlive();
        while (itAttackers.hasNext() && itDefenders.hasNext()){
            fight(itAttackers.next(), itDefenders.next());
        }
        return itAttackers.hasNext();
    }
}
