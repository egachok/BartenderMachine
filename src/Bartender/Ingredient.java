package Bartender;

public class Ingredient {

    private Drink drink;
    private double quantity;

    public Ingredient(Drink drink, double quantity) {
        if(drink == null) throw new IllegalArgumentException("Invalid drink");
        if(quantity < 0) throw new IllegalArgumentException("Invalid quantity");
        this.drink = drink;
        this.quantity = quantity;
    }

    public Drink getDrink() {
        return this.drink;
    }

    public double getQuantity() {
        return this.quantity;
    }
}
