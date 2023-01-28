package com.Creator.Dfw.staticevent;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

import com.Creator.Dfw.dfwpoint;
import com.Creator.Dfw.dfwpointlx;
import com.Creator.Dfw.main;
/**
 * 每注册一个点触发一次，用于设置点的类型
 * @author Creator
 *
 */
public class DfwRegLxEvent extends Event{
	private static final HandlerList handlers = new HandlerList();
	private dfwpoint po;
	private int n;
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	/**
	 * 获取第几个点
	 * @return 第几个点
	 */
	public int getint() {return n;}
	  public static HandlerList getHandlerList() { return handlers; }
	  public DfwRegLxEvent(dfwpoint point,int i) {
		  po=point;n=i;
	  }
	  /**
	   * 获取当前的点
	   * @return 当前的点
	   */
	  public dfwpoint getpoint() {return po;}
	  /**
	   * 获取当前点的类型
	   * @return 当前点的类型
	   */
	  public dfwpointlx getlx() {return po.getlx();}
	  /**
	   * 设置当前点的类型
	   * @param e 欲设置的类型
	   */
	  public void setdfwpointlx(dfwpointlx e) {
		  main.point.get(n).setlx(e);
	  }
	  /**
	   * 获取当前点类型应该的类型的内部名字
	   * @return 当前点类型应该的类型的内部名字
	   */
	  public String getlxname() {
		  Plugin plugin = com.Creator.Dfw.main.getPlugin(com.Creator.Dfw.main.class);
			 ConfigurationSection c =plugin.getConfig().getConfigurationSection("point");
			 int i =-1;	
			 for(String item : c.getKeys(false)) {
				 i++;
				 if(i==n) {
					 return plugin.getConfig().getString("point."+item+".lx.Internal name");
				 }
			 }
			return null;
	  }
}
