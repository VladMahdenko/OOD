package org.mahdenko.battle.characters.warrior;

public interface HasHealth {
    int getHealth();

    default boolean isAlive(){
        return getHealth()>0;
    }

    int getMaxHealth();
}
