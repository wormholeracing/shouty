package shouty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class Shouty {
    private static final int MESSAGE_RANGE = 1000;
    
    private Map<String, Coordinate> locations = new HashMap<>();
    private Map<String, List<String>> messages = new HashMap<>();

    public void setLocation(String person, Coordinate location) {
        locations.put(person, location);
    }

    public void shout(String person, String message) {
    	List<String> currentMessages = messages.get(person) == null ? new ArrayList<>() : messages.get(person);
    	currentMessages.add(message);
    	messages.put(person, currentMessages);
    }

    public Map<String, List<String>> getMessagesHeardBy(String listener) {
        HashMap<String, List<String>> result = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : messages.entrySet()) {
            String shouter = entry.getKey();
            List<String> messages = entry.getValue();
            int distance = locations.get(listener).distanceFrom(locations.get(shouter));
            if (distance < MESSAGE_RANGE && !listener.equals(shouter))
                result.put(shouter, messages);
        }

        return result;
    }
    
}
