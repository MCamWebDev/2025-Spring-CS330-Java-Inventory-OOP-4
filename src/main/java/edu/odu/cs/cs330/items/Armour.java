package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable implements Item
{
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %s%n",
        "  Def: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n",
        "  Emt: %s%n"
    );

    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour()
    {
        super();

        this.name = "[Placeholder]";
        this.defense = 0;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement getDefense()
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();
        cpy.setName(this.getName());
        cpy.setDefense(defense);
        cpy.setDurability(this.getDurability());
        cpy.setElement(this.getElement());
        cpy.setMaterial(this.getMaterial());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier,
     * modifierLevel, element, and defense.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        if (!this.getName().equals(rhsItem.getName())) {return false;}
        if (!this.getMaterial().equals(rhsItem.getMaterial())) {return false;}
        if (!this.getModifier().equals(rhsItem.getModifier())) {return false;}
        if (this.getModifierLevel() != rhsItem.getModifierLevel()) {return false;}
        if (!this.getElement().equals(rhsItem.getElement())) {return false;}
        if (this.getDefense() != rhsItem.getDefense()) {return false;}

        return true;
    }

    /**
     * Compute hashCode based on name, material, modifier, modifierLevel,
     * element, and defense.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(
            this.getName(),
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel(),
            this.getElement(),
            this.getDefense()
        );
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        //return "Use the provided format string";
        StringBuilder strBld = new StringBuilder();
        strBld.append(String.format("  Nme: %s\n", this.getName()));
        strBld.append(String.format("  Dur: %d\n", this.getDurability()));
        strBld.append(String.format("  Def: %d\n", this.getDefense()));
        strBld.append(String.format("  Mtl: %s\n", this.getMaterial()));
        strBld.append(String.format("  Mdr: %s (Lvl %d)\n", this.getModifier(), this.getModifierLevel()));
        strBld.append(String.format("  Emt: %s\n", this.getElement()));

        return strBld.toString();
    }
}




