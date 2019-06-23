package Model.Match_package;

import Exceptions.NotEnoughManaException;
import Exceptions.UnitNotFoundException;
import Menus.MenuManager;
import Model.Card_package.Card;
import Model.Card_package.collectable.CollectAble;
import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Card_package.hero_special_power.HeroSpecialPowerActivationTime;
import Model.Card_package.usable.UsableActivationTime;
import Model.Card_package.item_effect.ItemEffect;
import Model.Card_package.item_effect.ItemEffectType;
import Model.Match_package.Battle_Type.SelectedCardPosition;
import Menus.ShowType;

import java.util.ArrayList;

public class Player {
    public String name;
    private Hand hand;
    protected Deck deck;
    private GraveYard graveYard;
    private ArrayList<CollectAble> collectAbles = new ArrayList<>();
    private CollectAble selectedCollectAble;
    private Card selectedCard;
    private SelectedCardPosition selectedCardPosition;
    private int mana;
    private ArrayList<ItemEffect> itemEffects = new ArrayList<>();


    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck.getCopy(this);
        graveYard = new GraveYard();
        hand = new Hand(deck.getAllDeckCards());
        handleOnStartAttributes();
        setMana();
    }

    void setMana(){//todo check
        int turn = MenuManager.getCurrentMatch().getTurn();
        this.mana = Math.min(turn / 2 + 2, 9);
        for (ItemEffect itemEffect : itemEffects) {
            if (itemEffect.getItemEffectType() == ItemEffectType.INCREASE_MANA)
                mana += itemEffect.getUnit();
        }
    }

    private void handleOnStartAttributes() {

        if (deck.getUsable()!= null && this.deck.getUsable().getActivationTime() == UsableActivationTime.GAME_START) {
            deck.getUsable().doOnStartUsable();
        }
        HeroSpecialPower specialPower = deck.getHero().getSpecialPower();
        if(specialPower.getActivationTime() == HeroSpecialPowerActivationTime.PASSIVE_ON_START)
            specialPower.doOnStartHeroSpecialPower(this);
    }



    public void addItemEffectsByCopy(ArrayList<ItemEffect> itemEffects) {
        for (ItemEffect itemEffect : itemEffects)
            this.itemEffects.add(itemEffect.getCopy());
            //todo handle when add
    }

//    public void moveCard(Coordination coordination) {    // move handled in match
        // assumed as 0, 1, 2, ...
        //considered that there is a selected card
        // move limitation (default as 2) not considered

//        Cell cell = Match.getInstance().getMap().findPosition(Match.getInstance().selectedCard);
//        if(cell != null){
////            if(Match.getInstance().checkPath())            -- >  // todo checking the path and set a correct way to present cells
//            cell.deleteCard();
//            Cell newPosition = Match.getInstance().getMap().getCell(coordination); // x and y be in range not considered
//            newPosition.setCard(Match.getInstance().selectedCard);
//        }
//        else{
//            // show error card not in the battle field , although it is not possible
//        }
        //todo
//    }

    public void useCollectAble() {
        selectedCollectAble.doOnUseCollectAble();
        collectAbles.remove(selectedCollectAble);
        selectedCollectAble = null;
    }

    Card getSelectedCard() {
        return selectedCard;
    }

    public Hand getHand() {
        return hand;
    }

    void setSelectedCollectAble(CollectAble selectedCollectAble) {
        this.selectedCollectAble = selectedCollectAble;
    }

    void setSelectedCard(Card selectedCard, SelectedCardPosition selectedCardPosition) {
        this.selectedCard = selectedCard;
        this.selectedCardPosition = selectedCardPosition;
    }

    public GraveYard getGraveYard() {
        return graveYard;
    }

    public boolean hasEnoughManaFor(Card card) {
        if (mana >= card.getMana())
            return true;
        return false;
    }

    public void addCollectable(CollectAble collectable) {
        collectAbles.add(collectable);
    }/* todo also need to get overrided to
    todo perform by taking collectable ID.*/

    public ArrayList<CollectAble> getCollectAbles() {
        return collectAbles;
    }

    public String toString(ShowType showType) {
        switch (showType) {
            case COLLECTABLES:
                return collectAbleToString();
            case CARDS:
                return cardsToString();
            default:
                return null;
        }
    }

    private String collectAbleToString() {
        StringBuilder stringBuilder = new StringBuilder("Collectables : \n");
        for (CollectAble collectable : collectAbles)
            stringBuilder.append("- " + collectable.toString() + "\n");
        return stringBuilder.toString();
    }

    private String cardsToString() {
        return "to be handled";
    }

    public CollectAble getCollectable(String id) throws UnitNotFoundException{
        for(CollectAble collectable: collectAbles)
            if(collectable.getID().equals(id))
                return collectable;
            throw new UnitNotFoundException();
    }

    public int getMana() {
        return mana;
    }

    public void reduceMana(int amount){
        if(amount>mana)
            throw new NotEnoughManaException();
        mana-=amount;
    }

    public String getName() {
        return name;
    }

    public Deck getDeck() {
        return deck;
    }



}
