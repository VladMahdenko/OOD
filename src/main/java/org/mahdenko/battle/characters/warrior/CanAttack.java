package org.mahdenko.battle.characters.warrior;

public interface CanAttack {
    int getAttack();

    default void hit(CanReceiveDamage receiver){
        receiver.receiveDamage(getAttack());
    }
}
