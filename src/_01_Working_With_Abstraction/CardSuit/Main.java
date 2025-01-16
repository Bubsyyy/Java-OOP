package _01_Working_With_Abstraction.CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");

        for (CardSuit suit : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    suit.getValue(),
                    suit.toString());
        }

    }
}