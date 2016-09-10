package calculator.models;

public class Result {

    private final Integer value;
	private final String from;

    public Result(Integer num1, Integer num2) {
        this.value = num1 + num2;
        this.from = "Spring service";
    }
    
    public Integer getValue() {
		return value;
	}

	public String getFrom() {
		return from;
	}
}
