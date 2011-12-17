import java.util.Collections;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 * 
 * 
 * Deck class that uses stacks to organize cards
 * Shuffles and removes cards from deck.
 */
public class Deck<E> extends Stack {

    public E peekLast(){
       return (E) this.lastElement();
    }
    public E popLast(){
        E lastElement = (E)this.lastElement();
        this.remove(this.elementCount-1);
        return lastElement;
    }
    public void shuffle(){
        System.out.println(this);
        Collections.shuffle(this);
        System.out.println(this);
    }




}
