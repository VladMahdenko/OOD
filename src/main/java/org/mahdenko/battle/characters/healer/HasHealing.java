package org.mahdenko.battle.characters.healer;

import org.mahdenko.battle.characters.warrior.Warrior;
import org.mahdenko.battle.characters.warrior.WarriorImpl;

public interface HasHealing {
    int getHealing();

    public void heal(WarriorImpl ally);
}
