package ss12_map_set.repository;

import ss12_map_set.model.Fruit;

import java.util.Map;

public interface IFruitRepository {
    Map<Integer, Fruit> getAllKeySet();

    Map<Integer, Fruit> getAllEntrySet();

    void addFruitMap(Integer id, Fruit fruit);


    boolean checkId(Integer id);

    void removeFruit(Integer id);

    void editFruit(Integer id, Fruit fruit);
}
