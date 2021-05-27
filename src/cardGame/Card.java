package cardGame;


public class Card {
    private final Faces face;
    private final Suits suit;

    public Card(Faces cardFace, Suits cardSuit) {
        face = cardFace;
        suit = cardSuit;
    }

    public Faces getFace() {
        return face;
    }

    public Suits getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return face == card.face || suit == card.suit;
    }

}
