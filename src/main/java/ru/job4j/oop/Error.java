package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        System.out.println("Default Error");
        defaultError.printError();

        Error customError1 = new Error(true, 404, "Page Not Found");
        System.out.println("\nCustom Error 1:");
        customError1.printError();

        Error customError2 = new Error(false, 500, "Internal Server Error");
        System.out.println("\nCustom Error 2:");
        customError2.printError();
    }
}