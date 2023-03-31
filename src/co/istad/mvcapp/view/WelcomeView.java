package co.istad.mvcapp.view;

import co.istad.mvcapp.controller.ProductController;
import co.istad.mvcapp.dto.CreateProductDto;
import co.istad.mvcapp.dto.ProductDto;
import co.istad.mvcapp.util.InputUtil;

import java.util.Scanner;
import java.util.UUID;

public class WelcomeView {

    private void showMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Welcome to My Application");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Create new product");
        System.out.println("2. List all products");
        System.out.println("3. Remove product by UUID");
        System.out.println("4. Update product by UUID");
        System.out.println("5. Search product by Name");
        System.out.println("0. Exit Application");
    }

    private void showMessage(String message) {
        System.out.println("--------------------------------------------------");
        System.out.println("-> " + message);
    }

    public void render() {

        ProductController controller = new ProductController();

        while (true) {

            // Invoke showMenu() to show up the menu of the application
            this.showMenu();

            // Get option
            int option = InputUtil.getInteger("Choose option: ");

            switch (option) {
                case 0 -> {
                    System.out.println("Thank you for using our program");
                    System.exit(0);
                }
                case 1 -> {
                    this.showMessage("Create new product");
                    Integer code = InputUtil.getInteger("Enter code: ");
                    String name = InputUtil.getText("Enter name: ");
                    Double priceIn = InputUtil.getFloatingPoint("Enter price in: ");
                    CreateProductDto createProductDto = new CreateProductDto(code, name, priceIn);
                    ProductDto productDto = controller.handleCreateNewProduct(createProductDto);
                    this.showMessage("Product has been created successfully");
                    ProductView.single(productDto);
                }
                case 2 -> {
                    this.showMessage("Products have been found successfully");
                    ProductView.list(controller.handleProductList());
                }
                case 3 -> {
                    UUID uuid = UUID.fromString(InputUtil.getText("Enter UUID: "));
                    controller.handleRemoveProductByUUID(uuid);
                }
                case 4 -> {
                    System.out.println("Premium feature, a cup of coffee to contribute with teacher..!");
                }
                case 5 -> {
                    System.out.println("Coming soon..!");
                }
                default -> System.out.println("Invalid option..!");
            }

            InputUtil.pressEnterToContinue();
        }
    }
}
