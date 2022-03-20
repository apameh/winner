package org.example.JLottery_winner.repository;

import org.example.JLottery_winner.model.Winner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WinnerRepository extends PagingAndSortingRepository<Winner, Long> {

}
