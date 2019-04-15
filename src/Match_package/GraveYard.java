package Match_package;

import java.util.ArrayList;

class GraveYard {
    // ought to change word Object with word Card
    private ArrayList<Object> deadCards = new ArrayList<>();

    public void addToDeadCards(Object object){
        deadCards.add(object);
    }

    public ArrayList<Object> getDeadCards(){
        return deadCards;
    }
}

