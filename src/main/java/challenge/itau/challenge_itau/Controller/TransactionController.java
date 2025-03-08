package challenge.itau.challenge_itau.Controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.itau.challenge_itau.dto.TransactionRequestDTO;
import challenge.itau.challenge_itau.model.Transaction;
import challenge.itau.challenge_itau.service.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO) {

        if (transactionRequestDTO.getHourDate().isAfter(OffsetDateTime.now()) || transactionRequestDTO.getValue() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService
                .addTransaction(new Transaction(transactionRequestDTO.getValue(), transactionRequestDTO.getHourDate()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransaction() {
        transactionService.clearTransaction();
        return ResponseEntity.ok().build();
    }

}
