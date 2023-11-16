package ss12_map_set.service.impl;

import ss12_map_set.model.Fruit;
import ss12_map_set.repository.IFruitRepository;
import ss12_map_set.repository.impl.FruitRepository;
import ss12_map_set.service.IFruitService;

import java.util.Map;

public class FruitService implements IFruitService {
    private static IFruitRepository iFruitRepository = new FruitRepository();
    @Override
    public Map<Integer, Fruit> getAllKeySet() {
        return iFruitRepository.getAllKeySet();
    }

    @Override
    public Map<Integer, Fruit> getAllEntrySet() {
        return iFruitRepository.getAllEntrySet();
    }

    @Override
    public void addFruitMap(Integer id, Fruit fruit) {
        iFruitRepository.addFruitMap(id, fruit);
    }

    @Override
    public boolean checkId(Integer id) {
        return iFruitRepository.checkId(id);
    }

    @Override
    public void removeFruit(Integer id) {
        iFruitRepository.removeFruit(id);
    }

    @Override
    public void editFruit(Integer id, Fruit fruit) {
        iFruitRepository.editFruit(id, fruit);
    }


}
