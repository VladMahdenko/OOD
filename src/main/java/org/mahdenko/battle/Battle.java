package org.mahdenko.battle;

import org.mahdenko.battle.characters.Army;
import org.mahdenko.battle.characters.Lancer;
import org.mahdenko.battle.characters.Warrior;

import java.util.Iterator;

public class Battle {

    //1vs1
    public static boolean fight(Warrior attacker, Warrior defender){
        while (true){
            if (!attacker.isAlive()) return false;
            attacker.hit(defender);
            if (!defender.isAlive()) return true;
            defender.hit(attacker);
        }
    }

    //2vs2
    public static boolean fight(Warrior attacker1,
                                Warrior attacker2,
                                Warrior defender1,
                                Warrior defender2){
        while (true){
            if (!attacker1.isAlive()) return false;
            if (attacker1 instanceof Lancer) ((Lancer) attacker1).hit(defender1, defender2);
            else attacker1.hit(defender1);
            if (!defender1.isAlive()) return true;
            if (defender1 instanceof Lancer) ((Lancer) defender1).hit(attacker1, attacker2);
            else defender1.hit(attacker1);
        }
    }

    //army vs army
    public static boolean fight(Army attackers, Army defenders){
        Iterator<Warrior> itAttackers = attackers.firstAlive();
        Iterator<Warrior> itDefenders = defenders.firstAlive();

        Iterator<Warrior> itAttackersSecond = attackers.secondAlive();
        Iterator<Warrior> itDefendersSecond = defenders.secondAlive();

        while (itAttackers.hasNext() && itDefenders.hasNext()){
            if (itAttackers.next() instanceof Lancer)
                fight(itAttackers.next(), itAttackersSecond.next(),
                    itDefenders.next(), itDefendersSecond.next());
            else fight(itAttackers.next(), itDefenders.next());
        }
        return itAttackers.hasNext();
    }
}
