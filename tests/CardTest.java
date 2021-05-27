import cardGame.Card;
import org.junit.jupiter.api.Test;

import static cardGame.Faces.*;
import static cardGame.Suits.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    @Test
    void testThatSpadeCardCanBeCreated(){
        Card card = new Card(ACE, SPADE);
        assertEquals(card.getSuit(), SPADE);
    }
    @Test
    void testThatDiamondCardCanBeCreated(){
        Card card = new Card(ACE, DIAMOND);
        assertEquals(card.getSuit(), DIAMOND);
    }
    @Test
    void testThatClubCardCanBeCreated(){
        Card card = new Card(ACE, CLUB);
        assertEquals(card.getSuit(), CLUB);
    }
    @Test
    void testThatHeartsCardCanBeCreated(){
        Card card = new Card(ACE, HEARTS);
        assertEquals(card.getSuit(), HEARTS);
    }
    @Test
    void testThatAceCardCanBeCreated(){
        Card card = new Card(ACE, SPADE);
        assertEquals(card.getFace(), ACE);
    }
    @Test
    void testThatCardTwoCanBeCreated(){
        Card card = new Card(TWO, SPADE);
        assertEquals(card.getFace(), TWO);
    }
    @Test
    void testThatCardThreeCanBeCreated(){
        Card card = new Card(THREE, SPADE);
        assertEquals(card.getFace(), THREE);
    }
    @Test
    void testThatCardFourCanBeCreated(){
        Card card = new Card(FOUR, SPADE);
        assertEquals(card.getFace(), FOUR);
    }
    @Test
    void testThatCardFiveCanBeCreated(){
        Card card = new Card(FIVE, SPADE);
        assertEquals(card.getFace(), FIVE);
    }
    @Test
    void testThatCardSixCanBeCreated(){
        Card card = new Card(SIX, SPADE);
        assertEquals(card.getFace(), SIX);
    }
    @Test
    void testThatCardSevenCanBeCreated(){
        Card card = new Card(SEVEN, SPADE);
        assertEquals(card.getFace(), SEVEN);
    }
    @Test
    void testThatCardEightCanBeCreated(){
        Card card = new Card(EIGHT, SPADE);
        assertEquals(card.getFace(), EIGHT);
    }
    @Test
    void testThatCardNineCanBeCreated(){
        Card card = new Card(NINE, SPADE);
        assertEquals(card.getFace(), NINE);
    }
    @Test
    void testThatCardTenCanBeCreated(){
        Card card = new Card(TEN, SPADE);
        assertEquals(card.getFace(), TEN);
    }
    @Test
    void testThatJackCardCanBeCreated(){
        Card card = new Card(JACK, SPADE);
        assertEquals(card.getFace(), JACK);
    }
    @Test
    void testThatKingCardCanBeCreated(){
        Card card = new Card(KING, SPADE);
        assertEquals(card.getFace(), KING);
    }
    @Test
    void testThatQueenCardCanBeCreated(){
        Card card = new Card(QUEEN, SPADE);
        assertEquals(card.getFace(), QUEEN);
    }
    @Test
    void testThatCardHasFaceAndSuit(){
        Card card = new Card(QUEEN, SPADE);
        assertEquals("QUEEN of SPADE", card.toString());
    }
    @Test
    void testThatTwoCardsWithMatchingSuitsAreEqual(){
        Card card = new Card(QUEEN, SPADE);
        assertEquals(SPADE, card.getSuit());
        Card secondCard = new Card(JACK, SPADE);
        assertEquals(SPADE, secondCard.getSuit());
        assertEquals(card, secondCard);
    }
    @Test
    void testThatTwoCardsWithMatchingFacesAreEqual(){
        Card card = new Card(QUEEN, CLUB);
        assertEquals(QUEEN, card.getFace());
        Card secondCard = new Card(QUEEN, SPADE);
        assertEquals(QUEEN, secondCard.getFace());
        assertEquals(card, secondCard);
    }



}
