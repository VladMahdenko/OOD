package org.mahdenko.battle.characters.warrior;

public class WarriorImpl implements Warrior{

    private int health;
    private final int maxHealth;
    private int attack;

    public WarriorImpl(int health, int attack) {
        this.health = health;
        this.attack = attack;
        this.maxHealth = health;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public void receiveDamage(int damage) {
        setHealth(Math.max(0, getHealth()-damage));
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public int getMaxHealth() {
        return this.maxHealth;
    }

    @Override
    public String toString() {
        return "WarImpl health: %d, attack: %d".formatted(getHealth(), getAttack());
    }
}
