package org.cookandcode.recepybook;

public class Recipes {
    public static Recipe[] getRecipes() {
        Recipe[] list = new Recipe[5];
        list[0] = new Recipe("Apfelstrudel", "Beispiel Rezept Apfelstrudel\n\nGuten Appetit!");
        list[1] = new Recipe("Nudeln Quattro Formaggi", "Beispiel Rezept Vierkäsenudeln\n\nGuten Appetit!");
        list[2] = new Recipe("Butterbrot", "Beispiel Rezept Butterbrot\n\nGuten Appetit!");
        list[3] = new Recipe("Pizza Margaritha", "Beispiel Rezept Pizza\n\nGuten Appetit!");
        list[4] = new Recipe("Tiramisu", "Beispiel Rezept Tiramisu\n\nGuten Appetit!");
        return list;
    }
}
