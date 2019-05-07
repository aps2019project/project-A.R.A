package Model.Match_package;

import Exceptions.NotEnoughManaException;
import Exceptions.UnitNotFoundException;
import Menus.MenuManager;
import Model.Card_package.Card;
import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Card_package.hero_special_power.HeroSpecialPowerActivationTime;
import Model.Item_package.Collectable;
import Model.Item_package.UsableActivationTime;
import Model.Item_package.item_effect.ItemEffect;
import Model.Item_package.item_effect.ItemEffectType;
import Model.Match_package.Battle_Type.SelectedCardPosition;
import View.ShowType;

import java.util.ArrayList;
import java.util.HashSet;

public class Player {
    public String name;
    private Hand hand;
    protected Deck deck;
    private GraveYard graveYard;
    private ArrayList<Collectable> collectables = new ArrayList<>();
    private Collectable selectedCollectable;
    private Card selectedCard;
    private SelectedCardPosition selectedCardPosition;
    private int mana;
    ArrayList<ItemEffect> itemEffects = new ArrayList<>();


    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck.getCopy(this);
        graveYard = new GraveYard();
        hand = new Hand(deck.getAllDeckCards());
        handleOnStartAttributes();
        setMana();
    }

    void setMana(){
        int turn = MenuManager.getCurrentMatch().getTurn();
        this.mana = Math.min(turn / 2 + 2, 9);
        for (ItemEffect itemEffect : itemEffects) {
            if (itemEffect.getItemEffectType() == ItemEffectType.INCREASE_MANA)
                mana += itemEffect.getUnit();
        }
    }

    public void handleOnStartAttributes() {
        if (this.deck.getUsable().getActivationTime() == UsableActivationTime.GAME_START) {
            deck.getUsable().doUsable(new HashSet<>());
        }
        for (HeroSpecialPower specialPower : deck.getHero().getSpecialPowers()) {
            if(specialPower.getActivationTime() == HeroSpecialPowerActivationTime.PASSIVE_ON_START)
                specialPower.doHeroSpecialPower(new HashSet<>(), new HashSet<>());
        }
    }

    public void putCard(Card card, Coordination c) {
//        // x & y : 0 , 1, 2, ...
//
//        if (!hand.hasCard(card)) {
//            // show Error Card notFound
//        } else {
//            hand.setCardAsOnGround(card, deck.pullLastCard());
//            if (!Match.getInstance().getMap().cells[c.getX()][c.getY()].hasCard())
//                Match.getInstance().getMap().cells[c.getX()][c.getY()].setCard(card);
//            else {
//                // show error : cell is full
//            }
//        }

        // badan dorost shavad
    }

    public void addItemEffectsByCopy(ArrayList<ItemEffect> itemEffects) {
        for (ItemEffect itemEffect : itemEffects)
            this.itemEffects.add(itemEffect.getCopy());
    }

    public void moveCard(Coordination coordination) {
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
    }

    public void useCollectable() {
        selectedCollectable.doCollectable();
        collectables.remove(selectedCollectable);
        selectedCollectable = null;
    }

    public Hand getHand() {
        return hand;
    }

    public void setSelectedCollectable(Collectable selectedCollectable) {
        this.selectedCollectable = selectedCollectable;
    }

    public void setSelectedCard(Card selectedCard, SelectedCardPosition selectedCardPosition) {
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

    public void addCollectable(Collectable collectable) {
        collectables.add(collectable);
    }/* todo also need to get overrided to
    todo perform by taking collectable ID.*/

    public ArrayList<Collectable> getCollectables() {
        return collectables;
    }

    public String toString(ShowType showType) {
        switch (showType) {
            case COLLECTABLES:
                return collectableToString();
            case CARDS:
                return cardsToString();
            default:
                return null;
        }
    }

    private String collectableToString() {
        StringBuilder stringBuilder = new StringBuilder("Collectables : \n");
        for (Collectable collectable : collectables)
            stringBuilder.append("- " + collectable.toString() + "\n");
        return stringBuilder.toString();
    }

    private String cardsToString() {
        return "to be handled";
    }

    public Collectable getCollectable(String id) throws UnitNotFoundException{
        for(Collectable collectable:collectables)
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
