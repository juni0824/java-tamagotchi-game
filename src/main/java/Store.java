package com.example;

import java.util.List;

/**
 * The Store class represents a store that implements the Container interface.
 * It holds an array of items in stock and has a cooldown period.
 */
public class Store implements Container {
    
    private Item stock[][];
    private int cooldown = 720;
    private String name;

    public Store(String name, Item[][] stock) {
        
        this.name = name;
        this.stock = new Item[7][4];
        List<Item> itemList;

        if (CurrentState.getInstance().getSaveFile() == 0) {
            itemList = JSonReader.loadItemsInOrder("src/main/java/com/example/items.json");
        } else if (CurrentState.getInstance().getSaveFile() == 0) {
            itemList = JSonReader.loadItemsInOrder("src/main/java/com/example/items1.json");
        } else {
            itemList = JSonReader.loadItemsInOrder("src/main/java/com/example/items2.json");
        }
        
        int x = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                if (x < itemList.size()) {
                    this.stock[i][j] = itemList.get(x);
                    x++;
                } 
                else {
                    this.stock[i][j] = null;
                }
            }
        }
    }

    /**
     * Gets the stock of a specific item.
     *
     * @param item the item to check stock for
     * @return the amount of the item in stock
     */
    public int getStock(Item item) {
        for (int i = 0; i < stock.length; i++) {
            for (int j = 0; j < stock[i].length; j++) {
                if (stock[i][j].equals(item)) {
                    return stock[i][j].getStoreAmount();
                }
            }
        }
        return 0;
    }

    /**
     * Sets the stock of a specific item.
     *
     * @param item the item to set stock for
     * @param amount the amount of the item to set in stock
     */
    public void setStock(Item item, int amount) {
        // Implementation here
        for(int i = 0; i < stock.length; i++) {
            for(int j = 0; j < stock[i].length; j++) {
                if(stock[i][j].getName().equals(item.getName())) {
                    stock[i][j].setStoreAmount(amount);
                }
            }
        }
    }

    /**
     * Restocks the store.
     */
    public void reStock() {
        // Implementation here
        for(int i = 0; i < stock.length; i++) {
            for(int j = 0; j < stock[i].length; j++) {
                stock[i][j].setStoreAmount(10);
            }
        }
    }

    /**
     * Buys a specific amount of an item from the store.
     *
     * @param item the item to buy
     * @param amount the amount of the item to buy
     */
    public void buyItem(Item item, int amount) {
        // Implementation here
        for(int i = 0; i < stock.length; i++) {
            for(int j = 0; j < stock[i].length; j++) {
                if(stock[i][j].getName().equals(item.getName())) {
                    if(stock[i][j].getType().equals(Item.ItemType.FOOD)) {
                        if(stock[i][j] != null && stock[i][j].equals(item)) {
                            return;
                        }
                    }
                    else if(stock[i][j].getType().equals(Item.ItemType.TOY)) {
                        if(stock[i][j] != null && stock[i][j].equals(item)) {
                            if (stock[i][j].getStoreAmount() <= 0) {
                                stock[i][j] = null;
                            }
                            else{
                                stock[i][j].setStoreAmount(item.getStoreAmount() - 1);
                            }
                            return;
                        };
                    }
                    else if(stock[i][j].getType().equals(Item.ItemType.GIFT)) {
                        if(stock[i][j] != null && stock[i][j].equals(item)) {
                            if(item.getStoreAmount() <= 0){
                                item.setStoreAmount(item.getStoreAmount() + 10);
                            }
                            else{
                                stock[i][j].setStoreAmount(item.getStoreAmount() - 1);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets the name of the container.
     *
     * @return the name of the container
     */
    @Override
    public String getName() {
        // Implementation here
        return name;
    }

    public void addItem(Item item) {
        // Implementation here
        for(int i = 0; i < stock.length; i++) {
            for(int j = 0; j < stock[i].length; j++) {
                if(stock[i][j] == null) {
                    stock[i][j] = item;
                    return;
                }
            }
        }
    }

    public void removeItem(Item item) {
        if (item.getType() == Item.ItemType.FOOD) {
            for(int i = 0; i < stock.length; i++) {
                for(int j = 0; j < stock[i].length; j++) {
                    if(stock[i][j] != null && stock[i][j].equals(item)) {
                        return;
                    }
                }
            }
        } 
        else if (item.getType() == Item.ItemType.TOY) {
            for(int i = 0; i < stock.length; i++) {
                for(int j = 0; j < stock[i].length; j++) {
                    if(stock[i][j] != null && stock[i][j].equals(item)) {
                        stock[i][j].setStoreAmount(item.getStoreAmount() - 1);
                        if (stock[i][j].getStoreAmount() == 0) {
                            stock[i][j] = null;
                        }
                        return;
                    }
                }
            }
        } 
        else if (item.getType() == Item.ItemType.GIFT) {
            for(int i = 0; i < stock.length; i++) {
                for(int j = 0; j < stock[i].length; j++) {
                    if(stock[i][j] != null && stock[i][j].equals(item)) {
                        if(item.getStoreAmount() == 0){
                            item.setStoreAmount(item.getStoreAmount() + 10);
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
        Item[][] filteredItems = new Item[7][4];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                if (stock[i][j] != null && stock[i][j].getType().equals(type)) {
                    filteredItems[i][j] = stock[i][j];
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
                if (stock[i][j] != null && stock[i][j].getElementType().equals(elementType)) {
                    filteredElements[i][j] = stock[i][j];
                }
            }
        }
        return filteredElements;
    }

    /**
     * Sets the name of the inventory.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Item getItem(int i, int j) {
        return stock[i][j];
    }

    public void setItem(int i, int j, Item item) {
        stock[i][j] = item;
    }
}
