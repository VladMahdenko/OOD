package org.mahdenko.battle.characters;

import org.mahdenko.battle.characters.warrior.HasNext;
import org.mahdenko.battle.characters.warrior.Warrior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Supplier;

public class Army {
    private ArrayList<HasNext> warriors;

    public Army(){
        warriors = new ArrayList<HasNext>();
    }

    public Warrior peekFirst(){
        if (!warriors.isEmpty()) return warriors.get(0);
        else return null;
    }

    public Warrior removeFirst(){
        return warriors.remove(0);
    }

    public Warrior getLast(){
        if (!warriors.isEmpty()) return warriors.get(warriors.size()-1);
        else return null;
    }

    public Army addUnits(Supplier<Warrior> factory){
        Warrior warrior = factory.get();
        if (!warriors.isEmpty()) ((HasNext)  getLast()).setNext(warrior);
        warriors.add(new HasNext(warrior, null));
        return this;
    }

    public Army addUnits(Supplier<Warrior> factory, int number){
        for (int i=0; i<number; i++) this.addUnits(factory);
        return this;
    }

    @Override
    public String toString() {
        String res = "";
        for (Warrior warrior: warriors){
            res+= warrior.toString() +"\n";
        }
        return res;
    }

    public Iterator<Warrior> firstAlive(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Warrior>{
        @Override
        public boolean hasNext() {
            while(peekFirst()!=null && !peekFirst().isAlive()) removeFirst();
            return peekFirst()!=null;
        }

        @Override
        public Warrior next() {
            if (!hasNext()){
                return null;
            }
            return peekFirst();
        }
    }

    public Army organiseForStraightFight(){
        for (HasNext w : warriors){
            w.setNext(null);
        }
        return this;
    }

    public Army organiseForQueueFight(){
        for (int i=0; i< warriors.size()-1; i++){
            warriors.get(i).setNext(warriors.get(i+1));
        }
        return this;
    }

    public ArrayList<HasNext> getWarriors() {
        return warriors;
    }

    public HasNext getWarrior(int index){
        return getWarriors().get(index);
    }

    public void removeDead(){
        for (int i = 0;; i++){
            while (!warriors.isEmpty() && !warriors.get(i).isAlive()){
                warriors.remove(i);
            }
            if (i < warriors.size()) break;
        }
    }
}
