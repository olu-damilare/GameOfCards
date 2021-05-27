import cardGame.*;
import cardGameExceptions.InvalidCardException;
import org.junit.jupiter.api.Test;

import static cardGame.WhotShapes.*;
import static cardGame.WhotValues.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhotTests {

    @Test
    void testThatCardOneCanBeCreated(){
        try{
            Card card = new Card(TEN, STAR);
            assertEquals(TEN, card.getValue());
        }catch(InvalidCardException e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    void testThatCardWithFaceOneCanBeCreated(){
        DeckOfCards deck = new DeckOfCards(54);
        assertEquals(0, deck.getNumberOfCardsInDeck());
        deck.createFilledWhotCardDeck();
        assertEquals(54, deck.getNumberOfCardsInDeck());

    }
}
