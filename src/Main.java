import com.LiveCommentary;
import com.subs.Subscriber;

public class Main {
    public static void main(String[] args) {
        LiveCommentary comm = new LiveCommentary();

        // Subscribing two people to the SportsMania app
        Subscriber adamWarner = new Subscriber(comm, "Adam Warner", "New York");
        Subscriber timRooney  = new Subscriber(comm, "Tim Rooney", "London");

        // This commentary is received by Adam Warner & Tim Rooney
        comm.setCommentary("Welcome to live Soccer match");

        // Unsubscribe Tim Rooney from SportsMania
        timRooney.unsubscribe();

        // These updates are received by Adam Warner only
        comm.setCommentary("It's a goal!!");
        comm.setCommentary("Current score 1-0");

        // Subscribe Marie to SportsMania
        Subscriber marie = new Subscriber(comm, "Marie", "Paris");

        // These updates are received by Adam Warner & Marie only
        comm.setCommentary("It's another goal!!");
        comm.setCommentary("Half-time score 2-0");
    }
}
