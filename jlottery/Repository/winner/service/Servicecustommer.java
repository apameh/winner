package ir.mapsa.jlottery.Repository.winner.service;

package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.model.Customer;
import ir.mapsa.jlottery.jlottery.repository.RepositoryCustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceCustomer implements IServiceCustomer {

    private RepositoryCustomer repositoryCustomer;

    @Autowired
    public ServiceCustomer(RepositoryCustomer repositoryCustomer) {
        this.repositoryCustomer = repositoryCustomer;
    }

    @Override

    public Customer add(Customer customer) {
        return repositoryCustomer.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public List<Customer> getAll() throws ClassNotFoundException {

        List<Customer> all = (List<Customer>) repositoryCustomer.findAll();
        if (all.isEmpty()) {
            throw new ClassNotFoundException("requested list is empty");
        }
        return all;
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> optionalCustomer = repositoryCustomer.findById(customer.getId());

        if (optionalCustomer.isEmpty()) {
            throw new RuntimeException("The customer not found.");
        }

        Customer savedCustomer = optionalCustomer.get();

        savedCustomer.setId(customer.getId());
        savedCustomer.setName(customer.getName());
        savedCustomer.setPrize(customer.getPrize());
        savedCustomer.setScore(customer.getScore());

        return repositoryCustomer.save(savedCustomer);

    }

    @Override
    public void delete(Customer customer) {
        repositoryCustomer.delete(customer);
    }
}