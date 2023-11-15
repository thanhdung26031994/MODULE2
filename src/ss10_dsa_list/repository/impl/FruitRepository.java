package ss10_dsa_list.repository.impl;

import ss10_dsa_list.model.Fruit;
import ss10_dsa_list.repository.IFruitRepository;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository implements IFruitRepository {
    public static List<Fruit> fruitList = new ArrayList<>();
    static {
        fruitList.add(new Fruit("Táo", "Có hạt", "12/12/2022", "12/01/2023", "Việt Nam", 12.3));
        fruitList.add(new Fruit("Lê Hàn Quốc", "Không hạt", "12/12/2022", "19/12/2022", "Hàn Quốc", 70.5));
        fruitList.add(new Fruit("Cherry Úc", "Có hạt", "12/12/2022", "12/02/2023", "Úc", 350.9));
        fruitList.add(new Fruit("Sầu Riêng", "Hạt lép", "12/12/2022", "12/04/2023", "Việt Nam", 220.0));
        fruitList.add(new Fruit("Nho Mỹ", "Không hạt", "12/12/2022", "12/02/2023", "Mỹ", 175.8));
    }


    @Override
    public void addFruit(Fruit fruit) {
        fruitList.add(fruit);
    }

    @Override
    public List<Fruit> getAllFruit() {
        return fruitList;
    }
}
