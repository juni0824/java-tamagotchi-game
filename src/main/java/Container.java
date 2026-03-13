package com.example;

public interface Container{
    
    String getName();
    void addItem(Item item);
    void removeItem(Item item);
    Item[][] filterElements(Item.ElementType elementType);
    Item[][] filterItem(Item.ItemType type);
}
