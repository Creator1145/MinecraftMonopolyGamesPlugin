package com.Creator.Dfw.staticevent;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Creator.Dfw.main;
/**
 * ��ҽ�Ҫǰ��ʱ����
 * @author Creator
 *
 */
public class DfwForwardEvent extends Event implements Cancellable{
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private int Pointint;
	private Player player;

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
  public DfwForwardEvent(Player p,int pointint) {super();  Pointint=pointint;player=p;}
  /**
   * �Ƿ�ȡ��
   */
public boolean isCancelled() { return this.cancelled; }
/**
 * ��ȡǰ���ĸ���
 * @return ǰ���ĸ���
 */
public int getforwardint() {return Pointint;}
/**
 * ��ȡǰ�������
 * @return ǰ�������
 */
public Player getplayer() {
	return player;
}
/**
 * ȡ��ǰ��
 */
  public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
	  public static HandlerList getHandlerList() { return handlers; }

}
