package com.example.calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

public class CalculatorStepdefs {
    private double firstNumber;
    private double secondNumber;
    private String operator;
    private double result;

    @Given("the first number is {double}")
    public void theFirstNumberIs(double number) {
        this.firstNumber = number;
    }

    @Given("the second number is {double}")
    public void theSecondNumberIs(double number) {
        this.secondNumber = number;
    }

    @When("the operator is \"{word}\"")
    public void theOperatorIs(String operator) {
        this.operator = operator;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    result = Double.POSITIVE_INFINITY;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
        }
    }

    @Then("the result should be {double}")
    public void theResultShouldBe(double expectedResult) {
        assertEquals(expectedResult, result, 0.001);
    }

    @Then("the result should be Infinity")
    public void theResultShouldBeInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0);
    }
}