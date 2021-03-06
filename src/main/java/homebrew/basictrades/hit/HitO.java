package homebrew.basictrades.hit;

import homebrew.basictrades.BasicTrades;
import homebrew.basictrades.tools.ConfigManagement;
import homebrew.basictrades.interfaces.HitI;
import homebrew.basictrades.tools.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.File;
import java.util.*;
import java.util.logging.Level;

public class HitO extends HitA {

    public HitO(OfflinePlayer bountyOwner, OfflinePlayer bounty, Inventory inventory) {
        super(bountyOwner, bounty, inventory);
    }

    public HitO(File loadHit) {
        super(loadHit);
    }

    public void saveHit() {
        ConfigManagement configMan = new ConfigManagement("Hits" + File.separator + bounty + ".yml");
        FileConfiguration savedHit = configMan.getConfig();

        savedHit.set("Expiration", Long.valueOf(task.delay));

        //Save owner
        if (owner != null) {
            savedHit.set("Owner", owner.toString());
        }

        //Save Inventory
        ItemStack[] contents = prize.getContents();
        for (int i = 0; i < contents.length; i++) {
            savedHit.set("Inventory." + String.valueOf(i), contents[i]);
        }
        configMan.saveConfig();
    }


}
