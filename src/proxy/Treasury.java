package proxy;

import multiton.Valuable;
import utility.collection.ArrayList;

public interface Treasury  {
    void add(String actor, ArrayList<Valuable> valuables);
    Valuable retrieve(String actor);
    int look(String actor);
}
