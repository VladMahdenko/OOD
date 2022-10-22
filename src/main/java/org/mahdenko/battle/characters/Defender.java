package org.mahdenko.battle.characters;

public class Defender extends Warrior{
    private static final int ATTACK = 3;
    private static final int DEFENCE = 2;

    public Defender() {
        super(60);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    private int getDefence(){
        return DEFENCE;
    }

    @Override
    protected void takeDamage(int damage) {
        super.takeDamage(Math.max(0, damage-getDefence()));
    }
}
