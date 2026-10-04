package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable {
    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with an empty name, zero durability, zero defense,
     * blank material, no modifier a zero modifier level, and a blank element.
     */
    public Armour()
    {
        super();
        super.stackable = false;
        super.name = "";
        this.defense = 0;
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        super();

        //Armour copy = (Armour) src.clone();
        super.stackable = false;
        super.name = src.getName();
        super.durability = src.getDurability();
        super.material = src.getMaterial();
        super.modifier = src.getModifier();
        super.modifierLevel = src.getModifierLevel();
        super.element = src.getElement();
        this.defense = src.getDefense();

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
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name    = snr.next();

        // Complete this function.
        super.material = snr.next();
        super.durability = snr.nextInt();
        this.defense = snr.nextInt();
        super.modifier = snr.next();
        super.modifierLevel = snr.nextInt();
        super.element = snr.next();
        

    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();
        cpy.setName(this.name);
        cpy.setDefense(this.defense);
        cpy.setDurability(this.durability);
        cpy.setElement(this.element);
        cpy.setMaterial(this.material);
        cpy.setModifier(this.modifier);
        cpy.setModifierLevel(this.modifierLevel);
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier, and
     * element.
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

         if(rhsItem.getMaterial() != this.material)
            return false;
         if(rhsItem.getModifier() != this.modifier)
            return false;
         if(rhsItem.getElement() != this.element)
            return false;

        if(rhsItem.getName() != this.name)
            return false;

        return true;
    }

    /**
     * Generate a hash code by adding the name, material, modifier, and element
     * hash codes.
     */
    @Override
    public int hashCode()
    {
        return name.hashCode() + material.hashCode() + modifier.hashCode() + element.hashCode();
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {

        // Complete this function... treat the return as a hint.
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Dur: %d", super.getDurability()),
            String.format("  Def: %d", this.getDefense()),
            String.format("  Mtl: %s", super.getMaterial()),
            String.format("  Mdr: %s (Lvl %d)", super.getModifier(), super.getModifierLevel()),
            String.format("  Emt: %s", super.getElement()),
            ""
        );
    }
}




