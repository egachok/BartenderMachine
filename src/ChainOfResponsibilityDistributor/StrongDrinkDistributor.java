package ChainOfResponsibilityDistributor;

import Bartender.Ingredient;

public class StrongDrinkDistributor extends AbstractDrinkDistributor {

    public StrongDrinkDistributor() {
        this.DrinkType = DrinkType.Strong;
    }

    protected void distributeDrink(Ingredient ingredientToDistribute) {
        System.out.println(
                "Bartender add " +
                        ingredientToDistribute.getQuantity() +
                        "mL of " +
                        ingredientToDistribute.getDrink().getName()
        );
    }
}