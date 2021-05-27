package cardGame;

import cardGameExceptions.StackOverflowException;
import cardGameExceptions.StackUnderflowException;

import java.util.Random;

public class DeckOfCards {
    private final Card[] cards;
    private int lastPushedCardIndex = -1;

    public DeckOfCards(int sizeOfDeck) {
        cards = new Card[sizeOfDeck];
    }

    public int getSize() {
        return cards.length;
    }

    public void push(Card card) {
        if(isFull()) throw new StackOverflowException("Card deck is full");
        cards[++lastPushedCardIndex] = card;
    }

    public int getNumberOfCardsInDeck() {
        return lastPushedCardIndex + 1;
    }

    public Card peek() {
        if(isEmpty()) throw new StackUnderflowException("Card deck is empty");
        return cards[lastPushedCardIndex];
    }

    public Card pop() {
        if(isEmpty()) throw new StackUnderflowException("Card deck is empty");
        return cards[lastPushedCardIndex--];
    }

    public boolean isEmpty() {
        return lastPushedCardIndex == -1;
    }

    public boolean isFull() {
        return lastPushedCardIndex == getSize() - 1;
    }

    public void shuffle() {
        int secondCardIndex = getSize() - 1;
        int counter = 0;
        Random randomizer = new Random();

        while (secondCardIndex > counter) {
            int firstCardIndex = randomizer.nextInt(getSize());
            Card tempCard = cards[firstCardIndex];
            cards[firstCardIndex] = cards[secondCardIndex];
            cards[secondCardIndex] = tempCard;
            secondCardIndex--;
            counter++;
        }
    }

}
