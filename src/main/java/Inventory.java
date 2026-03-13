package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * The Inventory class represents an inventory that displays money and items that the player has.
 */
public class Inventory implements Container {

    private int money;
    private Item[][] items;
    private String name;

    /**
     * Constructs an inventory with a given name, amount of money, and item grid.
     *
     * @param name  the name of the inventory
     * @param money the initial amount of money
     * @param items the initial item grid
     */
    public Inventory(String name, Item[][] items, String filepath) {
        this.name = name;
        this.money = (int) Load_Inventory.loadMoney(filepath);
        this.items = (items != null) ? items : new Item[7][4];
        List<Item> itemList;

        if (CurrentState.getInstance().getSaveFile() == 0) {
            itemList = JSonReader.loadItemsInOrder("src/main/java/com/example/items.json");
        } else if (CurrentState.getInstance().getSaveFile() == 0) {
            itemList = JSonReader.loadItemsInOrder("src/main/java/com/example/items1.json");
        } else {
            itemList = JSonReader.loadItemsInOrder("src/main/java/com/example/items2.json");
        }

        if (itemList == null) {
            itemList = new ArrayList<>();
        }

        int x = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                if (x < itemList.size()) {
                    this.items[i][j] = itemList.get(x);
                    x++;
                } 
                else {
                    this.items[i][j] = null;
                }
            }
        }
    }

    /**
     * Gets the amount of money in the inventory.
     *
     * @return the amount of money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money in the inventory.
     *
     * @param money the amount of money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Gets the name of the container.
     *
     * @return the name of the container
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the inventory.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds an item to the inventory if there is an empty slot.
     *
     * @param item the item to add
     */
    public void addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                if (items[i][j] == null) {
                    items[i][j] = item;
                    return;
                }
            }
        }
    }

    /**
     * Removes an item from the inventory by setting its slot to null.
     *
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        if (item.getType() == Item.ItemType.FOOD) {
            for(int i = 0; i < items.length; i++) {
                for(int j = 0; j < items[i].length; j++) {
                    if(items[i][j] != null && items[i][j].equals(item)) {
                        if (items[i][j].getInventoryAmount() <= 0) {
                            items[i][j].setInventoryAmount(0);
                        }
                        else{
                            items[i][j].setInventoryAmount(item.getInventoryAmount() - 1);
                        }
                        return;
                    }
                }
            }
        } 
        else if (item.getType() == Item.ItemType.TOY) {
            for(int i = 0; i < items.length; i++) {
                for(int j = 0; j < items[i].length; j++) {
                    if(items[i][j] != null && items[i][j].equals(item)) {
                        if (items[i][j].getInventoryAmount() == 0) {
                            items[i][j].setInventoryAmount(0);
                        }
                        else{
                            items[i][j].setInventoryAmount(item.getInventoryAmount() - 1);
                        }
                        return;
                    }
                }
            }
        } 
        else if (item.getType() == Item.ItemType.GIFT) {
            for(int i = 0; i < items.length; i++) {
                for(int j = 0; j < items[i].length; j++) {
                    if(items[i][j] != null && items[i][j].equals(item)) {
                        items[i][j].setInventoryAmount(item.getInventoryAmount() - 1);
                        if (items[i][j].getInventoryAmount() == 0) {
                            items[i][j].setInventoryAmount(0);
                        }
                        else{
                            items[i][j].setInventoryAmount(item.getInventoryAmount() - 1);
                        }
                        return;
                    }
                }
            }
        }
    }

    /**
     * Filters items in the inventory by their type.
     *
     * @param type the item type to filter by
     * @return a list of items matching the specified type
     */
    public Item[][] filterItem(Item.ItemType type) {
        int x = 0;
        int y = 0;
        Item[][] filteredItems = new Item[7][4];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                if (items[i][j] != null && items[i][j].getType().equals(type)) {
                    filteredItems[x][y] = items[i][j];
                    y++;
                    if (y >= 4) {
                        x = (x + 1) % 7;
                        y = 0;
                    }
                }
            }
        }
        return filteredItems;
    }

    /**
     * Filters items in the inventory by their element type.
     *
     * @param elementType the element type to filter by
     * @return a list of items matching the specified element type
     */
    public Item[][] filterElements(Item.ElementType elementType) {
        Item[][] filteredElements = new Item[7][4];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                if (items[i][j] != null && items[i][j].getElementType().equals(elementType)) {
                    filteredElements[i][j] = items[i][j];
                }
            }
        }
        return filteredElements;
    }

    public Item getItem(int i, int j) {
        return items[i][j];
    }

    public void setItem(int i, int j, Item item) {
        items[i][j] = item;
    }
}

