package EffectiveJava;

import static EffectiveJava.Pizza.Topping.MUSHROOM;

public class Test {
    public static void main(String[] args) {
        Calzone calzone = (Calzone) new Calzone.Builder().sauceInside().addTopping(Pizza.Topping.HAM).addTopping(MUSHROOM).build();

        System.out.println(calzone.toppings);
        System.out.println(calzone.getSauce());

    }
}
