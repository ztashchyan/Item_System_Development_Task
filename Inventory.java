import java.util.*;

/**
 * The following method manages a collection of game items.
 * The items can upgrade and display in the inventory
 */
public class Inventory {
   private List<GameItem> items = new ArrayList<>();
   public void addItem(GameItem item){
       items.add(0,item);
   }

    /**
     * Displays the inventory
     */
   public void displayInventory(){
       Map<Rarity, List<GameItem>> groupedItems = new HashMap<>();
       for(GameItem item : this.items){
           if(!groupedItems.containsKey(item.getRarity())) {
               groupedItems.put(item.getRarity(), new ArrayList<>());
           }
           groupedItems.get(item.getRarity()). add(groupedItems.size(), item);

           }
       for(Rarity rarity : Rarity.values()){
           if(groupedItems.containsKey(rarity))
               System.out.println(rarity +" " + groupedItems.get(rarity));
       }
   }

    /**
     * This method upgrades the Item
     * @param name given the name of the game item
     * @param rarity given the rarity of the game item
     * @return returns ture if the upgrade was made and false otherwise
     */
   public boolean upgradeItem(String name, Rarity rarity) {
       List<GameItem> matchingItems = new ArrayList<>();
       for (GameItem item : items) {
           if (item.getName().equals(name) && item.getRarity() == rarity)
               matchingItems.add(matchingItems.size(), item);
       }
       if (matchingItems.size() >= 3) {
           GameItem targetItem = matchingItems.get(0);
           List<GameItem> contains = new ArrayList<>();
           contains.add(matchingItems.size(), matchingItems.get(1));
           contains.add(matchingItems.size(), matchingItems.get(2));

           if (targetItem.upgrade((List<GameItem>) contains)) {
               items.remove(1);
               items.remove(2);
               return true;
           }
       }
       System.out.println("Not enough matching items");
       return false;
   }
}
