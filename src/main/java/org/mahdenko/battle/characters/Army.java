package org.mahdenko.battle.characters;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

public class Army {
    private Queue<Warrior> warriors;

    public Army(){
        warriors = new LinkedList<Warrior>();
    }

    public void addUnits(Supplier<Warrior> factory){
        warriors.add(factory.get());
    }

    public void addUnits(Supplier<Warrior> factory, int number){
        for (int i=0; i<number; i++) addUnits(factory);
    }

    public Warrior peekFirst(){
        return warriors.peek();
    }

    public Warrior removeFirst(){
        return warriors.poll();
    }


    public boolean hasWarriors(){
        return peekFirst()!=null;
    }
}
