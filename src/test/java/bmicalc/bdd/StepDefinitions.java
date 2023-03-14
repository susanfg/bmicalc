package bmicalc.bdd;

import org.junit.jupiter.api.Assertions;

import bmicalc.BMICalcImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private BMICalcImpl c;
	private double weight;
	private double height;
	private boolean raiseException;
	private double bmi;
	private final double epsilon = 0.000001;
	private String category;
	@Before
	public void initialization() {
		c = null;
		weight = 0;
		raiseException = false;
		height = 0;
	}

	@Given("I have a bmi calculator")
	public void i_have_a_bmi_calculator() {
		c = new BMICalcImpl();
	}

	@When("I input a weight equal to {double}")
	public void i_input_a_weight_equal_to(Double int1) {
		weight = int1;
	}

	@When("I input a height equal to {double}")
	public void i_input_a_height_equal_to(Double double1) {
		height = double1;
	}

	@When("The system calculates the bmi")
	public void the_system_calculates_the_bmi() {
		bmi = c.bmi(weight, height);
	}

	@Then("The calculator returns {double}")
	public void the_calculator_returns(Double double1) {
		Assertions.assertEquals(double1, bmi, epsilon);
	}

	@When("I input an invalid weight equal to {double}")
	public void i_input_an_invalid_weight_equal_to(Double double1) {
		weight = double1;
	}

	@When("I input an invalid height equal to {double}")
	public void i_input_an_invalid_height_equal_to(Double double1) {
		height = double1;
	}

	@When("I calculate the bmi of an invalid value")
	public void i_calculate_the_bmi_of_an_invalid_value() {
		try {
			bmi = c.bmi(weight, height);
		} catch (RuntimeException e) {
			raiseException = true;
		}
	}

	@Then("The calculator throws an exception")
	public void the_calculator_throws_an_exception() {
		Assertions.assertTrue(raiseException);
	}
	// Category

	@Then("The system determines the category")
	public void the_system_determines_the_category() {
	  category = c.category(bmi);
	}
	@Then("returns the category {string}")
	public void returns_the_category(String string) {
		Assertions.assertEquals(string, category);
	}
	
}
