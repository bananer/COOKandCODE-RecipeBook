package org.cookandcode.recepybook;

public class Recipe
{
    protected String name;
    protected String instructions;

    public Recipe(String name, String instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    public String getName() {
        return this.name;
    }

    public String getInstructions() {
        return this.instructions;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
