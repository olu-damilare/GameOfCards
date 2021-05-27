import cardGame.*;
import org.junit.jupiter.api.Test;

import static cardGame.Faces.*;
import static cardGame.Suits.*;

public class WhotTests {

    @Test
    void testThatCardWithFaceOneCanBeCreated(){
        Faces[] faces = {ONE, TWO, THREE, FOUR, FIVE, SEVEN, EIGHT, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, TWENTY};
        Suits[] suits = {CIRCLE, TRIANGLE, SQUARE, CROSS, STAR, WHOT};
        DeckOfCards deck = new DeckOfCards(50);
        boolean invalidCrossOrSquareCard;
        boolean invalidTwentyWhotCard;
        boolean invalidStarCard;

        for (Faces face : faces) {
            for (Suits suit : suits) {
                invalidTwentyWhotCard = (suit == WHOT && face != TWENTY) || (face == TWENTY && suit != WHOT);
                invalidCrossOrSquareCard = (face == FOUR || face == TWELVE || face == EIGHT) && (suit == CROSS || suit == SQUARE);
                invalidStarCard = (face == TEN || face == ELEVEN || face == TWELVE || face == THIRTEEN || face == FOURTEEN || face == TWENTY) &&
                        (suit == STAR);

                if (invalidCrossOrSquareCard || invalidStarCard || invalidTwentyWhotCard)
                    continue;
                Card card = new Card(face, suit);
                deck.push(card);
            }
        }

    }
}
