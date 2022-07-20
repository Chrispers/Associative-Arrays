import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> list = new LinkedHashMap<>();
        for(char symbol : text.toCharArray()){
            if(symbol == ' ')
                continue;
            if(!list.containsKey(symbol)){
                list.put(symbol, 1);
            }else{
                list.put(symbol, list.get(symbol) + 1);
            }
        }
        list.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}