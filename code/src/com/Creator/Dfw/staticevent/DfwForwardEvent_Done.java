package com.Creator.Dfw.staticevent;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Creator.Dfw.dfwpoint;
import com.Creator.Dfw.main;
/**
 * ������ǰ������
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
 * ��ȡǰ���ĸ���
 * @return ǰ���ĸ���
 */
public int getforwardint() {return Pointint;}
/**
 * ��ȡǰ����ɵ����
 * @return ǰ����ɵ����
 */
public Player getplayer() {
	return player;
}
/**
 * ��ȡ���յ�λ��
 * @return ���յ�λ��
 */
public Location getatlastlocation() {return loc;}
/**
 * ��ȡ���յ��ĵ�
 * @return ���յ��ĵ�
 */
public dfwpoint getpoint() {
		return main.point.get(Pointint);
}

	  public static HandlerList getHandlerList() { return handlers; }

}

