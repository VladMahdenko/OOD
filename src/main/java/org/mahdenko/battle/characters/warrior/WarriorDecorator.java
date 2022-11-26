package org.mahdenko.battle.characters.warrior;

import org.mahdenko.battle.characters.healer.WithHealing;

public abstract class WarriorDecorator implements Warrior{
    private Warrior warrior;

    public WarriorDecorator(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public int getAttack() {
        return warrior.getAttack();
    }

    @Override
    public void receiveDamage(int damage) {
        warrior.receiveDamage(damage);
    }

    @Override
    public int getHealth() {
        return warrior.getHealth();
    }

    @Override
    public int getMaxHealth() {
        return warrior.getMaxHealth();
    }

    @Override
    public void hit(CanReceiveDamage receiver) {
        Warrior.super.hit(receiver);
    }

    public WarriorImpl getKernel(){
        if (warrior instanceof WarriorDecorator decorator) return decorator.getKernel();
        else return (WarriorImpl) warrior;
    }

    @Override
    public String toString() {
        return warrior.toString();
    }

    public WithHealing getHealer(){
        if (this instanceof WithHealing healer) return healer;
        if (warrior instanceof WarriorDecorator decorator) return decorator.getHealer();
        return null;
    }
}
