import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 * Date: 12/12/11
 * Time: 8:32 PM
 * To change this template use File | Settings | File Templates.
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
        //List cardList = this.subList(0, this.elementCount - 1);
        //System.out.println(cardList);
        System.out.println(this);
        Collections.shuffle(this);
        System.out.println(this);
        //this.clear();

        //for(Object card : cardList){
        //   System.out.println(card);
         //  this.addElement(card);
       //}
    }




}
