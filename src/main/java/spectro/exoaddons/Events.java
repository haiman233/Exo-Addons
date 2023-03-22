package spectro.exoaddons;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChargeUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import spectro.exoaddons.Armor.NanoArmor;

import static spectro.exoaddons.Items.*;

public class Events implements Listener {
    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        //Variables
        Player p = (Player) e.getWhoClicked();

        //Verify if the player clicked on the menu
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Menu")) {

            //Verify which item was clicked
            switch (e.getCurrentItem().getType()) {
                case APPLE -> {
                    p.closeInventory();
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Voce escolheu o item " + ChatColor.GOLD + "Apple");
                    System.out.println(
                            ChatColor.GREEN + "O jogador"
                                    + ChatColor.RED + p
                                    + ChatColor.GREEN + " acabou de selecionar a opção"
                                    + ChatColor.GOLD + "Apple"
                    );
                }
                case NETHER_STAR -> {
                    p.closeInventory();
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.GREEN + "Você escolheu o item " + ChatColor.GOLD + "Nether Star");
                    System.out.println(
                            ChatColor.GREEN + "O jogador"
                                    + ChatColor.RED + p
                                    + ChatColor.GREEN + " acabou de selecionar a opção"
                                    + ChatColor.GOLD + "Nether Star"
                    );
                }
                case TNT -> {
                    p.closeInventory();
                    p.setHealth(0.0);
                    p.sendMessage(ChatColor.GREEN + "Voce escolheu o item " + ChatColor.GOLD + "TNT");
                    System.out.println(
                            ChatColor.GREEN + "O jogador"
                                    + ChatColor.RED + p
                                    + ChatColor.GREEN + " acabou de selecionar a opção"
                                    + ChatColor.GOLD + "TNT"
                    );
                }
                case COOKED_BEEF -> {
                    p.closeInventory();
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.GREEN + "Voce escolheu o item " + ChatColor.GOLD + "Cooked Beef");
                    System.out.println(
                            ChatColor.GREEN + "O jogador"
                                    + ChatColor.RED + p
                                    + ChatColor.GREEN + " acabou de selecionar a opção"
                                    + ChatColor.GOLD + "Cooked Beef"
                    );
                }
            }
            e.setCancelled(true);
        }
    }

    private final NanoArmor nanoHelmet = (NanoArmor) EXO_NANO_HELMET.getItem();
    private final NanoArmor nanoChestplate = (NanoArmor) EXO_NANO_CHESTPLATE.getItem();
    private final NanoArmor nanoLeggings = (NanoArmor) EXO_NANO_LEGGINGS.getItem();
    private final NanoArmor nanoBoots = (NanoArmor) EXO_NANO_BOOTS.getItem();


    @EventHandler
    // Cancel the item be damaged have energy
    public void onItemDamage(PlayerItemDamageEvent e) {
        if (e.getItem().hasItemMeta()) {
            final SlimefunItem item = SlimefunItem.getByItem(e.getItem());
            if (item instanceof PassiveElectricRemoval || item instanceof NanoArmor) {
                e.setCancelled(true);
            }
        }
    }

    // Verify if the player have the item
    private boolean canUse(ItemStack playerItem, SlimefunItemStack sfItem) {
        return playerItem != null
                && sfItem.getItem().isItem(playerItem);
    }

    private boolean helmetNewCharge(ItemStack helmet) {
        final ItemMeta meta = helmet.getItemMeta();
        final float newCharge = ChargeUtils.getCharge(meta);
        if (meta instanceof Damageable damageable) {
            final double chargePercent = (newCharge / nanoHelmet.getMaxItemCharge(helmet)) * 100;
            final int percentOfMax = (int) ((chargePercent / 100) * helmet.getType().getMaxDurability());
            final int damage = Math.max(1, helmet.getType().getMaxDurability() - percentOfMax);
            damageable.setDamage(damage);
            helmet.setItemMeta(meta);
        }
        return false;
    }
    private boolean chestNewCharge(ItemStack chest) {
        final ItemMeta meta = chest.getItemMeta();
        final float newCharge = ChargeUtils.getCharge(meta);
        if (meta instanceof Damageable damageable) {
            final double chargePercent = (newCharge / nanoChestplate.getMaxItemCharge(chest)) * 100;
            final int percentOfMax = (int) ((chargePercent / 100) * chest.getType().getMaxDurability());
            final int damage = Math.max(1, chest.getType().getMaxDurability() - percentOfMax);
            damageable.setDamage(damage);
            chest.setItemMeta(meta);
        }
        return false;
    }
    private boolean legsNewCharge(ItemStack legs) {
        final ItemMeta meta = legs.getItemMeta();
        final float newCharge = ChargeUtils.getCharge(meta);
        if (meta instanceof Damageable damageable) {
            final double chargePercent = (newCharge / nanoLeggings.getMaxItemCharge(legs)) * 100;
            final int percentOfMax = (int) ((chargePercent / 100) * legs.getType().getMaxDurability());
            final int damage = Math.max(1, legs.getType().getMaxDurability() - percentOfMax);
            damageable.setDamage(damage);
            legs.setItemMeta(meta);
        }
        return false;
    }
    private boolean bootsNewCharge(ItemStack boots) {
        final ItemMeta meta = boots.getItemMeta();
        final float newCharge = ChargeUtils.getCharge(meta);
        if (meta instanceof Damageable damageable) {
            final double chargePercent = (newCharge / nanoBoots.getMaxItemCharge(boots)) * 100;
            final int percentOfMax = (int) ((chargePercent / 100) * boots.getType().getMaxDurability());
            final int damage = Math.max(1, boots.getType().getMaxDurability() - percentOfMax);
            damageable.setDamage(damage);
            boots.setItemMeta(meta);
        }
        return false;
    }
    @EventHandler
    // Reduce the damage by half if player have Nano Armor with Energy equiped
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player player && player.getEquipment() != null) {
            final ItemStack helmet = player.getEquipment().getHelmet();
            final ItemStack chest = player.getEquipment().getChestplate();
            final ItemStack legs = player.getEquipment().getLeggings();
            final ItemStack boots = player.getEquipment().getBoots();
            if (e.getFinalDamage() > 0
            && helmet != null
            && nanoHelmet.isItem(helmet)
            && nanoHelmet.removeItemCharge(helmet, Math.max(1, (float) e.getFinalDamage()) * 20)
            && chest != null
            && nanoChestplate.isItem(chest)
            && nanoChestplate.removeItemCharge(chest, Math.max(1, (float) e.getFinalDamage()) * 20)
            && legs != null
            && nanoLeggings.isItem(legs)
            && nanoLeggings.removeItemCharge(legs, Math.max(1, (float) e.getFinalDamage()) * 20)
            && boots != null
            && nanoBoots.isItem(boots)
            && nanoBoots.removeItemCharge(boots, Math.max(1, (float) e.getFinalDamage()) * 20)
            ) {
                double damageHalf = e.getDamage() / 2;
                e.setDamage(damageHalf);
            } else {
                return;
            }
            helmetNewCharge(helmet);
            chestNewCharge(chest);
            legsNewCharge(legs);
            bootsNewCharge(boots);
        }
    }
}


