package org.mahdenko.battle.characters.vampire;

import org.mahdenko.battle.characters.warrior.CanReceiveDamage;
import org.mahdenko.battle.characters.warrior.Warrior;
import org.mahdenko.battle.characters.warrior.WarriorDecorator;

public class WithVampirism extends WarriorDecorator implements HasVampirism {
    private int vampirism;

    public WithVampirism(Warrior warrior, int vampirism){
        super(warrior);
        this.vampirism = vampirism;
    }

    @Override
    public int getVampirism() {
        return vampirism;
    }

    @Override
    public void hit(CanReceiveDamage receiver) {
        int healthBefore = receiver.getHealth();
        super.hit(receiver);
        int healthAfter = receiver.getHealth();
        int dealtDamage = Math.max(0, healthBefore-healthAfter);
        getKernel().setHealth(getHealth()+getVampirismHealing(dealtDamage));
    }

    private int getVampirismHealing(int dealtDamage){
        return dealtDamage*getVampirism()/100;
    }

    @Override
    public String toString() {
        return "Vampire health: %d, attack: %d, vampirism %d".formatted(getHealth(), getAttack(), getVampirism());
    }
}
