package com.example.calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class CalculatorStepdefs {

    private final Calculator calculator = new Calculator();
    private double firstNumber;
    private double secondNumber;
    private double result;
    private Exception thrownException;

    @Given("the first number is {double}")
    public void the_first_number_is(double number) {
        this.firstNumber = number;
    }

    @Given("the second number is {double}")
    public void the_second_number_is(double number) {
        this.secondNumber = number;
    }

    @When("I perform the calculation with the \"{word}\" operator")
    public void i_perform_the_calculation_with_the_operator(String operator) {
        // We use a try-catch block to handle expected errors gracefully
        try {
            result = calculator.calculate(firstNumber, secondNumber, operator);
        } catch (IllegalArgumentException e) {
            thrownException = e;
        }
    }

    @Then("the result should be {double}")
    public void the_result_should_be(double expectedResult) {
        assertEquals(expectedResult, result, 0.001);
    }

    @Then("the result should be Infinity")
    public void the_result_should_be_infinity() {
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0);
    }

    @Then("the operation should fail with an error")
    public void the_operation_should_fail_with_an_error() {
        // Assert that an exception was indeed thrown
        assertNotNull("Expected an exception to be thrown", thrownException);
        // Assert that the exception is of the correct type
        assertTrue("Expected an IllegalArgumentException", thrownException instanceof IllegalArgumentException);
    }
}