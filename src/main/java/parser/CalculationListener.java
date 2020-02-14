package parser;

import grammars.CalculatorBaseListener;
import grammars.CalculatorParser;

import java.util.Stack;

import static java.lang.Math.pow;

public class CalculationListener extends CalculatorBaseListener {

    private Stack<Double> stack = new Stack<>();

    @Override
    public void exitNumber(CalculatorParser.NumberContext ctx) {
        Double number = Double.parseDouble(ctx.NUMBER().getText());
        this.stack.push(number);
    }

    @Override
    public void exitPower(CalculatorParser.PowerContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(pow(left, right));
    }

    @Override
    public void exitMultiplication(CalculatorParser.MultiplicationContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left * right);
    }

    @Override
    public void exitDivision(CalculatorParser.DivisionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left / right);
    }

    @Override
    public void exitAddition(CalculatorParser.AdditionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left + right);
    }

    @Override
    public void exitSubtraction(CalculatorParser.SubtractionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left - right);
    }

    public Double getResult() {
        return this.stack.pop();
    }
}
