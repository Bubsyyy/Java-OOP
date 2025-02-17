package _01_Working_With_Abstraction.CardsWithPower;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    CardSuit(int  value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}