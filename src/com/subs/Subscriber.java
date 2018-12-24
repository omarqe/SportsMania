package com.subs;

import com.infc.Observer;
import com.infc.SmsInterface;
import com.infc.Subject;

public class Subscriber implements Observer, SmsInterface {
    public String name;
    public String city;
    public String commentary;
    public Subject liveCommentary;

    public Subscriber(Subject liveCommentary) {
        this.liveCommentary = liveCommentary;
        liveCommentary.registerObserver(this);
    }

    public Subscriber(Subject liveCommentary, String name, String city) {
        this.name = name;
        this.city = city;
        this.liveCommentary = liveCommentary;

        System.out.printf("Subscribing %s [%s] to Soccer Match [30th Oct 2018] ...\n", name, city);
        liveCommentary.registerObserver(this);
    }

    public void unsubscribe() {
        System.out.printf("Unsubscribing %s [%s] to Soccer Match [30th Oct 2018]...\n", name, city);
        liveCommentary.removeObserver(this);
    }

    @Override
    public void update(String c) {
        commentary = c;
        send();
    }

    @Override
    public void send() {
        System.out.printf("[%s [%s]]: %s\n", name, city, commentary);
    }
}
