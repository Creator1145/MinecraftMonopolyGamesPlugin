package com.Creator.Dfw.staticevent;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Creator.Dfw.main;
/**
 * ��Ϸ��ʼʱ����
 * @author Creator
 *
 */
public class DfwgamestartEvent extends Event{
	private static final HandlerList handlers = new HandlerList();
	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlers;
	}
  public DfwgamestartEvent() {super();  }

      /**
       * ��ȡ��Ϸ�����
       * @return ��Ϸ�����
       */
	  public List<Player> getgameplayers(){
		  return main.dfwplayers;
	  }
	  public static HandlerList getHandlerList() { return handlers; }


	
	 
}
