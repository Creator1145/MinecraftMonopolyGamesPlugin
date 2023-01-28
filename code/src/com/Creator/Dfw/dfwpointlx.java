package com.Creator.Dfw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
/**
 * 大富翁的地点类型
 * @author Creator
 *
 */
public abstract class dfwpointlx {
	private String in;
	private String n;
	private HashMap<String,Object> configsetting ;
	private Player owner=null;
	private Boolean enablemortgage=false;
	private Boolean ismortgage=false;
	private Player mortgageplayer;
	private int mortgageqian=0;
public dfwpointlx(String Internal_name) {in=Internal_name;}
public Boolean isenablemortgage() {return enablemortgage;}
public void setenablemortgage(Boolean b) {enablemortgage=b;}
public Player getmortgageplayer() {return mortgageplayer;}
public void setmortgageplayer(Player p) {mortgageplayer=p;}
public Boolean ismortgage() {return ismortgage;}
public void setismortgage(Boolean b) {ismortgage=b;}
public int getmortgageqian() {return mortgageqian;}
public void setmortgageqian(int i) {mortgageqian=i;}
public Boolean mortgage(Player p,Boolean b) {
	if(enablemortgage) {
		if(b) {
			if(!ismortgage) {
				owner=null;
				ismortgage=true;
				mortgageplayer=p;
				main.give(p, mortgageqian);
				return true;
			}
			
		}else {
		if(ismortgage) {
			if(main.pay(p, mortgageqian)) {
				owner=p;
				ismortgage=false;
				mortgageplayer=null;
				return true;
			}
		}
			
			
			
		}
	}
	return false;
}
/**
 * 设置该点的所有者
 * @param p 欲设置该点的所有者的玩家
 */
public void setowner(Player p) {owner=p;}
/**
 * 获取该点的所有者
 * @return 该点的所有者
 */
public Player getowner() {return owner;}
/**
 * 判断玩家是否为该点的所有者
 * @param p 用于判断的玩家
 * @return 是否为该点的所有者
 */
public Boolean isowner(Player p){
	if(p.equals(owner)) {
		return true;
	}
	return false;
}
@Deprecated
public String getlxname() {return n;}
/**
 * 获取该类型的内部名字
 * @return 内部名字
 */
public String getlxInternal_name() {return in;}
/**
 * 用于设置该类型需要的配置
 * @param setting 配置，String为位置，Object为内容，位置只需要名称即可，例如："house"="point.xx.lx.house"
 */
public void setconfigsettings(HashMap<String,Object> setting) {configsetting=setting;}
/**
 * 获取该类型需要的配置
 * @return 配置，String为位置，Object为内容
 */
public HashMap<String,Object> getconfigsetting() {return configsetting;}
/**
 * 写入配置，仅在DfwRegLxEvent_Done需要使用
 */
public void setconfigsettingfordfwconfig() {
	Boolean o=false;
	Iterator it = configsetting.keySet().iterator();
     Plugin plugin =com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
     ConfigurationSection c =plugin.getConfig().getConfigurationSection("point");
 	for(String item : c.getKeys(false)) {
 		if(plugin.getConfig().getString("point."+item+".lx.Internal name")!=null&&plugin.getConfig().getString("point."+item+".lx.Internal name").equals(in)) {
 			 for (String i : configsetting.keySet()) {				
				 String loc = "point."+item+".lx."+i;
	            Object val = configsetting.get(i);     
	            if( plugin.getConfig().get(loc)==null) {
	            	 plugin.getConfig().set(loc, val);         
	            	 o=true;
	            }
				 }
 			
 		}
 	}
 	if(o==true) {plugin.saveConfig();
    plugin.reloadConfig();}
}
/**
 * 读取配置
 * @param s 位置，位置只需要名称即可，例如："house"="point.xx.lx.house"
 * @param pointint 点的位置，可使用dfwpoint.getwz();
 * @return 内容
 */
public Object getconfig(String s,int pointint) {
	Plugin plugin =com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
	ConfigurationSection c =plugin.getConfig().getConfigurationSection("point");
 	int i =-1;
	for(String item : c.getKeys(false)) {
 		i++;
 		
 		if(i==pointint) {return plugin.getConfig().get("point."+item+".lx."+s);}
 	}
	return null;
}

}
