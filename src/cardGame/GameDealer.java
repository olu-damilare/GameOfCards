package cardGame;

public class GameDealer {
    public Card serveCard(DeckOfCards deck) {
        return deck.pop();
    }

    public void shuffle(DeckOfCards deck) {
        deck.shuffle();
    }
}
