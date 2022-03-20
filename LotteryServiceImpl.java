package org.example.JLottery_winner.service;

import org.example.JLottery_winner.model.Lottery;
import org.example.JLottery_winner.repository.LotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryServiceImpl implements ILotteryService {

    private final LotteryRepository lotteryRepository;

    @Autowired
    public LotteryServiceImpl(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }


    @Override
    public Lottery save(Lottery lottery) {
        return lotteryRepository.save(lottery);
    }

    @Override
    public Lottery getById(Long id) {
        return lotteryRepository.findById(id).get();
    }

    @Override
    public List<Lottery> getAll() {
        return (List<Lottery>) lotteryRepository.findAll();
    }

    @Override
    public void delete(Lottery lottery) {
        lotteryRepository.delete(lottery);
    }
}
