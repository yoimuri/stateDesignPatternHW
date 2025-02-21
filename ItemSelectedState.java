package stateDesignPattern;

public class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item already selected.");
    }
    
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        machine.addBalance(amount);
        System.out.println("Inserted coin: " + amount);
        
        if (machine.getBalance() >= machine.getItemPrice()) {
            System.out.println("Sufficient balance. Dispensing item...");
            machine.setState(new DispensingState());
            machine.dispenseItem();
        }
    }
    
    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Insert coins first.");
    }
    
    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now out of order.");
        machine.setState(new OutOfOrderState());
    }
}