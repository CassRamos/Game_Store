package com.cass.game_store.services;

import com.cass.game_store.dtos.GameListDto;
import com.cass.game_store.entities.GameList;
import com.cass.game_store.repository.GameListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository listRepository;

    public GameListService(GameListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        List<GameList> result = listRepository.findAll();
        return result.stream().map(GameListDto::new).toList();
    }
}
