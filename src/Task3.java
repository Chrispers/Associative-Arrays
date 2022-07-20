import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> itemList = new LinkedHashMap<>();
        String command;
        boolean flag = false;
        while(true){
            command = scanner.nextLine();
            String[] items = command.toLowerCase().split(" ");
            for (int i = 0; i < items.length - 1; i += 2) {
                int value = Integer.parseInt(items[i]);
                String key = items[i + 1];
                if(!itemList.containsKey(key)){
                    itemList.put(key, value);
                }else{
                    itemList.put(key, itemList.get(key) + value);
                }
                if(checkList(itemList)) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        printList(itemList);
    }
    public static boolean checkList(Map<String, Integer> itemList){
        if(itemList.containsKey("shards") && itemList.get("shards") >= 250){
            System.out.println("Shadowmourne obtained!");
            itemList.put("shards", itemList.get("shards") - 250);
            return true;
        }
        if(itemList.containsKey("fragments") && itemList.get("fragments") >= 250){
            System.out.println("Valanyr obtained!");
            itemList.put("fragments", itemList.get("fragments") - 250);
            return true;
        }
        if(itemList.containsKey("motes") && itemList.get("motes") >= 250){
            System.out.println("Dragonwrath obtained!");
            itemList.put("motes", itemList.get("motes") - 250);
            return true;
        }
        return false;
    }

    public static void printList(Map<String, Integer> itemList){
        if(!itemList.containsKey("shards"))
            itemList.put("shards", 0);
        System.out.println("shards: " + itemList.get("shards"));
        if(!itemList.containsKey("fragments"))
            itemList.put("fragments", 0);
        System.out.println("fragments: " + itemList.get("fragments"));
        if(!itemList.containsKey("motes"))
            itemList.put("motes", 0);
        System.out.println("motes: " + itemList.get("motes"));
        itemList.entrySet().forEach(entry -> {
            if(!entry.getKey().equals("shards") && !entry.getKey().equals("fragments") &&
                    !entry.getKey().equals("motes")){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        });
    }
}

