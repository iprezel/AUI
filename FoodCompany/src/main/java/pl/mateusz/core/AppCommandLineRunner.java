package pl.mateusz.core;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.mateusz.company.FoodCompany;
import pl.mateusz.company.FoodCompanyService;
import pl.mateusz.food.Food;
import pl.mateusz.food.FoodService;
import tools.jackson.databind.ObjectWriter;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;
@ConditionalOnProperty(name = "app.cli.enabled", havingValue = "true", matchIfMissing = true)
@Component
@RequiredArgsConstructor
public class AppCommandLineRunner implements CommandLineRunner {
    private final FoodService foodService;
    private final FoodCompanyService foodCompanyService;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        boolean isRunning = true;
        printMenu();
        while (isRunning){
            System.out.println("-----------------");
            switch (readLine("Enter your choice: ")) {
                case "1" -> printMenu();
                case "2" -> printAllFoodCompanies();
                case "3" -> printAllFood();
                case "4" -> addFood();
                case "5" -> deleteFood();
                case "0" -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Unrecognized command, try again.");
            }
        }

    }
    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    public void printMenu() {
        System.out.println("--- MAIN MENU ---");
        System.out.println("1 - List available commands");
        System.out.println("2 - List all food companies");
        System.out.println("3 - List all foods");
        System.out.println("4 - Add a new food");
        System.out.println("5 - Delete an existing element");
        System.out.println("0 - Stop the application");
    }
    public void printAllFoodCompanies() {
        List<FoodCompany> foodCompanyList = foodCompanyService.findAll().stream().toList();
        for(FoodCompany company: foodCompanyList){
            System.out.println(company);
        }
    }
    public void printAllFood() {
        List<Food> foodList = foodService.findAll().stream().toList();
        for(Food food: foodList){
            System.out.println(food);
        }
    }

    public void addFood() {
        UUID id = readUuid("Enter id: ");
        if (foodService.findById(id).isPresent()) {
            System.out.println("Food with this id already exists.");
            return;
        }
        String name;
        do{
            name = readLine("Enter name: ");
        }while(name.isEmpty());
        int price = readInt("Enter price (>=1): ", 1);
        int quantity = readInt("Enter quantity (>=1): ", 1);
        printAllFoodCompanies();
        Optional<FoodCompany> company = foodCompanyService.findById(readUuid("Select company (write id): "));
        if (company.isEmpty()) {
            System.out.println("No company with given id.");
            return;
        }
        foodService.saveFood(Food.builder()
                .id(id)
                .name(name).price(price).quantity(quantity)
                .foodCompany(company.get())
                .build());
        System.out.println("Food added!");
    }

    public void deleteFood() {
        printAllFood();
        UUID id = readUuid("Select food to delete (write id): ");
        boolean deleted = foodService.deleteFood(id);
        System.out.println(deleted ? "Food deleted!" : "No food with given id.");
    }

    private int readInt(String prompt, int min) {
        while (true) {
            try {
                int v = Integer.parseInt(readLine(prompt));
                if (v >= min) return v;
            } catch (NumberFormatException ignored) { } //blok catch jest pusty bo sa dwa bledy mozliwe jeden w bloku catch drugi if
            System.out.println("Enter an integer >= " + min + ".");
        }
    }

    private UUID readUuid(String prompt) {
        while (true) {
            try { return UUID.fromString(readLine(prompt)); }
            catch (IllegalArgumentException e) { System.out.println("Invalid UUID format."); }
        }
    }
}
