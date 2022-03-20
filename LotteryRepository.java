package org.example.JLottery_winner.repository;

import org.example.JLottery_winner.model.Lottery;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryRepository extends PagingAndSortingRepository<Lottery, Long> {



}
