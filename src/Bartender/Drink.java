package Bartender;

public class Drink {private String name;
    private DrinkType type;

    public Drink(String name, DrinkType type) {
        this.name = name;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public DrinkType getType() {
        return type;
    }

    public boolean isAbleToDrink(double gramsAlcoholPerLiter) {
        if (this.type == DrinkType.Medium) return gramsAlcoholPerLiter < 1;
        else if (this.type == DrinkType.Strong) return gramsAlcoholPerLiter < 0.5;
        return true;
    }
}