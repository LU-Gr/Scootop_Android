package fr.scootop.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by ludovicriviere on 13/02/2018.
 */
public class ShortlistItem
{
    @Expose
    public Integer id;

    @Expose
    @SerializedName(value = "shortlistedUser", alternate = "shortlisted_user")
    public String shortlistedUser;

    @Expose
    @SerializedName(value = "created_at")
    public Date createdAt;
}
