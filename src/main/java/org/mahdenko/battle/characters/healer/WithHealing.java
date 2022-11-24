package org.mahdenko.battle.characters.healer;

import org.mahdenko.battle.characters.warrior.Warrior;
import org.mahdenko.battle.characters.warrior.WarriorDecorator;
import org.mahdenko.battle.characters.warrior.WarriorImpl;

public class WithHealing extends WarriorDecorator implements HasHealing {
    private int healing;

    public WithHealing(Warrior warrior, int healing){
        super(warrior);
        this.healing = healing;
    }

    @Override
    public int getHealing() {
        return healing;
    }

    @Override
    public void heal(WarriorImpl ally) {
        ally.setHealth(Math.min(ally.getMaxHealth(), ally.getHealth() + getHealing()));
    }
}
