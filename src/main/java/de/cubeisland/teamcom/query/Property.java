package de.cubeisland.teamcom.query;

public interface Property
{
    /**
     * Returns the property name
     */
    String getName();

    /**
     * Returns true if the given value is allowed for this Property
     *
     * @param value the value to check
     */
    boolean accepts(Object value);
}
