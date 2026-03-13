package com.example;

public class CurrentState {
    private static CurrentState instance;
    private int saveFile;
    private Pet pet;
    private static Inventory inventory;
    private String lastScene;
    private Store store;
    private Item lastItem;

    private CurrentState() {
    }

    public static CurrentState getInstance() {
        if (instance == null) {
            instance = new CurrentState();
        }
        return instance;
    }

    public void setSaveFile(int save) {
        this.saveFile = save;
    }

    public int getSaveFile() {
        return saveFile;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setInventory(Inventory userInventory) {
        inventory = userInventory;
    }

    public void setMoney(int Money) {
        inventory.setMoney(Money);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void lastScene(String scene) {
        lastScene = scene;
    }

    public String returnScene() {
        return lastScene;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setLastItem(Item item) {
        lastItem = item;
    }

    public Item getLastItem() {
        return lastItem;
    }

}
