package com.Creator.Dfw.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;
import org.bukkit.plugin.Plugin;

import com.Creator.Dfw.color;
import com.Creator.Dfw.team.teamcolor;



public class teamgui {
	public static Inventory returngui() {
		Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
		Inventory inv = Bukkit.createInventory(null,plugin.getConfig().getInt("gui(team)_Number of squares") ,color.color(plugin.getConfig().getString("gui(team)_Title") ));
		List<String> l = plugin.getConfig().getStringList("team");
		List<String> l1 = plugin.getConfig().getStringList("teamname");
		for(int i = 0 ; i<l.size();i++) {
			Wool w = new Wool();
			w.setColor(teamcolor.valueOf(l.get(i)).getDyeColor());
			
			ItemStack is = w.toItemStack();
			is.setAmount(1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(teamcolor.valueOf(l.get(i)).getChatColor()+l1.get(i));
			List<String> a = new ArrayList<String>();
			a.add(l.get(i));
			im.setLore(a);
			is.setItemMeta((ItemMeta) im);
			inv.setItem(i, is);
		     
		}
		
		return inv;
		
	}
}
