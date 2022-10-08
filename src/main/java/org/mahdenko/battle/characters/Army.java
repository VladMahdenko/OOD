package org.mahdenko.battle.characters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Supplier;

public class Army {
    private Queue<Warrior> warriors;

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

    public Army(){
        warriors = new LinkedList<Warrior>();
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
        return warriors.peek();
    }

    private Warrior removeFirst(){
        return warriors.poll();
    }
}
