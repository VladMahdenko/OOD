package org.mahdenko.battle.characters;

public class Defender extends Warrior{
    private static final int ATTACK = 3;
    private static final int DEFENCE = 2;
    private int health=60;

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private int getDefence(){
        return DEFENCE;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    protected void takeDamage(int damage) {
        if (damage<getDefence()) return;
        setHealth(getHealth()-damage+getDefence());
    }
}
