package ir.mapsa.jlottery.Repository.winner.service;
package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.model.Customer;
import ir.mapsa.jlottery.jlottery.model.winner;
import ir.mapsa.jlottery.jlottery.repository.RepositoryCustomer;
import ir.mapsa.jlottery.jlottery.repository.Repositorywinner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicePrize implements IService winner {

    private RepositoryPrize repositorywinner;

    @Autowired
    public Service winner(Repository winner repository winner) {
        this.repository winner = repository winner;
    }

    @Override
    public winner add( winner  winner) {
        return repository winner.save(winner);
    }

    @Override
    public List<winner> getAll() {
        return    (List<winner>) repositorywinner.findAll();

    }

    @Override
    public winner update(Winner winner) {
        Optional<winner> optional winner= repository winner.findById(winner.getId());

        if (optional winner.isEmpty()) {
            throw new RuntimeException("The winner not found.");
        }

       winner saved winner = optional winner.get();

        saved winner.setId( winner.getId());
        saved winner.set winnerName(winner.getwinnerName());

        return repository winner.save(saved);

    }

    @Override
    public void delete(Winner winner) {

        repositoryPrize.delete winner);
    }

