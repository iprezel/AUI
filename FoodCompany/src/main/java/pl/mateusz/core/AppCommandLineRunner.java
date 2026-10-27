package pl.mateusz.core;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mateusz.company.FoodCompany;
import pl.mateusz.company.FoodCompanyService;
import pl.mateusz.food.Food;
import pl.mateusz.food.FoodService;
import tools.jackson.databind.ObjectWriter;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AppCommandLineRunner implements CommandLineRunner {
    private final FoodService foodService;
    private final FoodCompanyService foodCompanyService;
    //private final ObjectWriter objectWriter;

    @Override
    public void run(String... args) throws Exception {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        printMenu();
        while (isRunning){
            printAlways();
            switch(scanner.nextInt()){
                case 1 -> printMenu();
                case 2 -> printAllFoodCompanies();
                case 3 -> printAllFood();
                case 4 -> addFood(scanner);
                case 5 -> deleteFood(scanner);
                case 0 -> isRunning = false;
                default -> System.out.println("Unrecognized command try again.");
            }
        }

    }
    public void printAlways(){
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
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
    public void printAllFoodCompanies(){
        List<FoodCompany> foodCompanyList = foodCompanyService.findAll().stream().toList();
        for(FoodCompany company: foodCompanyList){
            System.out.println(company);
        }
    }
    public void printAllFood(){
        List<Food> foodList = foodService.findAll().stream().toList();
        for(Food food: foodList){
            System.out.println(food);
        }
    }

    public void addFood(Scanner scanner){
        System.out.print("Enter id: ");
        UUID uuid = UUID.fromString(scanner.next());
        System.out.print("Enter name: ");
        String name = scanner.next();
        int price = -1;
        do{
            System.out.print("Enter price(>=0): ");
            price = scanner.nextInt();
        }while(price<1);
        int quantity = -1;
        do{
            System.out.print("Enter quantity(>=0): ");
            quantity = scanner.nextInt();
        }while(quantity<1);

        printAllFoodCompanies();
        System.out.print("Select the category(write id): ");
        UUID companyId = UUID.fromString(scanner.next());
        foodService.saveFood(Food.builder().id(uuid).name(name).price(price).quantity(quantity).foodCompany(FoodCompany.builder().id(companyId).build()).build());
        System.out.print("Item success added!");
    }

    public void deleteFood(Scanner scanner){
        printAllFood();
        System.out.print("Select food to delete(write id): ");
        UUID foodId = UUID.fromString(scanner.next());
        foodService.deleteFood(foodId);
        System.out.print("Item success deleted!");
    }
}
