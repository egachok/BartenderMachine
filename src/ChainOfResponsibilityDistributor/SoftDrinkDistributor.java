package ChainOfResponsibilityDistributor;

import Bartender.Ingredient;

public class SoftDrinkDistributor extends AbstractDrinkDistributor {

    public SoftDrinkDistributor() {
        this.DrinkType = DrinkType.Soft;
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