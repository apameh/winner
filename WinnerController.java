package org.example.JLottery_winner.controller;

import org.example.JLottery_winner.model.Winner;
import org.example.JLottery_winner.service.IWinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/winner")
public class WinnerController {

    private final IWinnerService winnerService;

    @Autowired
    public WinnerController(IWinnerService winnerService) {
        this.winnerService = winnerService;
    }


    @PostMapping("/")
    public ResponseEntity<Winner> save(@RequestBody Winner winner) {
        Winner savedWinner = winnerService.save(winner);
        return ResponseEntity.ok(savedWinner);
    }

    @GetMapping("/")
    public ResponseEntity<List<Winner>> getAll() {
        List<Winner> winners = winnerService.getAll();
        return ResponseEntity.ok(winners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Winner> getById(@PathVariable long id) {
        Winner winner = winnerService.getById(id);
        return ResponseEntity.ok(winner);
    }

    @PostMapping("/")
    public ResponseEntity<Void> delete(@RequestBody Winner winner) {
        winnerService.delete(winner);
        return ResponseEntity.ok().build();
    }


}
