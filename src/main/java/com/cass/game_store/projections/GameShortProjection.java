package com.cass.game_store.projections;

//this interface contains the custom methods for interacting in SQL queries present in the repository class
public interface GameShortProjection {
    Long getId();

    String getTitle();

    Integer getGameYear();

    String getImageUrl();

    String getShortDescription();

    Integer getPosition();
}
