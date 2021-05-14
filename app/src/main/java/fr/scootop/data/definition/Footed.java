package fr.scootop.data.definition;

import androidx.annotation.Nullable;

public enum Footed
{
    Left("L"), Right("R");

    private String value;

    Footed(String value)
    {
        this.value = value;
    }

    @Nullable
    public static Footed from(String value)
    {
        if (Footed.Left.value.equalsIgnoreCase(value)) {
            return Footed.Left;
        } else if (Footed.Right.value.equalsIgnoreCase(value)) {
            return Footed.Right;
        }
        return null;
    }

    public String getValue()
    {
        return value;
    }
}
