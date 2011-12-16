package Cards;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
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
    
    public int length(){
        int i =0;
        for (Object obj : this){
            i++;
        }
        return i;
    }
    
    public void sort(){
        Object[] tempArray = new Object[this.length()];
        int i =0;
        for (Object obj: this){
            tempArray[i] = obj;
            i++;
        }
        boolean notFinished = true;
        Object tempObj;
        while(notFinished){
            notFinished = false;
            for (i = 0; i <tempArray.length-1 ;i++ ){
                if (tempArray[i].toString().compareToIgnoreCase(tempArray[i+1].toString())>0){
                    tempObj = tempArray[i];
                    tempArray[i] = tempArray[i+1];
                    tempArray[i+1] = tempObj;
                    notFinished = true;
                }
            }
        }
        this.clear();
        for (Object obj : tempArray){
            this.add((E)obj);
        }
    }


}
