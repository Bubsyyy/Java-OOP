package _01_Working_With_Abstraction.CardsWithPower;



public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;
    private int power;

    public Card(CardSuit cardSuits, CardRank cardRanks) {
        this.cardSuit = cardSuits;
        this.cardRank = cardRanks;
    }

    public int getPower() {
        return this.cardSuit.getValue() + this.cardRank.getValue();
    }
}