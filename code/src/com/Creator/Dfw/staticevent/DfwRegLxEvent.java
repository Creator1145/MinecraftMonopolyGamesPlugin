package com.Creator.Dfw.staticevent;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

import com.Creator.Dfw.dfwpoint;
import com.Creator.Dfw.dfwpointlx;
import com.Creator.Dfw.main;
/**
 * ÿע��һ���㴥��һ�Σ��������õ������
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
	 * ��ȡ�ڼ�����
	 * @return �ڼ�����
	 */
	public int getint() {return n;}
	  public static HandlerList getHandlerList() { return handlers; }
	  public DfwRegLxEvent(dfwpoint point,int i) {
		  po=point;n=i;
	  }
	  /**
	   * ��ȡ��ǰ�ĵ�
	   * @return ��ǰ�ĵ�
	   */
	  public dfwpoint getpoint() {return po;}
	  /**
	   * ��ȡ��ǰ�������
	   * @return ��ǰ�������
	   */
	  public dfwpointlx getlx() {return po.getlx();}
	  /**
	   * ���õ�ǰ�������
	   * @param e �����õ�����
	   */
	  public void setdfwpointlx(dfwpointlx e) {
		  main.point.get(n).setlx(e);
	  }
	  /**
	   * ��ȡ��ǰ������Ӧ�õ����͵��ڲ�����
	   * @return ��ǰ������Ӧ�õ����͵��ڲ�����
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
