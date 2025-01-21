package _04_Interfaces_And_Abstraction.FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyersByNames = new HashMap<>();

        while (n-- > 0) {
            Buyer buyer = createBuyer(scanner.nextLine());
            buyersByNames.put(buyer.getName(), buyer);
        }

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            Buyer buyer = buyersByNames.get(line);
            if (buyer != null) {
                buyer.buyFood();
            }

            line = scanner.nextLine();
        }

        System.out.println(buyersByNames.values().stream().mapToInt(Buyer::getFood).sum());
    }

    private static Buyer createBuyer(String input) {
        String[] tokens = input.split("\\s+");
        if (tokens.length == 4) {
            return new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
        }
        return new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
    }

}