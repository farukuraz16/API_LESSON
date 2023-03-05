package pojoDatas;

public class Homework12_startAndEndPojo {
    /*
     "expression":"after",
                            "amount":132000000
     */

private String expression;
private int amount;

    @Override
    public String toString() {
        return "{" +
                "expression='" + expression + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Homework12_startAndEndPojo(String expression, int amount) {
        this.expression = expression;
        this.amount = amount;
    }

    public Homework12_startAndEndPojo() {
    }
}
