package com.example;

import java.util.ArrayList;

/**
 * Interface for a Pet class representing the pet for a virtual pet game.
 * 
 * @version 1.4
 * @author Jane Zhang
 * @see Blorbo
 * @see Blonk
 * @see Bouba
 */
public interface Pet {
    
    enum ElementType {FIRE, WATER, EARTH}

    enum State {NORMAL, ASLEEP, ANGRY, HUNGRY, DEAD}

    // Gameplay commands

    /**
     * This method puts the pet to sleep. The pet sleeps until it reaches maximum sleep.
     */
    void goToBed();

    /**
     * This method first prompts the user to select a food item from their inventory, and then feeds the pet. Inventory
     * is represented by the {@link Inventory} class. Items are of the {@link Item} class. Selector is implemented by
     * the GUI.
     * Effects are doubled if a preferred food is selected, and the pet is hurt if a restricted food is selected.
     *
     * @param inventory The player's inventory.
     * @param selector An item selector used to select a food from the player's inventory.
     * @see Inventory
     * @see Item
     */
    void feed(Inventory inventory, Item item);

    /**
     * This methods restores the pet's health to maximum for a fee of 100 money, taken from the player's inventory
     * represented by the {@link Inventory} class.
     * It DOES NOT check if the player has enough money, and will subtract into the negatives if improperly called.
     * Money check will take place in the {@link FIXME} class.
     *
     * @param inventory The player's inventory.
     * @see Inventory
     * @see Item
     * @see FIXME
     */
    void takeToVet(Inventory inventory);

    /**
     * This method restores the pet's health by a set amount and decreases its sleep and fullness. It goes on cooldown
     * upon execution. Cooldown checks take place in the {@link FIXME} class.
     *
     * @see FIXME
     */
    void exercise(Inventory inventory);

    /**
     * This method first prompts the player to select a toy from their inventory, and then increases the pet's happiness.
     * Inventory is represented by the {@link Inventory} class. Items are of the {@link Item} class. The selector is
     * implemented by the GUI.
     * Effect is doubled if a preferred toy is selected, based on ElementType. This command goes on cooldown upon
     * execution. Cooldown checks take place in the {@link FIXME} class.
     *
     * @param inventory The player's inventory.
     * @param selector An item selector used to select a toy from the player's inventory.
     * @see Inventory
     * @see Item
     * @see FIXME
     */
    void play(Inventory inventory, Item item);

    /**
     * This method first prompts the player to select a gift from their inventory, and then increases the pet's happiness.
     * Inventory is represented by the {@link Inventory} class. Items are of the {@link Item} class. The selector is
     * implemented by the GUI.
     * Effect is doubled if a preferred gift is selected, based on ElementType.
     *
     * @param inventory The player's inventory.
     * @param selector An item selector used to select a gift from the player's inventory.
     * @see Inventory
     * @see Item
     */
    void giveGift(Inventory inventory, Item item);

    /**
     * This method gives the player money. Money is stored in the {@link Inventory} class.
     * @param inventory The player's inventory.
     * @see Inventory
     */
    void pet(Inventory inventory);

    // Getters
    /**
     * Getter for the pet's current health.
     *
     * @return The pet's current health.
     */
    int getHealth();

    /**
     * Getter for the pet's current sleep.
     *
     * @return The pet's current sleep.
     */
    int getSleep();

    /**
     * Getter for the pet's current happiness.
     *
     * @return The pet's current happiness.
     */
    int getHappiness();

    /**
     * Getter for the pet's current fullness.
     *
     * @return The pet's current fullness.
     */
    int getFullness();

    /**
     * Getter for the pet's maximum health.
     *
     * @return The pet's maximum health.
     */
    int getMaxHealth();

    /**
     * Getter for the pet's maximum sleep.
     *
     * @return The pet's maximum sleep.
     */
    int getMaxSleep();

    /**
     * Getter for the pet's maximum happiness.
     *
     * @return The pet's maximum happiness.
     */
    int getMaxHappiness();

    /**
     * Getter for the pet's maximum fullness.
     *
     * @return The pet's maximum fullness.
     */
    int getMaxFullness();

    /**
     * Getter for the pet's current exp.
     *
     * @return The pet's current exp.
     */
    int getEXP();

    /**
     * Getter for the pet's current level.
     *
     * @return The pet's current level.
     */
    int getLevel();

    /**
     * Getter for the pet's type.
     *
     * @return The pet's type.
     */
    ElementType getType();

    /**
     * Getter for the pet's states (ex. DEAD, ANGRY, HUNGRY).
     * The pet may be in multiple states concurrently.
     *
     * @return A list of the pet's current states.
     */
    ArrayList<State> getState();

    /**
     * Getter for the player's current score.
     *
     * @return The player's score.
     */
    int getScore();

    /**
     * Setter for the pet's name.
     * @param newName The new name of the pet.
     */
    void setName(String newName);

    /**
     * Getter for the pet's name.
     * @return The pet's name.
     */
    String getName();

    /**
     * Getter for the pet's current sprite.
     * @return The pet's current sprite, as a filename.
     */
    String getCurrentSprite();

    /**
     * Getter for the pet's vet fee.
     * @return The pet's vet fee.
     */
    int getVetFee();

    // State checkers (angry, hungry, asleep, dead)
    /**
     * Checks if the pet is dead.
     *
     * @return True if the pet's health is 0, false otherwise.
     */
    boolean checkDead();

    /**
     * Checks if the pet is asleep.
     *
     * @return True if the pet's sleep is 0, false otherwise.
     */
    boolean checkAsleep();

    /**
     * Checks if the pet is hungry.
     *
     * @return True if the pet's fullness is 0, false otherwise.
     */
    boolean checkHungry();

    /**
     * Checks if the pet is angry.
     *
     * @return True if the pet's happiness is 0, false otherwise.
     */
    boolean checkAngry();

    // Passive update functions
    // Order of priority - Dead > Asleep > Angry > Hungry
    /**
     * Updates the pet's statistics according to preset stat decrease rules.
     * The pet's fullness decreases by 3 every update. Other stats except for health decrease by 1.
     * The pet's health will decrease by 1 every update if fullness is 0.
     * If sleep reaches 0, the pet's health will decrease by 10 once.
     */
    void updateStats(Inventory inventory);

    /**
     * Updates the pet's sprites based on its current states.
     * This function uses default sprites.
     */
    void updateSprite();

    /**
     * Update the pet's sprites based on its current states.
     * This function uses alternative sprites.
     */
    void updateSpriteA();

    /**
     * Sets the pet's sprite to "happy".
     * Used for reactions to player action.
     */
    void happy();

    // Revive Pet function
    /**
     * This method sets all the pet stats to maximum, and resets score to 0. Used to revive a dead the pet.
     */
    void revive();
}