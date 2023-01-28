package com.Creator.Dfw;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;



public class color {
	public static String color(String text) { return ChatColor.translateAlternateColorCodes('&', text); }
	public static List<String> color_list(List<String> l) {
		List<String> al1 = new ArrayList<String>();
		for(int i = 0 ; i < l.size() ; i++) {
			al1.add(color.color(l.get(i).toString()));
		}
		return al1; 
	
	}
}
