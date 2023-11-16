package ss12_map_set.controller;

import ss12_map_set.model.Fruit;
import ss12_map_set.service.IFruitService;
import ss12_map_set.service.impl.FruitService;

import java.util.Map;

public class FruitController {
    private static IFruitService iFruitService = new FruitService();
    public Map<Integer, Fruit> getAllKeySet() {
        return iFruitService.getAllKeySet();
    }

    public Map<Integer, Fruit> getAllEntrySet() {
        return iFruitService.getAllEntrySet();
    }

    public void addFruitMap(Integer id, Fruit fruit) {
        iFruitService.addFruitMap(id, fruit);
    }


    public boolean checkId(Integer id) {
        return iFruitService.checkId(id);
    }


    public void removeFruit(Integer id) {
        iFruitService.removeFruit(id);
    }

    public void editFruit(Integer id, Fruit fruit) {
        iFruitService.editFruit(id, fruit);
    }
}
