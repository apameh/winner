package org.example.JLottery_winner.controller;

import org.example.JLottery_winner.model.Lottery;
import org.example.JLottery_winner.service.ILotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    private final ILotteryService lotteryService;

    @Autowired
    public LotteryController(ILotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @PostMapping("/")
    public ResponseEntity<Lottery> save(@RequestBody Lottery lottery) {
        Lottery savedLottery = lotteryService.save(lottery);
        return ResponseEntity.ok(savedLottery);
    }

    @GetMapping("/")
    public ResponseEntity<List<Lottery>> getAll() {
        List<Lottery> lotteries = lotteryService.getAll();
        return ResponseEntity.ok(lotteries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lottery> getById(@PathVariable long id) {
        Lottery lottery = lotteryService.getById(id);
        return ResponseEntity.ok(lottery);
    }

    @PostMapping("/")
    public ResponseEntity<Void> delete(@RequestBody Lottery lottery) {
        lotteryService.delete(lottery);
        return ResponseEntity.ok().build();
    }


}
