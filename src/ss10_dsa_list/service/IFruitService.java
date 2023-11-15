package ss10_dsa_list.service;

import ss10_dsa_list.model.Fruit;

import java.util.List;

public interface IFruitService {


    void addFruit(Fruit fruit);

    List<Fruit> getAllFruit();
}
