package fr.scootop.data.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


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
