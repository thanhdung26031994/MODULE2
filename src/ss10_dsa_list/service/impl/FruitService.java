package ss10_dsa_list.service.impl;

import ss10_dsa_list.model.Fruit;
import ss10_dsa_list.repository.IFruitRepository;
import ss10_dsa_list.repository.impl.FruitRepository;
import ss10_dsa_list.service.IFruitService;

import java.util.List;

public class FruitService implements IFruitService {
    private static IFruitRepository iFruitRepository = new FruitRepository();


    @Override
    public void addFruit(Fruit fruit) {
        iFruitRepository.addFruit(fruit);
    }

    @Override
    public List<Fruit> getAllFruit() {
        return iFruitRepository.getAllFruit();
    }
}
