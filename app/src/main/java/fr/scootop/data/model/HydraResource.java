package fr.scootop.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ludovicriviere on 12/02/2018.
 */
public class HydraResource
{
    @Expose
    @SerializedName("@id")
    public String iri;

    public HydraResource()
    {

    }
}
