package _01_Working_With_Abstraction.CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");

        for (CardRank value : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    value.getValue(),
                    value.toString());
        }

    }
}