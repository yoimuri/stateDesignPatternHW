package stateDesignPattern;

public class VendingMachine {
    private VendingMachineState state;
    private int inventory;
    private int balance;
    private final int itemPrice = 50;

    public VendingMachine(int inventory) {
        this.inventory = inventory;
        this.state = new IdleState();
        this.balance = 0;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void selectItem() {
        state.selectItem(this);
    }

    public void insertCoin(int amount) {
        state.insertCoin(this, amount);
    }

    public void dispenseItem() {
        state.dispenseItem(this);
    }

    public void setOutOfOrder() {
        state.setOutOfOrder(this);
    }

    public void addBalance(int amount) {
        balance += amount;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void resetBalance() {
        balance = 0;
    }
    
    public int getInventory() {
        return inventory;
    }
    
    public void reduceInventory() {
        inventory--;
    }
    
    public int getItemPrice() {
        return itemPrice;
    }
}