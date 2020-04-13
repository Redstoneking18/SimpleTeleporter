package util;

import cn.nukkit.utils.Config;
import main.main;

import java.util.HashMap;
import java.util.Map;

public class language {

    public static HashMap<String, String> messages = new HashMap<>();

    public static void init() {
        main.getInstance().saveResource("messages.yml");
        Config m = new Config(main.getInstance().getDataFolder() + "/messages.yml");
        for (Map.Entry<String, Object> map : m.getAll().entrySet()) {
            String key = map.getKey();
            if (map.getValue() instanceof String) {
                String val = (String) map.getValue();
                messages.put(key, val);
            }
        }
    }

    public static String getAndReplace(String key, String... replacements) {
        String message = getMessage(key);
        int i = 0;
        for (String replacement : replacements) {
            message = message.replace("[" + i + "]", replacement);
            i++;
        }
        return message;
    }

    public static String getAndReplace(String key, double... replacements) {
        String message = getMessage(key);
        int i = 0;
        for (double replacement : replacements) {
            message = message.replace("[" + i + "]", String.valueOf(replacement));
            i++;
        }
        return message;
    }

    public static String getAndReplace(String key, boolean... replacements) {
        String message = getMessage(key);
        int i = 0;
        for (boolean replacement : replacements) {
            message = message.replace("[" + i + "]", String.valueOf(replacement));
            i++;
        }
        return message;
    }

    public static String getMessage(String key) {
        return messages.getOrDefault(key, "null");
    }

}