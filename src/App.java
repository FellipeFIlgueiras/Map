import br.com.map.Map;

public class App {

    public static void main(String[] args) throws Exception {

        Map<String, String> map = new Map<>();
        System.out.println(map);

        map.add("name", "jose");
        map.add("naprox", "edson");
        map.add("lastname", "maria");

        System.out.println("Contains: " + map.contains("name"));
        System.out.println(map);
        
        map.remove("lastname");
        System.out.println(map);

    }

}
