package com.builderpattern;

import com.builderpattern.applicationContext.ApplicationContext;
import com.builderpattern.builder.CarBuilder;
import com.builderpattern.builder.CarBuilderImpl;
import com.builderpattern.exception.BusinessException;
import com.builderpattern.exception.CarNotFoundException;
import com.builderpattern.model.Car;
import com.builderpattern.model.CarType;
import com.builderpattern.model.Pessoa;
import com.builderpattern.service.CarService;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        CarService carService = applicationContext.getCarService();

        Scanner sc = new Scanner(System.in);
        boolean keepLooping = true;
        int menuOption;

        while (keepLooping) {
            printMenu();
            menuOption = sc.nextInt();

            switch (menuOption) {
                case 1 -> adicionarCarro(carService, sc);
                case 2 -> procurarCarroPorId(carService, sc);
                case 3 -> mostrarTodosCarros(carService);
                case 4 -> inativarCarroPorId(carService, sc);
                case 5 -> ativarCarroPorId(carService, sc);
                case 6 -> mostrarTodosCarrosDisponiveis(carService);
                case 7 -> keepLooping = false;
                default -> System.out.println("%d não é uma opcao valida".formatted(menuOption));
            }
        }
    }

    private  static void printMenu() {
        System.out.print("""
                1 - Adicionar carro
                2 - Procurar carro por id
                3 - Mostrar todos os carros
                4 - Inativar carro por id
                5 - Ativar carro por id
                6 - Mostrar todos carros disponíveis
                7 - Sair
                ->\s""");
    }

    private static void adicionarCarro(CarService carService, Scanner sc) {
        try {
            printCarros();
            int option = sc.nextInt();

            switch (option) {
                case 1 -> System.out.println(carService.insert(exemploSemBuilderComTodosOsParametros()));
                case 2 -> System.out.println(carService.insert(exemploSemBuilderComParametrosNecessarios()));
                case 3 -> System.out.println(carService.insert(exemploComBuilderComTodosParametros()));
                case 4 -> System.out.println(carService.insert(exemploComBuilderComParametrosNecessarios()));
                default -> System.out.println("%d nao e uma opcao valida".formatted(option));
            }
        } catch (InputMismatchException e) {
            System.out.println("Formato do input invalido");
            sc.nextLine();
        }
    }

    private static void printCarros() {
        System.out.println("""
                1) Adicionar carro exemplo 1
                2) Adicionar carro exemplo 2
                3) Adicionar carro exemplo 3
                4) Adicionar carro exemplo 4
                ->\s""");
    }

    private static void procurarCarroPorId(CarService carService, Scanner sc) {
        try {
            System.out.print("id -> ");
            Long id =  sc.nextLong();
            Car car = carService.getById(id);

            System.out.println(car);
        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Formato do input invalido");
            sc.nextLine();
        }
    }

    private static void mostrarTodosCarros(CarService carService) {
        carService.getAll().forEach(System.out::println);
    }

    private static void inativarCarroPorId(CarService carService, Scanner sc) {
        try {
            System.out.print("id -> ");
            Long id =  sc.nextLong();
            System.out.println(carService.deactivate(id));
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Formato do input invalido");
            sc.nextLine();
        }
    }

    private static void ativarCarroPorId(CarService carService, Scanner sc) {
        try {
            System.out.print("id -> ");
            Long id =  sc.nextLong();
            System.out.println(carService.activate(id));
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Formato do input invalido");
            sc.nextLine();
        }
    }

    private static void mostrarTodosCarrosDisponiveis(CarService carService) {
        carService.getAvailableCars().forEach(System.out::println);
    }

    private static Car exemploSemBuilderComTodosOsParametros() {

        return new Car(null, "HJL123", "Modelo sem builder com todos os parametros", Year.of(2000),
                "Marca de exemplo 1", "Azul", "273981739", CarType.COMBUSTION_CAR, true);
    }

    private static Car exemploSemBuilderComParametrosNecessarios() {

        return new Car(null, "DSV", "Modelo sem builder com parametros necessarios", null,
                null, null, null, CarType.ELECTRIC_CAR, true);
    }

    private static Car exemploComBuilderComTodosParametros() {

        CarBuilder carBuilder = new CarBuilderImpl();

        return carBuilder
                .licensePlate("NTJ1234")
                .model("Modelo com builder com todos os parametros")
                .releaseYear(Year.of(1980))
                .brand("exemplo 2")
                .color("azul")
                .vin("1234567890")
                .carType(CarType.COMBUSTION_CAR)
                .build();
    }

    private static Car exemploComBuilderComParametrosNecessarios() {

        CarBuilder carBuilder = new CarBuilderImpl();

        return carBuilder
                .licensePlate("ATX5050")
                .model("Modelo com builder com parametros necessarios")
                .carType(CarType.HYBRID)
                .build();
    }

    private static Pessoa exemploLombok() {

        return Pessoa.builder()
                .firstName("Joao")
                .lastName("Pessoa")
                .age(10)
                .height(160)
                .build();
    }
}