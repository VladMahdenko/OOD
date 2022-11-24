package org.mahdenko.battle.characters.lancer;

import org.mahdenko.battle.characters.warrior.CanReceiveDamage;
import org.mahdenko.battle.characters.warrior.Warrior;
import org.mahdenko.battle.characters.warrior.WarriorDecorator;

public class Lancer extends WarriorDecorator implements isLancer{

    private int piercing;

    public Lancer(Warrior warrior, int piercing){
        super(warrior);
        this.piercing = piercing;
    }

    @Override
    public int getPiercing() {
        return piercing;
    }

    public void hit(CanReceiveDamage receiver1, CanReceiveDamage receiver2) {
        int healthBefore = receiver1.getHealth();
        super.hit(receiver1);
        if (receiver2 != null){
            int healthAfter = receiver1.getHealth();
            int dealtDamage = healthBefore - healthAfter;
            receiver2.receiveDamage(Math.max(0, getPiercingDamage(dealtDamage)));
        }
    }

    private int getPiercingDamage(int dealtDamage){
        return dealtDamage*getPiercing()/100;
    }
}
