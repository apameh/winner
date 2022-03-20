package org.example.JLottery_winner.service;

import org.example.JLottery_winner.model.Winner;
import org.example.JLottery_winner.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinnerServiceImpl implements IWinnerService {

    private final WinnerRepository winnerRepository;

    @Autowired
    public WinnerServiceImpl(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }


    @Override
    public Winner save(Winner winner) {
        return winnerRepository.save(winner);
    }

    @Override
    public Winner getById(Long id) {
        return winnerRepository.findById(id).get();
    }

    @Override
    public List<Winner> getAll() {
        return (List<Winner>) winnerRepository.findAll();
    }

    @Override
    public void delete(Winner winner) {
        winnerRepository.delete(winner);
    }
}
