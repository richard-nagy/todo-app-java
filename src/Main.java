void main() {
    // Write to console
    IO.println("Hello World");

    // Read from console
    IO.println("Write a message: ");
    Scanner scanner = new Scanner(System.in);
    String message = scanner.nextLine();
    System.out.println(message);
    IO.println("Your message: ");
}
