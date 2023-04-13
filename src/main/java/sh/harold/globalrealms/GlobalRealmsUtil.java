package sh.harold.globalrealms;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class GlobalRealmsUtil extends JavaPlugin implements Listener {
    public void onEnable() {
        //log start message
        getLogger().info("GlobalRealmsUtil has been enabled! (harold.sh)");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onExplode(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if(Objects.equals(entity.getLastDamageCause(), EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)){
            event.setCancelled(true);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
