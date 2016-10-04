package calculator.models;

import lombok.Data;

@Data
public class Result {

    private final Integer result;
    private final String from;

    public Result(Integer num1, Integer num2) {
        this.result = num1 + num2;
        this.from = "Java Spring service";
    }
}
