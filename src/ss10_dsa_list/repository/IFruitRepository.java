package ss10_dsa_list.repository;

import ss10_dsa_list.model.Fruit;

import java.util.List;

public interface IFruitRepository {

    void addFruit(Fruit fruit);

    List<Fruit> getAllFruit();
}
