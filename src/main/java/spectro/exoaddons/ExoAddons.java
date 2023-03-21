package spectro.exoaddons;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import spectro.exoaddons.Commands.Menu;

import static io.github.thebusybiscuit.slimefun4.implementation.Slimefun.instance;
import static spectro.exoaddons.Items.EXO_NANOHELMET;


public final class ExoAddons extends JavaPlugin implements SlimefunAddon {

    public static NamespacedKey getPlugin(String e) {
        return new NamespacedKey(instance(), e);
    }

    public static ExoAddons getInstance() {
        return null;
    }

    @Override
    public void onEnable() {
        setInstance(this);
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("§7[§6Exo Addons§7] §fPlugin sendo iniciado...");
        getCommand("menu").setExecutor(new Menu());

        Items.setup(this);

        getServer().getPluginManager().registerEvents(new Events(), this);

        ItemMeta NANOHELMET_META = EXO_NANOHELMET.getItemMeta();
        NANOHELMET_META.addItemFlags(ItemFlag.HIDE_DYE);
        EXO_NANOHELMET.setItemMeta(NANOHELMET_META);

    }

    private void setInstance(ExoAddons ins) {
        ExoAddons instance = ins;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("§7[§6Exo Addons§7] §fPlugin sendo desligado...");
    }
    @Override
    public JavaPlugin getJavaPlugin(){
        //This will connect my Addons to Slimefun4
        return this;
    }
    @Override
    public String getBugTrackerURL() {
        return null;
    }

}
