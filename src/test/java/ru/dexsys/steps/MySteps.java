package ru.dexsys.steps;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import ru.dexsys.CoffeeMachine;

import java.util.Map;

public class MySteps {
    private final CoffeeMachine coffeeMachine = new CoffeeMachine();

    @Дано("^Пользователь добавляет в кофемашину (\\d+) грамм зерён$")
    public void пользовательДобавляетВКофемашинуГраммЗерён(int coffeeSeeds) {
        coffeeMachine.addCoffeeSeeds(coffeeSeeds);
        System.out.println("Пользователь добавил " + coffeeSeeds + " грамм кофе");
    }

    @И("^Пользователь добавляет в кофемашину (\\d+) миллилитров$")
    public void пользовательДобавляетВКофемашинуМиллилитров(int water) {
        coffeeMachine.addWater(water);
        System.out.println("Пользователь добавил " + water + " миллилитров воды");
    }

    @Когда("^Пользователь делает кружку с кофе$")
    public void пользовательДелаетКружкуСКофе() {
        coffeeMachine.doOneCupOfCoffee();
        System.out.println("Пользователь делает кружку кофе");
    }

    @Тогда("^В кофемашине осталось (\\d+) грамм зерён$")
    public void вКофемашинеОсталосьГраммЗерён(int coffeeSeeds) {
        Assert.assertEquals(coffeeSeeds, coffeeMachine.getCoffeeSeeds());
    }

    @И("^В кофемашине осталось (\\d+) миллилитров воды$")
    public void вКофемашинеОсталосьМиллилитровВоды(int water) {
        Assert.assertEquals(water, coffeeMachine.getWater());
    }
    /*
        @Дано("^Пользователь добавляет в кофемашину$")
        public void пользовательДобавляетВКофемашину(DataTable table) {
            int coffee = table.asLists(String.class)
                    .stream()
                    .filter(row -> row.get(0).equals("coffee"))
                    .map( row -> row.get(1))
                    .map(Integer::parseInt)
                    .findFirst()
                    .orElseThrow();
            int water = table.asLists(String.class)
                    .stream()
                    .filter(row -> row.get(0).equals("water"))
                    .map( row -> row.get(1))
                    .map(Integer::parseInt)
                    .findFirst()
                    .orElseThrow();
            coffeeMachine.addWater(water);
            coffeeMachine.addCoffeeSeeds(coffee);

        }
    */
    @Дано("^Пользователь добавляет в кофемашину$")
    public void пользовательДобавляетВКофемашину(Map<String, Integer> map) {
        coffeeMachine.addCoffeeSeeds(map.get("coffee"));
        coffeeMachine.addWater(map.get("water"));
    }

    @И("^Пользователь говорит$")
    public void пользовательГоворит(String userText) {
        System.out.println(userText);
    }
}
