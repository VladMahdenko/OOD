package org.mahdenko.battle;

import org.mahdenko.battle.characters.Army;
import org.mahdenko.battle.characters.lancer.Lancer;
import org.mahdenko.battle.characters.warrior.HasNext;
import org.mahdenko.battle.characters.warrior.Warrior;
import java.util.Iterator;

public class Battle {

    //1vs1
    public static boolean fight(Warrior attacker, Warrior defender){
        while (attacker.isAlive() && defender.isAlive()){

            if (attacker instanceof Lancer && defender instanceof HasNext) ((Lancer) attacker).hit(defender,
                    ((HasNext) defender).getNext());
            else attacker.hit(defender);

            //System.out.println("attacker: %d, defender %d".formatted(attacker.getHealth(), defender.getHealth()));

            if (defender.isAlive()){
                if (defender instanceof Lancer && attacker instanceof HasNext) ((Lancer) defender).hit(attacker,
                        ((HasNext) attacker).getNext());
                else defender.hit(attacker);
            }

            //System.out.println("attacker: %d, defender %d".formatted(attacker.getHealth(), defender.getHealth()));
        }
        return attacker.isAlive();
    }

    //army vs army
    public static boolean fight(Army attackers, Army defenders){
        attackers.organiseForQueueFight();
        defenders.organiseForQueueFight();

        Iterator<Warrior> itAttackers = attackers.firstAlive();
        Iterator<Warrior> itDefenders = defenders.firstAlive();

        while (itAttackers.hasNext() && itDefenders.hasNext()){
           fight(itAttackers.next(), itDefenders.next());
        }

        return itAttackers.hasNext();
    }

    public static boolean straightFight(Army attackers, Army defenders){
        attackers.organiseForStraightFight();
        defenders.organiseForStraightFight();

        while(!attackers.getWarriors().isEmpty() && !defenders.getWarriors().isEmpty()) {
            for (int i = 0; i < attackers.getWarriors().size(); i++) {
                if (i < defenders.getWarriors().size()) {
                    fight(attackers.getWarrior(i), defenders.getWarrior(i));
                }
            }
            attackers.removeDead();
            defenders.removeDead();
        }

        return attackers.firstAlive().hasNext();
    }
}
