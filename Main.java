package stateDesignPattern;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(3);

        System.out.println("\n--- Selecting Item ---");
        machine.selectItem();

        System.out.println("\n--- Inserting Coins ---");
        machine.insertCoin(25);
        machine.insertCoin(25);

        System.out.println("\n--- Selecting Item ---");
        machine.selectItem();

        System.out.println("\n--- Inserting Extra Coin ---");
        machine.insertCoin(50);

        System.out.println("\n--- Setting Machine Out of Order ---");
        machine.setOutOfOrder();

        System.out.println("\n--- Trying to Select in OutOfOrderState ---");
        machine.selectItem();

        System.out.println("\n--- Trying to Insert Coin in OutOfOrderState ---");
        machine.insertCoin(50);
    }
}