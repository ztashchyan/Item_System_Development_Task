public class GameItem {
    /**
     * the following class represents a game item with a name, rarity and an upgrade count.
     * Items can be upgraded based on some rule
     */
    private String name;
    private Rarity rarity; // enum type
    private int upgradeCount;

    /**
     * Constructor
     * @param name of the item
     * @param rarity of the item
     */

    public GameItem(String name, Rarity rarity){
        this.name = name;
        this.rarity = rarity;
        upgradeCount = 0;

    }

    public String getName(){//accessor method for name
        return name;
    }
    public Rarity getRarity(){//accessor method for rarity
        return rarity;
    }
    public int getUpgradeCount(){//accessor method for upgradeCount
        return upgradeCount;
    }

    /**
     * Checks if the item can be updated given the list of items
     * @param items list of the items that are checked
     * @return ture if the upgrade can be made, false otherwise.
     */
   public boolean canUpgrade(List<GameItem> items){
       if(items == null)
           throw new IllegalArgumentException();
        if(rarity == Rarity.EPIC){
            if(items.size() < 1)
                return false;
            for(GameItem item : items)
                if(item.rarity != Rarity.EPIC){
                    return false;
                }
            return true;
        }
        if(items.size() != 2)
            return false;
        for(GameItem item : items){
            if(!item.name.equals(this.name) || item.rarity!= this.rarity){
                return false;
            }
        }
        return true;
   }

    /**
     * This method upgrades the item if the correct items are provided
     * @param items the list of the items that need to be upgraded
     * @return true if the upgrade occurred
     */
   public boolean upgrade(List<GameItem> items){
        if(!canUpgrade(items)){
            System.out.println("Upgrade failed");
            return false;
        }
        switch (rarity){
            case COMMON:
                rarity = Rarity.GREAT;
                break;
            case GREAT:
                rarity = Rarity.RARE;
                break;
            case RARE:
                rarity = Rarity.EPIC;
                break;
            case EPIC:
                upgradeCount++;
                if(upgradeCount > 2){
                    return false;
                }
                break;
            case LEGENDARY:
                System.out.println("Item is already Legendary");
                return false;
        }
        return true;
   }

    /**
     * This method makes an Epic 2 item into a Legendary if the correct items are procided.
     * @param items the provided items
     * @return true if the transition was successful 
     */
   public boolean canBecomeLegendary(List<GameItem> items){
        if(rarity == Rarity.EPIC && upgradeCount ==2 && canUpgrade(items)){
            rarity = Rarity.LEGENDARY;
            upgradeCount = 0;
            return true;
        }
       System.out.println("cannot become legendary");
        return false;
   }

}
