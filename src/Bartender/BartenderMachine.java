package Bartender;

import ChainOfResponsibilityDistributor.AbstractDrinkDistributor;
import ChainOfResponsibilityDistributor.MediumDrinkDistributor;
import ChainOfResponsibilityDistributor.SoftDrinkDistributor;
import ChainOfResponsibilityDistributor.StrongDrinkDistributor;

public class BartenderMachine {

    public void distributeCocktail(Cocktail cocktail) {
        for (Ingredient ingredient : cocktail.getIngredientList()) {
            this.distributeDrink(ingredient);
        }
    }

    private void distributeDrink(Ingredient ingredient) {
        getChainDistributor().addDrink(ingredient);
    }

    private static AbstractDrinkDistributor getChainDistributor() {
        AbstractDrinkDistributor softDrinkDistributor = new SoftDrinkDistributor();
        AbstractDrinkDistributor mediumDrinkDistributor = new MediumDrinkDistributor();
        AbstractDrinkDistributor strongDrinkDistributor = new StrongDrinkDistributor();

        softDrinkDistributor.setNextDistributor(mediumDrinkDistributor);
        mediumDrinkDistributor.setNextDistributor(strongDrinkDistributor);

        return softDrinkDistributor;
    }

}
