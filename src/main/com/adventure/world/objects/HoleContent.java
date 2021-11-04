package main.com.adventure.world.objects;

import main.com.adventure.world.objects.keys.Key;

public class HoleContent {
    private Key content;
    private boolean keyIsCovered = true;

    /**
     * @param key is the content in the hole.
     */
    public HoleContent(Key key) {
        content = key;
    }

    public void setCovered(boolean isCovered) {
        this.keyIsCovered = isCovered;
    }

    public boolean isCovered() {
        return keyIsCovered;
    }

    public Key getKey() {
        return content;
    }
}
