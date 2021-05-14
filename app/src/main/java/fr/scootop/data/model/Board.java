package fr.scootop.data.model;


import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Board
{
    @Expose
    @Nullable
    public Video video;

    @Expose
    public List<Player> players;
}
