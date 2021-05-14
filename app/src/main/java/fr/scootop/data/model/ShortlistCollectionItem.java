package fr.scootop.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShortlistCollectionItem
{
    @Expose
    public Integer id;

    @Expose
    @SerializedName("shortlisted_user")
    public User shortlistedUser;

}
