package com.example;

import java.util.ArrayList;

/**
 * The Blonk class represents one of the three types of pets in the CS2212 group 88 Virtual Pet Project.
 * It implements the {@link Pet} interface.
 *
 * @version 1.4
 * @author Jane Zhang
 * @see Pet
 */
public class Blonk implements Pet {

    private final ElementType type = ElementType.EARTH;
    private final int vetFee = 200;
    private int maxHealth = 100;
    private int maxSleep = 150;
    private int maxFullness = 200;
    private int maxHappiness = 50;

    private int health;
    private int sleep;
    private int fullness;
    private int happiness;
    private ArrayList<State> state = new ArrayList<>();

    private int score;
    private final int baseExp = 40;
    private int exp;
    private int level;

    private String name;
    private String[] sprites = new String[]{"Flower_Girl_Neutral.png", "Flower_Girl_Neutral2.png",
                                            "Flower_Girl_Sleep.png", "Flower_Girl_Sleep2.png",
                                            "Flower_Girl_Mad.png", "Flower_Girl_Mad2.png",
                                            "Flower_Girl_Hungry.png", "Flower_Girl_Hungry2.png",
                                            "Flower_girl_Dead.png", "Flower_Girl_Happy.png"};
    private String currentSprite = "Flower_Girl_Neutral.png";

    /**
     * Constructor for a new file Blonk. To be used to start new games.
     */
    public Blonk() {
        this.name = "Blonk";
        this.health = maxHealth;
        this.sleep = maxSleep;
        this.fullness = maxFullness;
        this.happiness = maxHappiness;
        this.state.add(State.NORMAL);
        this.score = 0;
        this.exp = 0;
        this.level = 1;
    }

    /**
     * Constructor for a save file Blonk. To be used to load saved games.
     *
     * @param name The saved name of the save file Blonk.
     * @param health The saved health of the save file Blonk.
     * @param sleep The saved sleep of the save file Blonk.
     * @param fullness The saved fullness of the save file Blonk.
     * @param happiness The saved happiness of the save file Blonk.
     * @param state The saved states of the save file Blonk.
     * @param score The score of the save file.
     * @param exp The exp of the save file Blonk.
     * @param level The level of the save file Blonk.
     */
    public Blonk(String name, int health, int sleep, int fullness, int happiness,
                  ArrayList<State> state, int score, int exp, int level) {
        this.name = name;
        this.health = health;
        this.sleep = sleep;
        this.fullness = fullness;
        this.happiness = happiness;

        this.state = state;
        this.score = score;
        this.exp = exp;
        this.level = level;

        for (int i = 1; i <= level; ++i) {
            maxFullness += 2;
            if (i % 2 == 0) maxHealth += 3;
            else maxHappiness += 1;
        }

        updateSprite();
    }

    // Gameplay commands

    public void goToBed() {
        state.add(State.ASLEEP);
    }

    /**
     * {@inheritDoc}
     * Ex. Blonk's type is EARTH, so food of type EARTH is preferred and food of type FIRE is restricted.
     * @param inventory The player's inventory.
     * @param selector An item selector used to select a food from the player's inventory.
     */
    public void feed(Inventory inventory, Item food) {
        // Double effects for an element match
        if (food.getElementType().ordinal() == type.ordinal()) {
            increaseFullness(food.getEffectValue());
            addScoreEXP(food.getEffectValue(), food.getEffectValue(), inventory);
        }

        // Check modulus for if a food item will hurt the pet
        if ((food.getElementType().ordinal() + ElementType.values().length - type.ordinal()) % 3 == 1) {
            decreaseHealth(food.getNegativeEffectValue());
            decreaseHappiness(food.getNegativeEffectValue());
            addScoreEXP(-food.getNegativeEffectValue(), 0, inventory);
            inventory.removeItem(food);
            currentSprite = sprites[4];
        } else {
            // Default
            increaseFullness(food.getEffectValue());
            addScoreEXP(food.getEffectValue(), food.getEffectValue(), inventory);
            inventory.removeItem(food);
            happy();
        }
    }

    public void takeToVet(Inventory inventory) {
        health = maxHealth;
        inventory.setMoney(inventory.getMoney() - vetFee);
        happy();
    }

    public void exercise(Inventory inventory) {
        increaseHealth(30);
        decreaseSleep(15);
        decreaseFullness(15);

        addScoreEXP(30, 30, inventory);
        happy();
    }

    /**
     * {@inheritDoc}
     * Ex. Blonk's type is EARTH, so toys of type EARTH are preferred.
     * @param inventory The player's inventory.
     * @param selector An item selector used to select a toy from the player's inventory.
     */
    public void play(Inventory inventory, Item toy) {
        if (toy.getElementType().ordinal() == type.ordinal()) {
            increaseHappiness(toy.getEffectValue());
            addScoreEXP(toy.getEffectValue(), toy.getEffectValue(), inventory);
        }
        increaseHappiness(toy.getEffectValue());
        addScoreEXP(toy.getEffectValue(), toy.getEffectValue(), inventory);
        happy();
    }

    /**
     * {@inheritDoc}
     * Ex. Blonk is type EARTH, so gifts of type EARTH are preferred.
     * @param inventory The player's inventory.
     * @param selector An item selector used to select a gift from the player's inventory.
     */
    public void giveGift(Inventory inventory, Item gift) {
        if (gift.getElementType().ordinal() == type.ordinal()) {
            increaseHappiness(gift.getEffectValue());
            addScoreEXP(gift.getEffectValue(), gift.getEffectValue(), inventory);
        }
        increaseHappiness(gift.getEffectValue());
        addScoreEXP(gift.getEffectValue(), gift.getEffectValue(), inventory);
        inventory.removeItem(gift);
        happy();
    }

    public void pet(Inventory inventory) {
        inventory.setMoney(inventory.getMoney() + 1);
    }

    public void revive() {
        health = maxHealth;
        sleep = maxSleep;
        fullness = maxFullness;
        happiness = maxHappiness;
        state.clear();
        state.add(State.NORMAL);
        score = 0;
        updateSprite();
    }

    // Getters
    public int getHealth() {
        return this.health;
    }

    public int getSleep() {
        return this.sleep;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public int getFullness() {
        return this.fullness;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getMaxSleep() {
        return this.maxSleep;
    }

    public int getMaxHappiness() {
        return this.maxHappiness;
    }

    public int getMaxFullness() {
        return maxFullness;
    }

    public int getEXP() {
        return this.exp;
    }

    public int getLevel() {
        return this.level;
    }

    public ElementType getType() {
        return this.type;
    }

    public ArrayList<State> getState() {
        return this.state;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public String getCurrentSprite() {
        return this.currentSprite;
    }

    public int getVetFee() {
        return this.vetFee;
    }

    // State checkers
    public boolean checkDead() {
        return this.state.contains(State.DEAD);
    }

    public boolean checkAsleep() {
        return this.state.contains(State.ASLEEP);
    }

    public boolean checkHungry() {
        return this.state.contains(State.HUNGRY);
    }

    public boolean checkAngry() {
        return this.state.contains(State.ANGRY);
    }

    // Passive stat update function
    // Order of priority - Dead > Asleep > Angry > Hungry

    /**
     * {@inheritDoc}
     * Blonk's fullness decreases by 3 every update. Other stats except for health decrease by 1.
     * Blonk's health will decrease by 1 every update if fullness is 0.
     * If sleep reaches 0, Blonk's health will decrease by 15 once.
     */
    public void updateStats(Inventory inventory) {
        if (!checkDead()) {
            decreaseFullness(2);
            decreaseHappiness(1);
            if (!checkAsleep()) decreaseSleep(1);
            else increaseSleep(inventory);
        }
    }

    public void updateSprite() {
        if (checkDead()) currentSprite = sprites[8];
        else if (checkAsleep()) currentSprite = sprites[2];
        else if (checkAngry()) currentSprite = sprites[4];
        else if (checkHungry()) currentSprite = sprites[6];
        else currentSprite = sprites[0];
    }

    public void updateSpriteA() {
        if (checkDead()) currentSprite = sprites[8];
        else if (checkAsleep()) currentSprite = sprites[3];
        else if (checkAngry()) currentSprite = sprites[5];
        else if (checkHungry()) currentSprite = sprites[7];
        else currentSprite = sprites[1];
    }

    public void happy() {
        currentSprite = sprites[9];
    }

    // Name setter
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Decreases Blonk's health by a given amount and checks for new dead state.
     */
    private void decreaseHealth(int HPDecr) {
        if (!checkDead()) {
            health -= HPDecr;
            if (health <= 0) {
                health = 0;
                state.add(State.DEAD);
            }
        }
    }

    /**
     * Decreases Blonk's sleep by a given amount and checks for new asleep state.
     */
    private void decreaseSleep(int SLPDecr) {
        if (!checkAsleep()) {
            sleep -= SLPDecr;
            if (sleep <= 0) {
                sleep = 0;
                decreaseHealth(15);
                state.add(State.ASLEEP);
            }
        }
    }

    /**
     * Decreases Blonk's fullness by a given amount and checks for new hungry state.
     */
    private void decreaseFullness(int FULDecr) {
        if (!checkHungry()) {
            fullness -= FULDecr;
            if (fullness <= 0) {
                fullness = 0;
                state.add(State.HUNGRY);
            }
        } else decreaseHealth(2);
    }

    /**
     * Decreases Blonk's happiness by a given amount and checks for new angry state.
     */
    private void decreaseHappiness(int HAPDecr) {
        if (!checkAngry()) {
            happiness -= HAPDecr;
            if (happiness <= 0) {
                happiness = 0;
                state.add(State.ANGRY);
            }
        }
    }

    // Helpers

    /**
     * Selects an item from a subset of the inventory filtered by the appropriate item category. Inventory is
     * represented by the {@link Inventory} class, items by the {@link Item} and item selector is implemented by the GUI.
     *
     * @param inventory The player's inventory.
     * @param selector An item selector used to select an item from the player's inventory.
     * @param category The category with which to filter by (ItemType FOOD, GIFT, or TOY).
     * @return The selected item.
     * @see Inventory
     * @see Item
     */
    private Item selectItem(Inventory inventory, ItemSelector selector, Item.ItemType category) {
        Item[][] filteredInv = inventory.filterItem(category);
        return selector.selectItem(filteredInv);
    }

    /**
     * Increases health by a given amount.
     *
     * @param HPRestore The amount of health to restore.
     */
    private void increaseHealth(int HPRestore) {
        if (health + HPRestore > maxHealth) health = maxHealth;
        else health += HPRestore;
    }

    /**
     * Increases sleep by a set amount. Blonk regenerates sleep at 4/2 seconds when asleep.
     */
    private void increaseSleep(Inventory inventory) {
        if (checkAsleep()) {
            sleep += 3;
            if (sleep >= maxSleep) {
                sleep = maxSleep;
                state.remove(State.ASLEEP);
                addScoreEXP(5, 5, inventory);
            }
        }
    }

    /**
     * Increases fullness by a given amount.
     *
     * @param FULRestore The amount of fullness to restore.
     */
    private void increaseFullness(int FULRestore) {
        if (fullness + FULRestore > maxFullness) fullness = maxFullness;
        else fullness += FULRestore;

        if (checkHungry()) state.remove(State.HUNGRY);
    }

    /**
     * Increases happiness by a given amount.
     *
     * @param HAPRestore The amount of happiness to restore.
     */
    private void increaseHappiness(int HAPRestore) {
        if (happiness + HAPRestore > maxHappiness) happiness = maxHappiness;
        else happiness += HAPRestore;

        if (checkAngry()) state.remove(State.ANGRY);
    }

    /**
     * Adds score and experience points for user actions. Negative values can be used as a parameter to penalize bad
     * choices.
     *
     * @param score The score to be added.
     * @param EXP The amount of EXP to be added.
     * @param inventory The player's inventory, used when the pet levels up.
     * @see Blonk#levelUp(Inventory inventory);
     */
    private void addScoreEXP(int score, int EXP, Inventory inventory) {
        addScore(score);
        addEXP(EXP, inventory);
    }

    /**
     * Adds EXP for user actions.
     *
     * @param value The amount of EXP to be added.
     * @param inventory The player's inventory, used when the pet levels up.
     * @see Blonk#levelUp(Inventory inventory);
     */
    private void addEXP(int value, Inventory inventory) {
        exp += value * (2 * level);
        if (exp > baseExp * level) {
            levelUp(inventory);
        }
    }

    /**
     * Levels up the pet. Effects are as follows:
     * - On even levels, Blonk's maximum health increases by 5.
     * - On odd levels, Blonk's maximum happiness increases by 5.
     * - On all levels, Blonk's maximum fullness increases by 3 and money is rewarded to the player.
     */
    private void levelUp(Inventory inventory) {
        while (exp >= baseExp * level) {
            exp -= baseExp * level;
            addScore(baseExp);
            level += 1;

            inventory.setMoney(inventory.getMoney() + 5 * level);
            maxFullness += 2;
            if (level % 2 == 0) maxHealth += 3;
            else maxHappiness += 1;
        }
    }

    /**
     * Adds score to the player. Base score values are multiplied by level, as per the difficulty level of Blonk.
     *
     * @param score The score to be added.
     */
    private void addScore(int score) {
        this.score += score * 2 * level;
    }
}
