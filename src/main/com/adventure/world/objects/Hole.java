package main.com.adventure.world.objects;

import main.com.adventure.world.objects.keys.Key;

public class Hole {
    private HoleContent holeContent;
    /**
     * Creates a hole with the given content.
     * @param content - the item that is covered by the hole.
     */
    public Hole(Key content) {
        this.holeContent = new HoleContent(content);
    }

    /**
     * Uncovers the hole. If applicable, the contents are now revealed.
     */
    public void dig() {
        holeContent.setCovered(false);
    }

    public boolean isCovered() {
        return holeContent.isCovered();
    }

    /**
     * if the HoleContent is uncovered, return the content. Otherwise, return null.
     * @return - the content if the hole is uncovered.
     */
    public Tangible getContent() {
        if (holeContent.isCovered()) {

            return holeContent.getKey();
        } else {
            return null;
        }

    }
}
