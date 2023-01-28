package com.Creator.Dfw.pointlx;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.Creator.Dfw.dfwpointlx;
import com.Creator.Dfw.main;

public class tax extends dfwpointlx{

	public tax(String Internal_name) {
		super(Internal_name);
		HashMap<String,Object> users = new HashMap<String,Object>();
		users.put("qian",700);
		users.put("name","&eÀ∞ ’");
		this.setconfigsettings(users);
		// TODO Auto-generated constructor stub
	}
public void jg(Player p ,int pointint) {
	int q =(int) getconfig("qian",pointint);
	main.pay(p,q);
}
}
