package spectro.exoaddons;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import spectro.exoaddons.Armor.*;

public final class Items {


    public static final SlimefunItemStack EXO_NANO_HELMET = new SlimefunItemStack(
            "EXO_NANO_HELMET",
            Material.LEATHER_HELMET, Color.BLACK,
            "&9Nano Helmet",
            "&c&l * &a&lInformações",
            "&b&l-> &7Protege &e50% &7de todos os ataques",
            "&b&l-> &7Precisa de todas as partes!",
            "&c&o&8\u21E8 &e\u26A1 &70 / 10000 J",
            "",
            "&9⛏ &aSky-Factory &9⛏"
    );
    public static final SlimefunItemStack EXO_NANO_CHESTPLATE = new SlimefunItemStack(
            "EXO_NANO_CHESTPLATE",
            Material.LEATHER_CHESTPLATE, Color.BLACK,
            "&9Nano Chestplate",
            "&c&l * &a&lInformações",
            "&b&l-> &7Protege &e50% &7de todos os ataques",
            "&b&l-> &7Precisa de todas as partes!",
            "&c&o&8\u21E8 &e\u26A1 &70 / 10000 J",
            "",
            "&9⛏ &aSky-Factory &9⛏"
    );
    public static final SlimefunItemStack EXO_NANO_LEGGINGS = new SlimefunItemStack(
            "EXO_NANO_LEGGINGS",
            Material.LEATHER_LEGGINGS, Color.BLACK,
            "&9Nano Leggings",
            "&c&l * &a&lInformações",
            "&b&l-> &7Protege &e50% &7de todos os ataques",
            "&b&l-> &7Precisa de todas as partes!",
            "&c&o&8\u21E8 &e\u26A1 &70 / 10000 J",
            "",
            "&9⛏ &aSky-Factory &9⛏"
    );
    public static final SlimefunItemStack EXO_NANO_BOOTS = new SlimefunItemStack(
            "EXO_NANO_BOOTS",
            Material.LEATHER_BOOTS, Color.BLACK,
            "&9Nano Boots",
            "&c&l * &a&lInformações",
            "&b&l-> &7Protege &e50% &7de todos os ataques",
            "&b&l-> &7Precisa de todas as partes!",
            "&c&o&8\u21E8 &e\u26A1 &70 / 10000 J",
            "",
            "&9⛏ &aSky-Factory &9⛏"
    );
    public static void setup(ExoAddons plugin) {
        ItemGroup category = new ItemGroup(ExoAddons.getPlugin("ExoAddons"),
                new CustomItemStack(Material.REDSTONE_BLOCK, "&6Exo Addons"),0);
        //Nano Helmet recipe
        new NanoArmor(category, EXO_NANO_HELMET, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_INGOT)
        }).register(plugin);

        //Nano Chestplate recipe
        new NanoArmor(category, EXO_NANO_CHESTPLATE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_BLOCK), null, new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_BLOCK), null, new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_BLOCK), null, new ItemStack(Material.IRON_INGOT)

        }).register(plugin);
        //Nano Leggings recipe
        new NanoArmor(category, EXO_NANO_LEGGINGS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_BLOCK), null, new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_BLOCK),
                new ItemStack(Material.IRON_BLOCK), null, new ItemStack(Material.IRON_INGOT)
        }).register(plugin);

        //Nano Boots recipe
        new NanoArmor(category, EXO_NANO_BOOTS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.IRON_BLOCK), null, null,
                new ItemStack(Material.IRON_INGOT), null, new ItemStack(Material.IRON_BLOCK),
                new ItemStack(Material.IRON_INGOT), null, null
        }).register(plugin);
    }
}
