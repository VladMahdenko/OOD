package org.mahdenko.battle.characters;

public class Warrior {
    private static final int ATTACK = 5;
    private int health;

    public Warrior() {
        this(50);
    }

    protected Warrior(int health){
        this.health = health;
    }

    public boolean isAlive(){
        return getHealth()>0;
    }

    public int getAttack(){
        return ATTACK;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0) this.health=0;
        else this.health = health;
    }

    public void hit(Warrior opponent){
        opponent.takeDamage(this.getAttack());
    }

    protected void takeDamage(int damage){
        setHealth(getHealth()-damage);
    }

    @Override
    public String toString() {
        return "%s: health: %d attack: %d".formatted(getClass().getSimpleName(), getHealth(), getAttack()) ;
    }
}
