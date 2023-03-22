package spectro.exoaddons.Armor;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import org.bukkit.inventory.ItemStack;

public class NanoArmor extends SlimefunItem implements Rechargeable {
    public NanoArmor(ItemGroup exoitems, SlimefunItemStack item, RecipeType type, ItemStack[] recipe) {
        super(exoitems, item, type, recipe);
    }
    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return 10000;
    }
}
