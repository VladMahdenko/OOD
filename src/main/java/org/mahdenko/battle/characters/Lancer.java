package org.mahdenko.battle.characters;

public class Lancer extends Warrior{
    private static final int ATTACK = 6;

    public Lancer() {
        super(50);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public void hit(Warrior opponent1, Warrior opponent2){
        int healthBefore = opponent1.getHealth();
        super.hit(opponent1);
        int healthAfter = opponent1.getHealth();
        if (opponent2 != null) opponent2.takeDamage(Math.max((healthBefore-healthAfter)*50/100, 0));
    }
}
