import cardGame.*;
import org.junit.jupiter.api.Test;


import static cardGame.Faces.*;
import static cardGame.Suits.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameDealerTest {

    @Test
    void testThatGameDealerCanServeCard(){
        GameDealer gameDealer = new GameDealer();
        Card card = new Card(ACE, SPADE);
        DeckOfCards deck = new DeckOfCards(5);
        deck.push(card);
        assertEquals(1, deck.getNumberOfCardsInDeck());

        assertSame(card, gameDealer.serveCard(deck));
        assertEquals(0, deck.getNumberOfCardsInDeck());
    }

    @Test
    void testThatGameDealerCanShuffleDeck(){
        GameDealer gameDealer = new GameDealer();
        DeckOfCards deck = new DeckOfCards(6);
        Card card = new Card(ACE, SPADE);
        Card secondCard = new Card(KING, HEARTS);
        Card thirdCard = new Card(TWO, CLUB);
        Card fourthCard = new Card(JACK, DIAMOND);
        Card fifthCard = new Card(QUEEN, SPADE);
        Card sixthCard = new Card(SIX, SPADE);
        Card[] cards = {card, secondCard, thirdCard, fourthCard, fifthCard, sixthCard};

        for (Card value : cards) {
            deck.push(value);
        }

        assertEquals(6, deck.getNumberOfCardsInDeck());
        assertSame(sixthCard, deck.peek());

        gameDealer.shuffle(deck);
        assertNotSame(sixthCard, deck.peek());

    }
}
