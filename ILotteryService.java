package org.example.JLottery_winner.service;

import org.example.JLottery_winner.model.Lottery;

import java.util.List;

public interface ILotteryService {


    Lottery save(Lottery lottery);

    Lottery getById(Long id);

    List<Lottery> getAll();

    void delete(Lottery lottery);

}
