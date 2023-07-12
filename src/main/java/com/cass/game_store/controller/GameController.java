package com.cass.game_store.controller;

import com.cass.game_store.dtos.GameDto;
import com.cass.game_store.dtos.GameShortDto;
import com.cass.game_store.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<GameShortDto> findAll() {
        return service.findAllGames();
    }

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable Long id) {
        return service.findById(id);
    }


}
