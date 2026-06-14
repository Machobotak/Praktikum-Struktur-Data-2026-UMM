package Latihan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class soalHashMap {
    public static Map<String,Integer> countSales(String [] transaction){
        Map<String,Integer> map = new HashMap<>();
        for(String t :  transaction){
            String[] split = t.split(":");
            String name = split[0];
            int qty = Integer.parseInt(split[1]);
            if(map.containsKey(name)){
                map.put(name,map.get(name)+qty);
            }else {
                map.put(name,qty);
            }
        }
        return map;
    }

    public static void printRank(Map<String,Integer> salesMap){
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(salesMap.entrySet());
        list.sort((a,b)->a.getValue()-b.getValue());
        for(int i =0;i<list.size();i++){
            String medal = (i==0) ? " [Top Trader]":"";
            System.out.println(""+(i+1)+" "+list.get(i).getKey()+" : "+list.get(i).getValue()+" items"+medal);
        }
    }

    public static void main(String[] args) {
        String[] transaction = {"Arya:30","Bima:50","Arya:20","Candra:40","Bima:10","Candra:60","Arya:15"};
        System.out.println("=== market ===");
        Map<String,Integer> map = countSales(transaction);
        printRank(map);
        System.out.println("Total transaction: "+transaction.length);
    }
}
