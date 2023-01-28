package com.Creator.Dfw.staticevent;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Creator.Dfw.dfwpoint;
import com.Creator.Dfw.main;
/**
 * 玩家完成前进触发
 * @author Creator
 *
 */
public class DfwForwardEvent_Done extends Event{
	private static final HandlerList handlers = new HandlerList();

	private int Pointint;
	private Player player;
private Location loc;
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
  public DfwForwardEvent_Done(Player p,int pointint,Location l) {super();  Pointint=pointint;player=p;loc=l;}

/**
 * 获取前进的格数
 * @return 前进的格数
 */
public int getforwardint() {return Pointint;}
/**
 * 获取前进完成的玩家
 * @return 前进完成的玩家
 */
public Player getplayer() {
	return player;
}
/**
 * 获取最终的位置
 * @return 最终的位置
 */
public Location getatlastlocation() {return loc;}
/**
 * 获取最终到的点
 * @return 最终到的点
 */
public dfwpoint getpoint() {
		return main.point.get(Pointint);
}

	  public static HandlerList getHandlerList() { return handlers; }

}

