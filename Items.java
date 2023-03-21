package spectro.exoaddons;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import spectro.exoaddons.Armor.NanoHelmet;

public final class Items {


    public static final SlimefunItemStack EXO_NANOHELMET = new SlimefunItemStack(
            "EXO_NANOHELMET",
            Material.LEATHER_HELMET, Color.BLACK,
            "&9Nano Helmet",
            "&c&l * &a&lInformações",
            "&b&l-> &7Protege o jogador de todos os ataques",
            "&c&o&8\u21E8 &e\u26A1 &70 / 1000000 J",
            "",
            "&9⛏ &aSky-Factory &9⛏"
    );
    public static void setup(ExoAddons plugin) {
        ItemGroup category = new ItemGroup(ExoAddons.getPlugin("ExoAddons"),
                new CustomItemStack(Material.REDSTONE_BLOCK, "&6Exo Addons"),0);

        new NanoHelmet(category, EXO_NANOHELMET, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT)
        }).register(plugin);
    }
}
