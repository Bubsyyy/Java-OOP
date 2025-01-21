package _04_Interfaces_And_Abstraction.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder urlOutput = new StringBuilder();
        for (String url : urls) {
            boolean hasADigit = false;
            for (int i = 0; i < url.length(); i++) {
                if (Character.isDigit(url.charAt(i))) {
                    urlOutput.append("Invalid URL!").append(System.lineSeparator());
                    hasADigit = true;
                    break;
                }
            }
            if (!hasADigit) {
                urlOutput.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return urlOutput.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder numberOutput = new StringBuilder();
        for (String number : numbers) {
            boolean hasANonDigit = false;
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                    numberOutput.append("Invalid number!").append(System.lineSeparator());
                    hasANonDigit = true;
                    break;
                }
            }
            if (!hasANonDigit) {
                numberOutput.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return numberOutput.toString().trim();
    }

}
