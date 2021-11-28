package ChainOfResponsibilityDistributor;

import Bartender.Ingredient;

public class MediumDrinkDistributor extends AbstractDrinkDistributor {

    public void MediumDistributor() {
        this.DrinkType = DrinkType.Medium;
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