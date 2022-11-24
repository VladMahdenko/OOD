package org.mahdenko.battle.characters.defender;

import org.mahdenko.battle.characters.warrior.Warrior;
import org.mahdenko.battle.characters.warrior.WarriorDecorator;

public class WithDefence extends WarriorDecorator implements HasDefence{
    private int defence;

    public WithDefence(Warrior warrior, int defence){
        super(warrior);
        this.defence = defence;
    }

    @Override
    public int getDefence() {
        return this.defence;
    }

    @Override
    public String toString() {
        return "Defender health: %d, attack: %d, defence %d".formatted(getHealth(), getAttack(), getDefence());
    }

    @Override
    public void receiveDamage(int damage) {
        super.receiveDamage(Math.max(0, damage-getDefence()));
    }
}
