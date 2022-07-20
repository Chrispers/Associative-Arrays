import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> courses = new LinkedHashMap<>();
        Map<String, Integer> students = new LinkedHashMap<>();
        String[] command;
        while(true){
            command = scanner.nextLine().split(" : ");
            if(command[0].equals("end"))
                break;
            String course = command[0];
            String student = command[1];
            if(!courses.containsKey(course)){
                courses.put(course, "-- " + student);
                students.put(course, 1);
            }else{
                courses.put(course, courses.get(course) + "\n-- " + student);
                students.put(course, students.get(course) + 1);
            }
        }
        courses.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + students.get(entry.getKey())
                    + "\n" + entry.getValue());
        });
    }
}
