package spectro.exoaddons.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Menu implements CommandExecutor {
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {

        if(sender instanceof org.bukkit.entity.Player){

            //Variables
            Player p = (Player) sender;
            Inventory menuGui = Bukkit.createInventory(p, 9, ChatColor.GOLD + "Menu");

            //Items in menuGui
            ItemStack gmS = new ItemStack(Material.APPLE);
            ItemStack gmC = new ItemStack(Material.NETHER_STAR);
            ItemStack suicide = new ItemStack(Material.TNT);
            ItemStack feed = new ItemStack(Material.COOKED_BEEF);
            ItemStack nano_Helmet = new ItemStack(Material.LEATHER_HELMET);

            //Metas to items
            ItemMeta gmSM = gmS.getItemMeta();
            ItemMeta gmCM = gmC.getItemMeta();
            ItemMeta suicideM = suicide.getItemMeta();
            ItemMeta feedM = feed.getItemMeta();
            ItemMeta nanoHM = nano_Helmet.getItemMeta();

            //Set Display Name to items
            gmSM.setDisplayName(ChatColor.LIGHT_PURPLE + "Gamemode Survival");
            gmCM.setDisplayName(ChatColor.GOLD + "Gamemode Creative");
            suicideM.setDisplayName(ChatColor.RED + "Suicide");
            feedM.setDisplayName(ChatColor.GREEN + "Feed");
            nanoHM.setDisplayName(ChatColor.BLUE + "Nano Helmet");

            //Set Item Colors
            nanoHM.setCustomModelData(0x00);


            //Set Lore to items
            ArrayList<String> gmSL = new ArrayList<>();
            gmSL.add(ChatColor.GRAY + "Click to change Survival");
            gmSM.setLore(gmSL);
            gmS.setItemMeta(gmSM);

            ArrayList<String> gmCL = new ArrayList<>();
            gmCL.add(ChatColor.GRAY + "Click to change Creative");
            gmCM.setLore(gmCL);
            gmC.setItemMeta(gmCM);

            ArrayList<String> suicideL = new ArrayList<>();
            suicideL.add(ChatColor.GRAY + "Click to kill yourself");
            suicideM.setLore(suicideL);
            suicide.setItemMeta(suicideM);

            ArrayList<String> feedL = new ArrayList<>();
            feedL.add(ChatColor.GRAY + "Click to feed yourself");
            feedM.setLore(feedL);
            feed.setItemMeta(feedM);

            ArrayList<String> nanoHL = new ArrayList<>();
            nanoHL.add(ChatColor.GRAY + "Click to get a Nano Helmet");
            nanoHM.setLore(nanoHL);
            nano_Helmet.setItemMeta(nanoHM);
            
            //Group of items in menuGui
            ItemStack[] menuContents = {gmS, gmC, suicide, feed, nano_Helmet};

            //Set contents of menuGui and Open the Inventory TO player
            menuGui.setContents(menuContents);
            p.openInventory(menuGui);
        }
        return true;
    }
}
