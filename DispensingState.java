package stateDesignPattern;

public class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Dispensing in progress. Please wait.");
    }
    
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Cannot insert coins while dispensing.");
    }
    
    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Dispensing item...");
        
        if (machine.getInventory() > 0) {
            machine.reduceInventory();
            machine.resetBalance();
            System.out.println("Item dispensed successfully.");
        } else {
            System.out.println("Out of stock.");
            machine.setState(new OutOfOrderState());
            return;
        }

        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Ready for next selection.");
        machine.setState(new IdleState());
    }
    
    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now out of order.");
        machine.setState(new OutOfOrderState());
    }
}