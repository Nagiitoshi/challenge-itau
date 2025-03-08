package challenge.itau.challenge_itau.Controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.itau.challenge_itau.dto.StatisticsResponseDTO;
import challenge.itau.challenge_itau.service.TransactionService;

@RestController
@RequestMapping("/estatistica")
public class StatictsController {

    private final TransactionService transactionService;

    public StatictsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponseDTO> getStatistics() {
        DoubleSummaryStatistics statistics = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsResponseDTO(statistics));
    }
}
