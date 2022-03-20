package org.example.JLottery_winner.service;

import org.example.JLottery_winner.model.Winner;

import java.util.List;

public interface IWinnerService {

    Winner save(Winner winner);

    Winner getById(Long id);

    List<Winner> getAll();

    void delete(Winner winner);

}
