package spectro.exoaddons;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.utils.ChargeUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
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
import spectro.exoaddons.Armor.NanoHelmet;

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
    private final NanoHelmet nanoHelmet = (NanoHelmet) Items.EXO_NANOHELMET.getItem();
    @EventHandler
    // Cancel the item be damaged if have energy
    public void onItemDamage(PlayerItemDamageEvent e) {
        if (e.getItem().hasItemMeta()) {
            final SlimefunItem item = SlimefunItem.getByItem(e.getItem());
            if (item instanceof PassiveElectricRemoval || item instanceof NanoHelmet) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    // Cancel the damage if player have Nano Helmet with Energy equiped
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player player && player.getEquipment() != null) {
            final ItemStack helmet = player.getEquipment().getHelmet();
            if (e.getFinalDamage() > 0
                    && helmet != null
                    && nanoHelmet.isItem(helmet)
                    && nanoHelmet.removeItemCharge(helmet, Math.max(1, (float) e.getFinalDamage()) * 20)
            ) {
                final ItemMeta meta = helmet.getItemMeta();
                final float newCharge = ChargeUtils.getCharge(meta);

                e.setDamage(0);

                final ComponentBuilder builder = new ComponentBuilder();
                builder
                        .append("&9Nano Helmet")
                        .append("&energia restante: &e")
                        .append(String.valueOf(nanoHelmet.getItemCharge(helmet)))
                        .append(" &7/ &a100000 &cJ");
                if (meta instanceof Damageable damageable) {
                    final double chargePercent = (newCharge / nanoHelmet.getMaxItemCharge(helmet)) * 100;
                    final int percentOfMax = (int) ((chargePercent / 100) * helmet.getType().getMaxDurability());
                    final int damage = Math.max(1, helmet.getType().getMaxDurability() - percentOfMax);
                    damageable.setDamage(damage);
                    helmet.setItemMeta(meta);
                }
                ((Player) e.getEntity()).spigot().sendMessage(ChatMessageType.ACTION_BAR, builder.create());
            }
        }
    }

}