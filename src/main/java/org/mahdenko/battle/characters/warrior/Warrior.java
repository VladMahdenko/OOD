package org.mahdenko.battle.characters.warrior;

import org.mahdenko.battle.characters.defender.WithDefence;
import org.mahdenko.battle.characters.healer.WithHealing;
import org.mahdenko.battle.characters.lancer.Lancer;
import org.mahdenko.battle.characters.vampire.WithVampirism;

public interface Warrior extends HasHealth, CanAttack, CanReceiveDamage{
    static Warrior newWarrior(){
        return new WarriorImpl(50, 5);
    }

    static Warrior newKnight(){
        return new WarriorImpl(50, 7);
    }

    static Warrior newRookie() {
        return new WarriorImpl(50, 1);
    }

    static Warrior newDefender(){
        return new WithDefence(new WarriorImpl(60, 3), 2);
    }

    static Warrior newVampire(){
        return new WithVampirism(new WarriorImpl(40, 4), 50);
    }

    static Warrior newLancer(){
        return new Lancer(new WarriorImpl(50, 6), 50);
    }

    static Warrior newHealer(){
        return new WithHealing(new WarriorImpl(60, 0), 2);
    }
}
