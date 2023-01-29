package com.Creator.Dfw.gui;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import com.Creator.Dfw.color;
import com.Creator.Dfw.dfwpoint;
import com.Creator.Dfw.main;

public class MortgageGui {
	public static void open(Player p) {
		FileConfiguration config = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class).getConfig();
		Inventory inv = Bukkit.createInventory(null,54 ,color.color(config.getString("MortgageGui.title")));
		List<dfwpoint> temp=main.point;
		int wz=-1;
	for(int i=0;i<temp.size();i++) {
		dfwpoint point =temp.get(i);
		
		if(point.getlx().isenablemortgage()) {
			if(p.equals(point.getlx().getowner())||p.equals(point.getlx().getmortgageplayer())) {
			ItemStack is =point.getitemstack();
			ItemMeta im =is.getItemMeta();
			is.setAmount(i);
			wz++;
			if(point.getlx().ismortgage()) {
				im.setDisplayName(color.color(config.getString("MortgageGui.item.notMortgage.name").replace("{pointname}", point.getname())));
				im.addEnchant(Enchantment.LUCK,1, true);
				List<String> l =config.getStringList("MortgageGui.item.notMortgage.lore");
				
				for(int n =0;n<l.size();n++) {
					l.set(n, l.get(n).replace("{pointqian}",main.its(point.getlx().getmortgageqian())));
				}
				im.setLore(color.color_list(l));
				
			}else {
				im.setDisplayName(color.color(config.getString("MortgageGui.item.Mortgage.name").replace("{pointname}", point.getname())));
				List<String> l =config.getStringList("MortgageGui.item.Mortgage.lore");
			im.removeEnchant(Enchantment.LUCK);
				for(int n =0;n<l.size();n++) {
					l.set(n, l.get(n).replace("{pointqian}",main.its(point.getlx().getmortgageqian())));
				}
				im.setLore(color.color_list(l));
			}
			is.setItemMeta(im);
			inv.setItem(wz,is);
		}
			}
	}
	p.openInventory(inv);
	}

}
