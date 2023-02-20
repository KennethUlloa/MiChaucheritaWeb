package utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JSON {
    private Map<String, Object> attributes;

    public JSON() {
        attributes = new HashMap<>();
    }

    public void add(String key, Object value) {
        attributes.put(key, value);
    }

    public Object get(String key) {
        return attributes.get(key);
    }

    private String stringify(Object value) {
        if (value instanceof String) return "\"" + ((String) value).replace("\"","\\\"") + "\"";
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        String jsonString = attributes.entrySet().stream()
                .map(entry -> stringify(entry.getKey()) + ":" + stringify(entry.getValue())).collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }
}
