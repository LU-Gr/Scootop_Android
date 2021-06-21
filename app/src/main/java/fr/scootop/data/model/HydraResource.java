package fr.scootop.data.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class HydraResource
{
    @Expose
    @SerializedName("@id")
    public String iri;
    public HydraResource()
    {
    }
}
