package com.Creator.Dfw.staticevent;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/**
 * ���˦��˦��ʱ����
 * @author Creator
 *
 */
public class DfwSszEvent_Done extends Event{
	private static final HandlerList handlers = new HandlerList();
	private Player player ;
	private String c;
	private int n;

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
  public DfwSszEvent_Done(Player p,String cause,int num) {super(); c=cause;player=p;n=num;}
  /**
   * ��ȡ˦��������
   * @return ˦��������
   */
public int getnum() {n++;return n;}
/**
 * ��ȡ˦˦�ӵ�ԭ��
 * @return ˦˦�ӵ�ԭ��
 */
public String getcause() {return c;}
/**
 * ��ȡ˦˦�ӵ����
 * @return ˦˦�ӵ����
 */
public Player getplayer() {
	return player;
}
	  public static HandlerList getHandlerList() { return handlers; }
}
