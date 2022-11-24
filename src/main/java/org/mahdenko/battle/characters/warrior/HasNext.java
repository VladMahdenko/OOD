package org.mahdenko.battle.characters.warrior;

import org.mahdenko.battle.characters.healer.WithHealing;

public class HasNext extends WarriorDecorator{

    private Warrior next;

    public HasNext(Warrior warrior, Warrior next){
        super(warrior);
        this.next = next;
    }

    public Warrior getNext() {
        return next;
    }

    public void setNext(Warrior next) {
        this.next = next;
    }

    public boolean hasNext(){
        return next!=null;
    }

    @Override
    public void hit(CanReceiveDamage receiver) {
        super.hit(receiver);
        heal();
    }

    private void heal(){
        if (hasNext()){
            if (next instanceof WithHealing healer) healer.heal(this.getKernel());
            if (next instanceof HasNext) ((HasNext) next).heal();
        }
    }
}
