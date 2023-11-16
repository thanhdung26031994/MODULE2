package ss12_map_set.repository.impl;

import ss12_map_set.model.Fruit;
import ss12_map_set.repository.IFruitRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FruitRepository implements IFruitRepository {
    private static final Map<Integer, Fruit> fruitMap = new LinkedHashMap<>();
    static {
        fruitMap.put(1, new Fruit("Táo", "Có hạt", "12/12/2022", "12/01/2023", "Việt Nam", 12.3));
        fruitMap.put(2, new Fruit("Lê Hàn Quốc", "Không hạt", "12/12/2022", "19/12/2022", "Hàn Quốc", 70.5));
        fruitMap.put(3, new Fruit("Cherry Úc", "Có hạt", "12/12/2022", "12/02/2023", "Úc", 350.9));
    }

    @Override
    public Map<Integer, Fruit> getAllKeySet() {
        return fruitMap;
    }

    @Override
    public Map<Integer, Fruit> getAllEntrySet() {
        return fruitMap;
    }

    @Override
    public void addFruitMap(Integer id, Fruit fruit) {
        fruitMap.put(id, fruit);
    }

    @Override
    public boolean checkId(Integer id) {
        Set<Integer> set = fruitMap.keySet();
        for (Integer i: set){
            if (i.equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeFruit(Integer id) {
        Set<Integer> set = fruitMap.keySet();
        set.removeIf(i -> i.equals(id));
    }

    @Override
    public void editFruit(Integer id, Fruit fruit) {
        if (fruitMap.containsKey(id)){
            fruitMap.put(id, fruit);
        }
    }

}
