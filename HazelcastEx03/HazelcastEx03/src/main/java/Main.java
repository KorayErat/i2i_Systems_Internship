import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Main {
    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Integer, Person> map = client.getMap("people");

        for (int i = 0; i < 10000; i++) {
            map.put(i, new Person("Person-" + i));
        }
        System.out.println("10.000 kişi eklendi.");
        for (int i = 0; i < 10; i++) {
            Person p = map.get(i);
            System.out.println(i + " → " + p.getName());
        }

        client.shutdown();
    }
}
