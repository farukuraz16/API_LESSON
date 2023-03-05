package pojoDatas;

public class Homework12_inConditionsPojo {
    /*
     "name":"temp",
                    "expression":"$gt",
                    "amount":299
     */

    private String name;
    private String expression;
    private int amount;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", expression='" + expression + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Homework12_inConditionsPojo(String name, String expression, int amount) {
        this.name = name;
        this.expression = expression;
        this.amount = amount;
    }

    public Homework12_inConditionsPojo() {
    }
}
