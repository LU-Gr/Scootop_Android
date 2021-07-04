package fr.scootop.app.notification;

import androidx.annotation.Nullable;

public final class DeeplinkFactory
{
    enum Type
    {
        SHORTLIST
    }

    private final String SCHEME = "scootop://";
    private final String INDEX = "index";

    private final String PAGE_SHORTLIST = "shortlist";

    public DeeplinkFactory()
    {

    }

    @Nullable
    public String getLink(Type type)
    {
        if (Type.SHORTLIST == type) {
            return getShortlistLink();
        }
        return null;
    }

    private String getShortlistLink()
    {
        return SCHEME + INDEX + "?page=" + PAGE_SHORTLIST;
    }
}
