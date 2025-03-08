package challenge.itau.challenge_itau.dto;

import java.util.DoubleSummaryStatistics;

import lombok.Getter;

@Getter
public class StatisticsResponseDTO {

    private long count;
    private double sum;
    private double avg;
    private double max;
    private double min;

    public StatisticsResponseDTO(DoubleSummaryStatistics statistics) {

        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.max = statistics.getMax();
        this.min = statistics.getMin();
    }
}
