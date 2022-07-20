import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> forceBook = new LinkedHashMap<>();
        Map<String, Integer> numberOfUsers = new LinkedHashMap<>();
         while(true){
            String command = scanner.nextLine();
            if(command.contains("Lumpawaroo"))
                break;
            if(command.contains(" | ")){
                formatOne(command, forceBook, numberOfUsers);
            }
            if(command.contains(" -> ")){
                formatTwo(command, forceBook, numberOfUsers);
            }
        }
         forceBook.entrySet().forEach(entry -> {
             if(numberOfUsers.get(entry.getKey()) > 0){
                 System.out.println("Side: " + entry.getKey() + ", Members: " +
                         numberOfUsers.get(entry.getKey()) + entry.getValue());
             }
         });
    }
    public static void formatOne(String command, Map<String, String> forceBook, Map<String, Integer> numberOfUsers){
        String user = getUser(command);
        String side = getSide(command);
        if(!forceBook.containsKey(side) && !forceBook.containsValue(user)){
            forceBook.put(side, "\n! " + user);
            numberOfUsers.putIfAbsent(side, 0);
            numberOfUsers.put(side, numberOfUsers.get(side) + 1);
        }else if(forceBook.containsKey(side)){
            String temp = forceBook.get(side);
            if(!temp.contains(user)) {
                forceBook.put(side, forceBook.get(side) + "\n! " + user);
                numberOfUsers.putIfAbsent(side, 0);
                numberOfUsers.put(side, numberOfUsers.get(side) + 1);
            }
        }
    }

    public static void formatTwo(String command, Map<String, String> forceBook, Map<String, Integer> numberOfUsers){
        String user = getUser(command);
        String side = getSide(command);
        if(!forceBook.containsKey(side) && !forceBook.containsValue(user)){
            forceBook.put(side, "\n! " + user);
            numberOfUsers.putIfAbsent(side, 0);
            numberOfUsers.put(side, numberOfUsers.get(side) + 1);
        }else if(forceBook.containsKey(side)){
            String tempKey = forceBook.get(side);
            if(!tempKey.contains(user)) {
                forceBook.put(side, forceBook.get(side) + "\n! " + user);
                numberOfUsers.putIfAbsent(side, 0);
                numberOfUsers.put(side, numberOfUsers.get(side) + 1);
            }
        }
        System.out.println(user + " joins the " + side + " side!");
    }

    public static String getUser(String command){
        if(command.contains(" | ")){
            String[] temp = command.split(" \\| ");
            return temp[1];
        }else{
            String[] temp = command.split(" -> ");
            return temp[0];
        }
    }
    public static String getSide(String command){
        if(command.contains(" -> ")){
            String[] temp = command.split(" -> ");
            return temp[1];
        }else{
            String[] temp = command.split(" \\| ");
            return temp[0];
        }
    }
}
