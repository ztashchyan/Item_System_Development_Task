/**
 * The following class is the main class, where the functionality of the item system is demonstrated.
 */
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        /**
         * adding items to the inventory
         */

        inventory.addItem(new GameItem("Item1", Rarity.COMMON));
        inventory.addItem(new GameItem("Item2", Rarity.EPIC));
        inventory.addItem(new GameItem("Item3", Rarity.COMMON));
        inventory.displayInventory();
        /**
         * trying to upgrade an item and then displaying it
         */
        try{
            inventory.upgradeItem("Item ", Rarity.COMMON);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        inventory.displayInventory();
    }
}