package fr.scootop.data.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by ludovicriviere on 23/02/2018.
 */
public class Board
{
    @Expose
    @Nullable
    public Video video;

    @Expose
    public List<Player> players;
}
