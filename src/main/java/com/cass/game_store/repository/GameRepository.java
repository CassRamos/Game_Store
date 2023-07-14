package com.cass.game_store.repository;

import com.cass.game_store.entities.Game;
import com.cass.game_store.projections.GameShortProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.image_url AS imageUrl,
            tb_game.short_description AS shortDescription, tb_belonging.position
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listId
            ORDER BY tb_belonging.position
            	""")
    List<GameShortProjection> searchByList(Long listId); //listId represents a parameter responsible for passing the id to query interacting directly with the interface
}
