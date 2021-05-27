package cardGame;

import cardGameExceptions.InvalidCardException;
import cardGameExceptions.StackUnderflowException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private List<Card> cards = new ArrayList();

    public Player(String name) {
        this.name = name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public String getName() {
        return name;
    }

    public void playCard(int cardPosition, DeckOfCards deck) {
        if(hasNoCard())throw new StackUnderflowException("Player has no cards");

        Faces playerCardFace = cards.get(cardPosition - 1).getFace();
        Faces deckCardFace = deck.peek().getFace();
        Suits playerCardSuit = cards.get(cardPosition - 1).getSuit();
        Suits deckCardSuit = deck.peek().getSuit();

        validateCard(playerCardFace, deckCardFace, playerCardSuit, deckCardSuit);

        Card playedCard = cards.get(cardPosition - 1);
        deck.push(playedCard);
        cards.remove(cardPosition - 1);
    }

    private void validateCard(Faces playerCardFace, Faces deckCardFace, Suits playerCardSuit, Suits deckCardSuit) {
        if(!(playerCardFace.equals(deckCardFace) || playerCardSuit.equals(deckCardSuit)))
            throw new InvalidCardException("Card face or suit does not match the deck card");
    }

    public boolean hasNoCard() {
        return cards.size() == 0;
    }
}
