package org.mahdenko.battle.characters;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    private ArrayList<Warrior> warriors;

    public Iterator<Warrior> firstAlive(){
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Warrior>{
        @Override
        public boolean hasNext() {
            while(peekFirst()!=null && !peekFirst().isAlive()) removeFirst();
            return peekFirst()!=null;
        }

        @Override
        public Warrior next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return peekFirst();
        }
    }

    public Iterator<Warrior> secondAlive(){return new SecondAliveIterator();}

    private class SecondAliveIterator implements Iterator<Warrior>{
        @Override
        public boolean hasNext() {
            return warriors.size()>=2;
        }

        @Override
        public Warrior next() {
            if (!hasNext()) return null;
            return warriors.get(1);
        }
    }

    public Army(){
        warriors = new ArrayList<Warrior>();
    }

    public Army addUnits(Supplier<Warrior> factory){
        warriors.add(factory.get());
        return this;
    }

    public Army addUnits(Supplier<Warrior> factory, int number){
        for (int i=0; i<number; i++) this.addUnits(factory);
        return this;
    }

    private Warrior peekFirst(){
        if (warriors.size()==0) return null;
        return warriors.get(0);
    }

    private Warrior removeFirst(){
        return warriors.remove(0);
    }
}
