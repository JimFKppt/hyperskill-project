import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String firstName = scanner.next();
        String yearOfExperience = scanner.next();
        String cuisinePreference = scanner.next();

        System.out.println("The form for " + firstName + " is completed. " +
                "We will contact you if we need a chef who cooks " + cuisinePreference +
                " dishes and has " + yearOfExperience + " years of experience.");
    }
}