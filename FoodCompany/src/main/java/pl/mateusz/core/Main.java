package pl.mateusz.core;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Main {
    /*
    public static void main(String[] args) {
        List<FoodCategory> categories = new ArrayList<>();
        // --- Fruits ---
        FoodCategory fruits = FoodCategory.builder()
                .name("Fruits")
                .description("Fresh fruits and berries")
                .isVegetarian(true)
                .build();
        categories.add(fruits);
        Food apple = Food.builder()
                .name("Apple")
                .price(1)
                .quantity(200)
                .category(fruits)
                .build();
        fruits.addFood(apple);
        Food banana = Food.builder()
                .name("Banana")
                .price(2)
                .quantity(150)
                .category(fruits)
                .build();
        fruits.addFood(banana);
        Food strawberry = Food.builder()
                .name("Strawberry")
                .price(7)
                .quantity(400)
                .category(fruits)
                .build();
        fruits.addFood(strawberry);
        // ---  Meats ---
        FoodCategory meats = FoodCategory.builder()
                .name("Meats")
                .description("Various types of meat")
                .isVegetarian(false)
                .build();
        categories.add(meats);
        Food chicken = Food.builder()
                .name("Chicken Breast")
                .price(25)
                .quantity(1000)
                .category(meats)
                .build();
        meats.addFood(chicken);
        Food steak = Food.builder()
                .name("Beef Steak")
                .price(50)
                .quantity(1000)
                .category(meats)
                .build();
        meats.addFood(steak);
        // ---  Sweets ---
        FoodCategory sweets = FoodCategory.builder()
                .name("Sweets")
                .description("Various types of sweets. This one is reallyyyy unhealthy")
                .isVegetarian(true)
                .build();
        categories.add(sweets);
        Food crisps = Food.builder()
                .name("Crisps")
                .price(5)
                .quantity(150)
                .category(sweets)
                .build();
        sweets.addFood(crisps);
        Food nutella = Food.builder()
                .name("Nutella")
                .price(20)
                .quantity(350)
                .category(sweets)
                .build();
        sweets.addFood(nutella);

        categories.forEach(category -> {
            System.out.println(category);
            category.getFoods().forEach(food -> {
                System.out.println(food);
            });
        });


        //z3
        Set<Food> allFoods = categories.stream().flatMap(food -> food.getFoods().stream()).collect(Collectors.toSet());
        System.out.println("\n[z3] All foods in one set");
        allFoods.forEach(food -> System.out.println(food));

        //z4
        System.out.println("\n[z4] Foods filter, sorted, and print in one stream");
        allFoods.stream().filter(food -> food.getPrice() > 10).sorted(Comparator.comparing(Food::getQuantity)).forEach(System.out::println);

        //z5
        System.out.println("\n[z5] Transform DTO, sort natural order, collect into the List in one stream. Then print in secound stream");
        List<FoodDTO> foodDTO = allFoods.stream().map(FoodDTO::fromFood).sorted().toList();
        foodDTO.forEach(food -> System.out.println(food));

        //z6
        String filename = "categories.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(categories);
            System.out.println("\n[z6] Serialization: categories saved to " + filename);
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            List<FoodCategory> loadedCategories = (List<FoodCategory>) ois.readObject();
            System.out.println("\n[z6] Deserialization: categories loaded from " + filename);
            loadedCategories.forEach(category -> {
                System.out.println(category);
                category.getFoods().forEach(food -> {
                    System.out.println("  " + food);
                });
            });
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error: " + e.getMessage());
        }
        //z7
        for (int i=1;i<=4;i++){
            System.out.println("\n[z7] Parallel processing with ForkJoinPool (size="+i+")");
            processCategories(categories, i);
        }

    }
    private static void processCategories(List<FoodCategory> categories, int poolSize) {
        ForkJoinPool customPool = new ForkJoinPool(poolSize);
        try {
            long start = System.currentTimeMillis();
            customPool.submit(() ->
                    categories.parallelStream().forEach(category -> {
                        String threadName = Thread.currentThread().getName();
                        System.out.println("[" + threadName + "] Processing category: " + category.getName());
                        category.getFoods().forEach(food -> {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("[" + Thread.currentThread().getName() + "]   " + food);
                        });
                    })
            ).join();
            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Pool size=" + poolSize + ", time=" + elapsed + "ms");
        } finally {
            customPool.shutdown();
        }
    }

     */

    public static void main(String[] args) {
        List<FoodCompany> companies = new ArrayList<>();
        // --- Fruits ---
        FoodCompany legsad = FoodCompany.builder()
                .name("Legsad")
                .nip("6912552643")
                .isPolish(true)
                .build();
        companies.add(legsad);
        Food raspberries = Food.builder()
                .name("Raspberries")
                .price(15)
                .quantity(200)
                .company(legsad)
                .build();
        legsad.addFood(raspberries);
        Food blueberries = Food.builder()
                .name("Blueberries")
                .price(10)
                .quantity(300)
                .company(legsad)
                .build();
        legsad.addFood(blueberries);
        Food strawberry = Food.builder()
                .name("Strawberry")
                .price(7)
                .quantity(400)
                .company(legsad)
                .build();
        legsad.addFood(strawberry);
        // ---  Meats ---
        FoodCompany sokolow = FoodCompany.builder()
                .name("Sokołów")
                .nip("8230001444")
                .isPolish(false)
                .build();
        companies.add(sokolow);
        Food chicken = Food.builder()
                .name("Chicken Breast")
                .price(25)
                .quantity(1000)
                .company(sokolow)
                .build();
        sokolow.addFood(chicken);
        Food steak = Food.builder()
                .name("Beef Steak")
                .price(50)
                .quantity(1000)
                .company(sokolow)
                .build();
        sokolow.addFood(steak);
        // ---  Sweets ---
        FoodCompany fererro = FoodCompany.builder()
                .name("Ferrero")
                .nip("5220101131")
                .isPolish(false)
                .build();
        companies.add(fererro);
        Food ferreroRocher = Food.builder()
                .name("Ferrero Rocher")
                .price(25)
                .quantity(150)
                .company(fererro)
                .build();
        fererro.addFood(ferreroRocher);
        Food nutella = Food.builder()
                .name("Nutella")
                .price(20)
                .quantity(350)
                .company(fererro)
                .build();
        fererro.addFood(nutella);

        companies.forEach(category -> {
            System.out.println(category);
            category.getFoods().forEach(food -> {
                System.out.println(food);
            });
        });


        //z3
        Set<Food> allFoods = companies.stream().flatMap(food -> food.getFoods().stream()).collect(Collectors.toSet());
        System.out.println("\n[z3] All foods in one set");
        allFoods.forEach(food -> System.out.println(food));

        //z4
        System.out.println("\n[z4] Foods filter, sorted, and print in one stream");
        allFoods.stream().filter(food -> food.getPrice() > 10).sorted(Comparator.comparing(Food::getQuantity)).forEach(System.out::println);

        //z5
        System.out.println("\n[z5] Transform DTO, sort natural order, collect into the List in one stream. Then print in secound stream");
        List<FoodDTO> foodDTO = allFoods.stream().map(FoodDTO::fromFood).sorted().toList();
        foodDTO.forEach(food -> System.out.println(food));

        //z6
        String filename = "categories.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(companies);
            System.out.println("\n[z6] Serialization: categories saved to " + filename);
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            List<FoodCompany> loadedCompanies = (List<FoodCompany>) ois.readObject();
            System.out.println("\n[z6] Deserialization: categories loaded from " + filename);
            loadedCompanies.forEach(category -> {
                System.out.println(category);
                category.getFoods().forEach(food -> {
                    System.out.println("  " + food);
                });
            });
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error: " + e.getMessage());
        }
        //z7
        for (int i=1;i<=4;i++){
            System.out.println("\n[z7] Parallel processing with ForkJoinPool (size="+i+")");
            processCategories(companies, i);
        }

    }
    private static void processCategories(List<FoodCompany> companies, int poolSize) {
        ForkJoinPool customPool = new ForkJoinPool(poolSize);
        try {
            long start = System.currentTimeMillis();
            customPool.submit(() ->
                    companies.parallelStream().forEach(category -> {
                        String threadName = Thread.currentThread().getName();
                        System.out.println("[" + threadName + "] Processing category: " + category.getName());
                        category.getFoods().forEach(food -> {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("[" + Thread.currentThread().getName() + "]   " + food);
                        });
                    })
            ).join();
            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Pool size=" + poolSize + ", time=" + elapsed + "ms");
        } finally {
            customPool.shutdown();
        }
    }
}