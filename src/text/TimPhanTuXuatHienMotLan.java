package text;

import java.util.HashMap;
import java.util.Map;

public class TimPhanTuXuatHienMotLan {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 5, 5};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr){
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        //duyet lai map vừa thêm
        for (int i: map.keySet()){
            if(map.get(i) == 1){
                System.out.println(i);
            }
        }
    }
}
