package com.cass.game_store.dtos;

import com.cass.game_store.entities.Game;
import com.cass.game_store.projections.GameShortProjection;

public class GameShortDto {

    private Long id;
    private String title;
    private Integer year;
    private String imageUrl;
    private String shortDescription;

    public GameShortDto() {
    }

    public GameShortDto(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imageUrl = entity.getImageUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameShortDto(GameShortProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imageUrl = projection.getImageUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
