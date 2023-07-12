package com.cass.game_store.controller;

import com.cass.game_store.dtos.GameListDto;
import com.cass.game_store.dtos.GameShortDto;
import com.cass.game_store.services.GameListService;
import com.cass.game_store.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "lists")
public class GameListController {

    private final GameListService listService;
    private final GameService gameService;

    public GameListController(GameListService listService, GameService gameService) {
        this.listService = listService;
        this.gameService = gameService;
    }


    @GetMapping
    public List<GameListDto> findAll() {
        return listService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameShortDto> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }
}
