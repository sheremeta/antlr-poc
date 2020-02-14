import grammars.CalculatorLexer;
import grammars.CalculatorParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.CalculationListener;

import static org.antlr.v4.runtime.CharStreams.fromString;

class Calculator {

    static double eval(String expression) {
        CalculatorLexer calculatorLexer = new CalculatorLexer(fromString(expression));
        CommonTokenStream tokenStream = new CommonTokenStream(calculatorLexer);

        CalculatorParser parser = new CalculatorParser(tokenStream);
        ParseTree tree = parser.start();

        CalculationListener calculator = new CalculationListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(calculator, tree);

        return calculator.getResult();
    }

}