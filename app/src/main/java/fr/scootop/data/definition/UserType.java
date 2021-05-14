package fr.scootop.data.definition;


import androidx.annotation.Nullable;

public enum UserType
{
    Player("player"),
    Observer("observer"),
    Coach("coach");

    private String value;

    UserType(String value)
    {
        this.value = value;
    }

    @Nullable
    public static UserType from(String value)
    {
        if (UserType.Player.value.equalsIgnoreCase(value)) {
            return UserType.Player;
        } else if (UserType.Observer.value.equalsIgnoreCase(value)) {
            return UserType.Observer;
        } else if (UserType.Coach.value.equalsIgnoreCase(value)) {
            return UserType.Coach;
        }
        return null;
    }

    public String getValue()
    {
        return value;
    }
}
