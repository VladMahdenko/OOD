package org.mahdenko.battle.characters;

public class Vampire extends Warrior{
    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism(){
        return VAMPIRISM;
    }

    @Override
    public void hit(Warrior opponent) {
        int healthBefore = opponent.getHealth();
        super.hit(opponent);
        int healthAfter = opponent.getHealth();
        setHealth(Math.min(40, getHealth()+getHealing(healthBefore-healthAfter)));
    }

    private int getHealing(int dealtDamage){
        return dealtDamage * getVampirism() / 100;
    }
}
