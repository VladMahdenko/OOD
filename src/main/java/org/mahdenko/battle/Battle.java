package org.mahdenko.battle;

import org.mahdenko.battle.characters.Warrior;

public class Battle {
    public static boolean fight(Warrior warrior1, Warrior warrior2){
        while (true){
            if (!warrior1.isAlive()) return false;
            warrior1.hit(warrior2);
            if (!warrior2.isAlive()) return true;
            warrior2.hit(warrior1);
        }
    }
}
