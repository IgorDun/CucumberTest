package ru.dexsys;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "C:\\Users\\Igor\\IdeaProjects\\PetStore\\CucumberTest\\src\\test\\resources\\coffee_machine_test.features"
        },
        glue = {
                "ru.dexsys.steps"
        }
)
public class AppTest{
}
