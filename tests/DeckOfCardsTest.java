import cardGame.*;
import cardGameExceptions.StackOverflowException;
import cardGameExceptions.StackUnderflowException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cardGame.Faces.*;
import static cardGame.Suits.*;
import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {
    DeckOfCards deck;
    Card card;
    @BeforeEach
    void setUp(){
        deck = new DeckOfCards(5);
        card = new Card(ACE, DIAMOND);
    }

    @AfterEach
    void tearDown(){
        deck = null;
        card = null;
    }

    @Test
    void testThatDeckHasAFixedSize(){
        assertEquals(5, deck.getSize());
    }
    @Test
    void testThatCardCanBePushedIntoDeck(){
        deck.push(card);
        assertEquals(1, deck.getNumberOfCardsInDeck());
    }

    @Test
    void testThatLastPushedCardCanBePeeked(){
        deck.push(card);
        assertEquals(1, deck.getNumberOfCardsInDeck());
        assertSame(card, deck.peek());
    }
    @Test
    void testThatLastPushedCardCanBePopped(){
        deck.push(card);
        assertEquals(1, deck.getNumberOfCardsInDeck());
        assertSame(card, deck.pop());
        assertEquals(0, deck.getNumberOfCardsInDeck());
    }
    @Test
    void testThatPushTwoCardsPopOneCardPeeksTheFirstCardPushed(){
        Card secondCard = new Card(TWO, SPADE);

        deck.push(card);
        deck.push(secondCard);
        assertEquals(2, deck.getNumberOfCardsInDeck());

        assertSame(secondCard, deck.pop());
        assertSame(card, deck.peek());
        assertEquals(1, deck.getNumberOfCardsInDeck());
    }
    @Test
    void testThatPeekingAnEmptyStackOfCardsThrowsStackUnderflowException(){
        assertTrue(deck.isEmpty());
        assertThrows(StackUnderflowException.class, ()-> deck.peek());
    }
    @Test
    void testThatPoppingAnEmptyStackOfCardsThrowsStackUnderflowException(){
        assertTrue(deck.isEmpty());
        assertThrows(StackUnderflowException.class, ()-> deck.pop());
    }
    @Test
    void testThatPushingIntoFullStackOfCardsThrowsStackOverflowException(){
        for (int i = 0; i < deck.getSize(); i++) {
            deck.push(card);
        }
        assertTrue(deck.isFull());
        assertThrows(StackOverflowException.class, ()-> deck.push(card));
    }

    @Test
    void testThatDeckCanBeFilledUpWithCards(){
        deck = new DeckOfCards(52);
        assertEquals(0, deck.getNumberOfCardsInDeck());
        deck.createFilledPokerCardDeck();
        assertEquals(52, deck.getNumberOfCardsInDeck());
    }
}
