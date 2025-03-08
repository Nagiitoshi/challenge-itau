package challenge.itau.challenge_itau.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class TransactionRequestDTO {

    @NotNull
    private double value;

    @NotNull
    private OffsetDateTime hourDate;

}
