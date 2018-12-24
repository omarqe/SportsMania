package com;

import com.infc.Observer;
import com.infc.Subject;

import java.util.ArrayList;

public class LiveCommentary implements Subject {
    public ArrayList<Observer> observers;
    public String commentary;

    @Override
    public void registerObserver(Observer o) {
        if ( observers.add(o) )
            System.out.println("Subscribed successfully.\n");
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if ( i >= 0 ) {
            observers.remove(i);
            System.out.println("Unsubscribed successfully.\n");
        }
    }

    @Override
    public void notifyObservers() {
        for ( Observer o : observers )
            o.update(commentary);
    }

    public LiveCommentary() {
        observers = new ArrayList<>();
    }

    public void commentaryUpdated() {
        notifyObservers();
    }

    public void setCommentary(String c) {
        this.commentary = c;

        commentaryUpdated();
        System.out.println();
    }

}
