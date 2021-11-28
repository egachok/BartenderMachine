package ChainOfResponsibilityDistributor;

import Bartender.DrinkType;
import Bartender.Ingredient;

public abstract class AbstractDrinkDistributor {
    Bartender.DrinkType DrinkType;

    private AbstractDrinkDistributor nextDistributor;

    public void setNextDistributor(AbstractDrinkDistributor nextDistributor) {
        this.nextDistributor = nextDistributor;
    }

    public void addDrink(Ingredient ingredientToDistribute) {
        if(ingredientToDistribute.getDrink().getType() == this.DrinkType) {
            distributeDrink(ingredientToDistribute);
        }
        else if(this.nextDistributor != null) {
            nextDistributor.distributeDrink(ingredientToDistribute);
        }
    }

    abstract protected void distributeDrink(Ingredient ingredientToDistribute);
}
