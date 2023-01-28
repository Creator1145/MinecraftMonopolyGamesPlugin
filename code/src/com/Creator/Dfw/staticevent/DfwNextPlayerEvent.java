package com.Creator.Dfw.staticevent;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Creator.Dfw.main;
/**
 * ��һ�����ʱ����
 * @author Creator
 *
 */
public class DfwNextPlayerEvent extends Event implements Cancellable{
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private int thisplayer;

	
  public DfwNextPlayerEvent(int dqplayer) {super();thisplayer=dqplayer;  }
/**
 * �Ƿ�ȡ��
 */
  public boolean isCancelled() { return this.cancelled; }
  /**
   * ��ȡ��ǰ�����
   * @return ��ǰ�����
   */
public Player getplayer() {
	return main.dfwplayers.get(thisplayer);
}
/**
 * ��ȡ��һ�����
 * @return ��һ�����
 */
public Player getnextplayer() {
	if(thisplayer+1<main.dfwplayers.size()) {
		return main.dfwplayers.get(thisplayer+1);
	}else {
		return main.dfwplayers.get(0);
	}
}
/**
 * �����Ƿ�ȡ��
 */
  public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
	  public static HandlerList getHandlerList() { return handlers; }
	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlers;
	}

}
