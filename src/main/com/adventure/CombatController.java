package main.com.adventure;

import main.com.adventure.player.Player;
import main.com.adventure.world.Monster;

public class CombatController {

    private Player player;
    private Monster monster;

    /**
     * Processes a combat situation between the player and a monster.
     * @param player - the game's player.
     * @param monster - the monster who the player is trying to defeat.
     */
    public CombatController(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    /**
     * Runs through the combat of the player and monster until either the monster's
     * or the player's health is 0. The player always goes first.
     */
    public void autosimulateCombat() {

        while (monster.getHealth() > 0 && player.getHealth() > 0) {
            //hit monster
            monster.setHealth(monster.getHealth() - player.getPower());
            //check if monster is dead
            if (monster.getHealth() <= 0) {
                break;
            }
            //monster hits player
            player.setHealth(player.getHealth() - monster.getPower());
        }
    }

    /**
     * find out if the player is dead.
     * @return true if player's health is 0
     */
    public boolean isPlayerDefeated() {
        return player.getHealth() <= 0;
    }

    /**
     * Resets the health of the monster and player back to 10.
     */
    public void reset() {
        player.setHealth(10);
        monster.setHealth(10);
    }
}
