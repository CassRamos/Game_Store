package com.cass.game_store.services;

import com.cass.game_store.dtos.GameDto;
import com.cass.game_store.dtos.GameShortDto;
import com.cass.game_store.entities.Game;
import com.cass.game_store.projections.GameShortProjection;
import com.cass.game_store.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }


    @Transactional(readOnly = true)
    public List<GameShortDto> findAllGames() {
        List<Game> result = repository.findAll();
        return result.stream().map(GameShortDto::new).toList(); //method reference replaced lambda function
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        Game result = repository.findById(id).get();
        return new GameDto(result);
    }

    @Transactional(readOnly = true)
    public List<GameShortDto> findByList(Long listId) {
        List<GameShortProjection> result = repository.searchByList(listId);
        return result.stream().map(GameShortDto::new).toList();
    }

}
