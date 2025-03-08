package challenge.itau.challenge_itau.model;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transaction {

    private double value;
    private OffsetDateTime hourDate;
}
