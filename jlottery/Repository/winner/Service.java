package ir.mapsa.jlottery.Repository.winner;

package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.model.Customer;
import ir.mapsa.jlottery.jlottery.model.winner;
import ir.mapsa.jlottery.jlottery.repository.RepositoryCustomer;
import ir.mapsa.jlottery.jlottery.repository.Repositorywinner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicePrize implements IServicewinner {

    private RepositoryPrize repositoryPrize;

    @Autowired
    public ServicePrize(RepositoryPrize repositoryPrize) {
        this.repositoryPrize = repositoryPrize;
    }

    @Override
    public winner add(winner winner) {
        return repositoryPrize.save(winner);
    }

    @Override
    public List<winner> getAll() {
        return    (List<winner>) repositoryPrize.findAll();

    }

    @Override
    public winner update(winner prize) {
        Optional<winner> optionalPrize = repositoryPrize.findById(prize.getId());

        if (optional winner.isEmpty()) {
            throw new RuntimeException("The winner not found.");
        }

       winner savedPrize = optionalPrize.get();

        saved winner.setId(winner.getId());
        saved winner.setPrizeName(winner.get winnerName());

        return repository winner.save(saved winner);

    }

    @Override
    public void delete(winner winner) {

        repositorywinner.delete(winner);
    }
