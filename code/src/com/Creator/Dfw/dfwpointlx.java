package com.Creator.Dfw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
/**
 * ���̵ĵص�����
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
 * ���øõ��������
 * @param p �����øõ�������ߵ����
 */
public void setowner(Player p) {owner=p;}
/**
 * ��ȡ�õ��������
 * @return �õ��������
 */
public Player getowner() {return owner;}
/**
 * �ж�����Ƿ�Ϊ�õ��������
 * @param p �����жϵ����
 * @return �Ƿ�Ϊ�õ��������
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
 * ��ȡ�����͵��ڲ�����
 * @return �ڲ�����
 */
public String getlxInternal_name() {return in;}
/**
 * �������ø�������Ҫ������
 * @param setting ���ã�StringΪλ�ã�ObjectΪ���ݣ�λ��ֻ��Ҫ���Ƽ��ɣ����磺"house"="point.xx.lx.house"
 */
public void setconfigsettings(HashMap<String,Object> setting) {configsetting=setting;}
/**
 * ��ȡ��������Ҫ������
 * @return ���ã�StringΪλ�ã�ObjectΪ����
 */
public HashMap<String,Object> getconfigsetting() {return configsetting;}
/**
 * д�����ã�����DfwRegLxEvent_Done��Ҫʹ��
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
 * ��ȡ����
 * @param s λ�ã�λ��ֻ��Ҫ���Ƽ��ɣ����磺"house"="point.xx.lx.house"
 * @param pointint ���λ�ã���ʹ��dfwpoint.getwz();
 * @return ����
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
