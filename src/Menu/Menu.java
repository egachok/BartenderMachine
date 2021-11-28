package Menu;

import Bartender.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu() {

        List<Cocktail> cocktails = getCocktails();

        BartenderMachine bartender = new BartenderMachine();
        Cocktail cocktailToCreate;

        while (true) {
            printSeparator();
            printSeparator();
            double alcoholValue = this.getAlcoholLevel();
            cocktailToCreate = this.chooseCocktail(cocktails, alcoholValue);
            System.out.println("Creation of the cocktail " + cocktailToCreate.getName());
            bartender.distributeCocktail(cocktailToCreate);
            System.out.println("Enjoy your Dink ! 🍹");
        }
    }

    private double getAlcoholLevel() {
        System.out.println("Please use the alcohol tester");
        System.out.println("[Press ENTER to blow]");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Math.floor((Math.random()*2) * 100) / 100;
    }

    private Cocktail chooseCocktail(List<Cocktail> cocktails, double gramsAlcoholPerLiter) {
        Scanner reader = new Scanner(System.in);

        int nbCocktail = 0;
        int nbSelected;
        List<Integer> cocktailsAbleToDrink = new ArrayList<Integer>();
        for (Cocktail cocktail : cocktails) {
            if(cocktail.isAbleToDrink(gramsAlcoholPerLiter)) {
                cocktailsAbleToDrink.add(nbCocktail);
            }
            nbCocktail++;
        }
        do {
            printMessageAlcoholTest(gramsAlcoholPerLiter);
            printSeparator();
            System.out.println("Please select the cokctail by the number: ");

            for (Integer nbCocktailAbleToDrink : cocktailsAbleToDrink) {
                System.out.println(
                        nbCocktailAbleToDrink + ": " +
                                cocktails.get(nbCocktailAbleToDrink).getName()
                );
            }
            nbSelected = reader.nextInt();
        }  while (isSelectionInvalid(nbSelected, cocktailsAbleToDrink));
        return cocktails.get(nbSelected);
    }

    private boolean isSelectionInvalid(int nbSelected, List<Integer> cocktails) {
        System.out.println(cocktails.indexOf(nbSelected));
        return cocktails.indexOf(nbSelected) < 0;
    }

    private List<Cocktail> getCocktails() {
        Drink cola = new Drink("Cola", DrinkType.Soft);
        Drink orangeJuice = new Drink("Orange Juice", DrinkType.Soft);
        Drink pineappleJuice = new Drink("Pineapple Juice", DrinkType.Soft);
        Drink applejuice = new Drink("Apple Juice", DrinkType.Soft);
        Drink lemonade = new Drink("Lemonade", DrinkType.Soft);
        Drink grenadineSyrup = new Drink("Grenadine Syrup", DrinkType.Soft);
        Drink starwberrySyrup = new Drink("Strawberry Syrup", DrinkType.Soft);

        Drink malibu = new Drink("Malibu", DrinkType.Medium);
        Drink beer = new Drink("Beer", DrinkType.Medium);
        Drink manzanna = new Drink("Manzanna", DrinkType.Medium);

        Drink vodka = new Drink("Vodka", DrinkType.Strong);
        Drink rhum = new Drink("Rhum", DrinkType.Strong);
        Drink chartreuse = new Drink("Chartreuse", DrinkType.Strong);
        Drink whisky = new Drink("Whisky", DrinkType.Strong);

        Cocktail whiskyCoca = new Cocktail("Whisky Coca", Arrays.asList(
                new Ingredient(whisky, 2),
                new Ingredient(cola, 8)
        ));

        Cocktail chartreuseExperience = new Cocktail("Chartreuse Experience", Arrays.asList(
                new Ingredient(chartreuse, 2),
                new Ingredient(vodka, 2),
                new Ingredient(orangeJuice, 10)
        ));

        Cocktail malibuSun = new Cocktail("Malibu Sun", Arrays.asList(
                new Ingredient(malibu, 5),
                new Ingredient(orangeJuice, 7)
        ));

        Cocktail malibuTropical= new Cocktail("Malibu Tropcial", Arrays.asList(
                new Ingredient(malibu, 4),
                new Ingredient(pineappleJuice, 12)
        ));

        Cocktail strawBeery= new Cocktail("StrawBeery", Arrays.asList(
                new Ingredient(beer, 10),
                new Ingredient(starwberrySyrup, 2)
        ));

        Cocktail appleMojito = new Cocktail("Apple Mojito", Arrays.asList(
                new Ingredient(manzanna, 6),
                new Ingredient(applejuice, 2),
                new Ingredient(lemonade, 6)
        ));

        Cocktail planterPunch = new Cocktail("Planter's punch", Arrays.asList(
                new Ingredient(rhum, 6),
                new Ingredient(orangeJuice, 4),
                new Ingredient(grenadineSyrup, 1)
        ));

        Cocktail tropicalJuice = new Cocktail("Tropical Juice", Arrays.asList(
                new Ingredient(grenadineSyrup, 2),
                new Ingredient(orangeJuice, 4),
                new Ingredient(pineappleJuice, 6)
        ));

        return Arrays.asList(
                whiskyCoca,
                chartreuseExperience,
                malibuSun,
                malibuTropical,
                strawBeery,
                appleMojito,
                planterPunch,
                tropicalJuice
        );
    }

    private void printMessageAlcoholTest(double gramsAlcoholPerLiter) {
        String message = "Choose one you want !";
        if(gramsAlcoholPerLiter > 0.5) message = "It's your last drink, let's slow down";
        if(gramsAlcoholPerLiter > 1) message = "Let's try our soft cocktails for the moment !";

        System.out.println("Your alcohol level is " + gramsAlcoholPerLiter + "g/L");
        System.out.println(message);
    }

    private void printSeparator() {
        System.out.println("-----------------------------");
    }
}