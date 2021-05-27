package cardGame;

import cardGameExceptions.InvalidCardException;

import static cardGame.WhotShapes.*;
import static cardGame.WhotShapes.WHOT;
import static cardGame.WhotValues.*;
import static cardGame.WhotValues.TWENTY;

public class Card {
    private final Faces face;
    private final Suits suit;
    private final WhotValues value;
    private final WhotShapes shape;
    private final boolean isJokerCard;

    public Card(Faces cardFace, Suits cardSuit) {
        face = cardFace;
        suit = cardSuit;
        isJokerCard = true;
        shape = null;
        value = null;
    }
    public Card(WhotValues value, WhotShapes shape){
        boolean invalidTwentyWhotCard = validateForWhotCard(value, shape);
        boolean invalidCrossOrSquareCard = validateForCrossOrSquareCard(value, shape);
        boolean invalidStarCard = validateForStarCard(value, shape);

        if (invalidCrossOrSquareCard || invalidStarCard || invalidTwentyWhotCard)
            throw new InvalidCardException("value and shape mismatch");

        this.value = value;
        this.shape = shape;
        isJokerCard = false;
        suit = null;
        face = null;
    }

    public Faces getFace() {
        if(!isJokerCard)
            throw new InvalidCardException("Whot card does not have a face");
        return face;
    }

    public Suits getSuit() {
        if(!isJokerCard)
            throw new InvalidCardException("Whot card does not have a suit");
        return suit;
    }

    public WhotValues getValue() {
        if(isJokerCard)
            throw new InvalidCardException("Poker card does not have a value");
        return value;
    }

    public WhotShapes getShape() {
        if(isJokerCard)
            throw new InvalidCardException("Poker card does not have a shape");
        return shape;
    }

    @Override
    public String toString() {
        if(isJokerCard)
        return face + " of " + suit;
        else
            return value + " of " + shape;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return face == card.face || suit == card.suit;
    }

    private boolean validateForStarCard(WhotValues value, WhotShapes shape) {
        boolean invalidStarCard;
        invalidStarCard = (value == TEN || value == ELEVEN || value == TWELVE || value == THIRTEEN || value == FOURTEEN || value == TWENTY) &&
                (shape == STAR);
        return invalidStarCard;
    }

    private boolean validateForCrossOrSquareCard(WhotValues value, WhotShapes shape) {
        boolean invalidCrossOrSquareCard;
        invalidCrossOrSquareCard = (value == FOUR || value == TWELVE || value == EIGHT) && (shape == CROSS || shape == SQUARE);
        return invalidCrossOrSquareCard;
    }

    private boolean validateForWhotCard(WhotValues value, WhotShapes shape) {
        boolean invalidTwentyWhotCard;
        invalidTwentyWhotCard = (shape == WHOT && value != TWENTY) || (value == TWENTY && shape != WHOT);
        return invalidTwentyWhotCard;
    }
}
