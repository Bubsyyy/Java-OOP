package _02_Encapsulation.FootbalTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        Map<String, Team> teams = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String [] tokens = input.split(";");

            try {
                switch (tokens[0]) {
                    case "Team":
                        teams.putIfAbsent(tokens[1], new Team(tokens[1]));
                        break;
                    case "Add":
                        addPlayer(sb, teams, tokens);
                        break;
                    case "Remove":
                        removePlayer(sb, teams, tokens);
                        break;
                    case "Rating":
                        getRating(sb, teams, tokens);
                        break;
                }
            } catch (IllegalArgumentException e) {
                sb.append(e.getMessage()).append(System.lineSeparator());
            }

            input = scanner.nextLine();
        }

        System.out.println(sb.toString().trim());
    }

    private static void getRating(StringBuilder sb, Map<String, Team> teams, String[] tokens) {
        if (!teams.containsKey(tokens[1])) {
            sb.append(String.format("Team %s does not exist.%n", tokens[1]));
        } else {
            sb.append(String.format("%s - %d%n", tokens[1], (int) Math.round(teams.get(tokens[1]).getRating())));
        }
    }

    private static void removePlayer(StringBuilder sb, Map<String, Team> teams, String[] tokens) {
        if (teams.get(tokens[1]).hasPlayer(tokens[2])) {
            teams.get(tokens[1]).removePlayer(tokens[2]);
        } else {
            sb.append(String.format("Player %s is not in %s team.%n", tokens[2], tokens[1]));
        }
    }

    private static void addPlayer(StringBuilder sb, Map<String, Team> teams, String[] tokens) {
        if (teams.containsKey(tokens[1])) {
            Player player = new Player(
                    tokens[2],
                    Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4]),
                    Integer.parseInt(tokens[5]),
                    Integer.parseInt(tokens[6]),
                    Integer.parseInt(tokens[7]));
            teams.get(tokens[1]).addPlayer(player);
        } else {
            sb.append(String.format("Team %s does not exist.%n", tokens[1]));
        }
    }

}