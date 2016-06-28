package org.cookandcode.recepybook;

public class Recipe {
    protected String name;
    protected String instructions;

    public Recipe(String name, String instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return getName();
    }
}
