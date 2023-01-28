package com.Creator.Dfw.pointlx;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.Creator.Dfw.color;
import com.Creator.Dfw.dfwpointlx;
import com.Creator.Dfw.main;


public class house extends dfwpointlx{

private int dqhouse;
	public house(String Internal_name) {
		super(Internal_name);
		
		HashMap<String,Object> users = new HashMap<String,Object>();
		users.put("house1",true);
		users.put("house1_name","&a一栋房子");
		users.put("house1_qian",1000);
		users.put("house2",true);
		users.put("house2_qian",1000);
		users.put("house2_name","&a两栋房子");
		users.put("house3",true);
		users.put("house3_qian",1000);
		users.put("house3_name","&a一栋旅馆");
		Plugin plugin =com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
	//	plugin.getConfig().set("dfwlxguis.house.item.1", Bukkit.createInventory(null,27 ,color.color("&b房子" )));
		//plugin.saveConfig();
		this.setconfigsettings(users);
		this.setenablemortgage(true);
		
		// TODO Auto-generated constructor stub
	}
	public Boolean buyhouse(int house,Player p,int pointint) {
		if(house>dqhouse) {
			if(main.pay(p,(int) getconfig("house"+main.its(house)+"_qian",pointint))) {
				dqhouse=house;
				setowner(p);
				return true;
			}
			
		}
		return false;
	}
	public void jg(Player p,int pointint) {
		if(getowner()!=null&&!p.equals(getowner())) {
		
			int q =(int) getconfig("house"+main.its(dqhouse)+"_qian",pointint);
			main.pay(p,q);
			main.give(getowner(),q);
		}
		
			
		
	}
	public void setdqhouse(int i) {dqhouse=i;}
	public int getdqhouse() {return dqhouse;}
public Inventory dinv (int i,Player p) {
	Inventory inv = Bukkit.createInventory(null,27 ,color.color("&b房子" ));	
		if(p!=null&&getowner()!=null) {
			if(p.equals(getowner())) {
				inv.setItem(10, getitem(0,i));	
			}
		}else {
			inv.setItem(10, getitem(0,i));	
			inv.setItem(13, getitem(1,i));
			inv.setItem(16, getitem(2,i));
		}
			
		
	
	return inv;
}
public ItemStack getitem(int n,int i) {
	ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)5);
	ItemMeta im  =is.getItemMeta();
	if(n==0) {
		im.setDisplayName(color.color((String) this.getconfig("house1_name", i)));
		is.setItemMeta(im);
		is.setAmount(1);
	}
	if(n==1) {
		im.setDisplayName(color.color((String) this.getconfig("house2_name", i)));
		is.setItemMeta(im);
		is.setAmount(2);
	}
	if(n==2) {
		is =new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
		im.setDisplayName(color.color((String) this.getconfig("house3_name", i)));
		is.setItemMeta(im);
		is.setAmount(3);
	}
	return is;
}

}
