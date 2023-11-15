package ss10_dsa_list.controller;

import ss10_dsa_list.model.Fruit;
import ss10_dsa_list.service.IFruitService;
import ss10_dsa_list.service.impl.FruitService;

import java.util.List;

public class FruitController {
    private static IFruitService iFruitService = new FruitService();

    public void addFruit(Fruit fruit) {
        iFruitService.addFruit(fruit);
    }

    public List<Fruit> getAllFruit() {
       return iFruitService.getAllFruit();
    }
}
