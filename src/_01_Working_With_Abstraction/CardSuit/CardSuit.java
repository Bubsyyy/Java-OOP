package _01_Working_With_Abstraction.CardSuit;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int value;

    CardSuit(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}