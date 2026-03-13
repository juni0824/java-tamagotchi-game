package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Item class represnts an item in the game.
 * 
 * <br>
 * <br>
 * The item class repersents items that can be bought or stored
 * in the inventory. The item is made for a specific pet.<br>
 * <br>
 * 
 * @version 1.0
 * @author Kishore Piratheepan
 * 
 */

public class Item {

    /**
     * Repersents the type of an item.
     */
    public enum ItemType {
        FOOD, TOY, GIFT;
    }

    /**
     * Repersents the element type of an item.
     */
    public enum ElementType {
        FIRE, WATER, EARTH;
    }

    private String name;
    private int effectValue;
    private int negativeEffectValue;
    private int price;
    private String sprite;
    private String description;
    private ElementType elementType;
    private ItemType type;
    private int inventoryAmount;
    private int storeAmount;

    /**
     * Constructor that creates a new item object.
     * 
     * @param name                name of the item
     * @param effectValue         effect value of the item
     * @param price               price of the item
     * @param sprite              sprite of the item
     * @param description         description of the item
     * @param type                type of the item
     * @param amount              amount of the item
     * @param elementType         element type of the item
     * @param negativeEffectValue negative effect value of the item
     * @param inventoryAmount     amount of the item in the inventory
     * @param storeAmount         amount of the item in the store
     */
    public Item(String name, int effectValue, int price, String sprite, String description, ItemType type,
            int storeAmount, int inventoryAmount, ElementType elementType, int negativeEffectValue) {
        this.name = name;
        this.effectValue = effectValue;
        this.price = price;
        this.description = description;
        this.type = type;
        this.sprite = sprite;
        this.elementType = elementType;
        this.negativeEffectValue = negativeEffectValue;
        this.inventoryAmount = inventoryAmount;
        this.storeAmount = storeAmount;
    }

    /**
     * Returns the name of the item
     * 
     * @return name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the effect value of the item
     * 
     * @return effect value of the item
     */
    public int getEffectValue() {
        return effectValue;
    }

    /**
     * Returns the price of the item
     * 
     * @return price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the sprite of the item
     * 
     * @return sprite file location
     */
    public String getSprite() {
        return sprite;
    }

    /**
     * Returns the description of the item
     * 
     * @return description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the type of the item
     * 
     * @return type of the item
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Returns the amount of the items in the inventory
     * 
     * @return amount of items in the inventory
     */
    public int getInventoryAmount() {
        return inventoryAmount;
    }

    /**
     * Returns the amount of the items in the store
     * 
     * @return amount of items in the store
     */
    public int getStoreAmount() {
        return storeAmount;
    }

    /**
     * Returns the element type of the item
     * 
     * @return element type of the item
     */
    public ElementType getElementType() {
        return elementType;
    }

    /**
     * Returns the negative effect value of the item
     * 
     * @return negative effect value of the item
     */
    public int getNegativeEffectValue() {
        return negativeEffectValue;
    }

    /**
     * Sets the amount of the item in the inventory
     * 
     * @param amount amount of the item in the inventory
     */
    public void setInventoryAmount(int amount) {
        this.inventoryAmount = amount;
    }

    /**
     * Sets the amount of the item in the store
     * 
     * @param amount amount of the item in the store
     */
    public void setStoreAmount(int amount) {
        this.storeAmount = amount;
    }

}
