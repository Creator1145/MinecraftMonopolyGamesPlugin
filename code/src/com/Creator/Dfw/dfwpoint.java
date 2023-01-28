package com.Creator.Dfw;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
/**
 * 大富翁插件的地点单位
 * @author Creator
 *
 */
public class dfwpoint {
	private String name;
	private dfwpointlx lx;
	private Location loc;
	private ItemStack is;
	private int i;
	public dfwpoint(String n,dfwpointlx l,Location location,ItemStack itemstack,int wz) {i=wz;name=n;lx=l;loc=location;is=itemstack;}
	/**
	 * 获取该点的名称
	 * @return 该点的名称
	 */
	public String getname() {return name;}
	/**
	 * 获取该点的类型
	 * @return 该点的类型
	 */
	public dfwpointlx getlx() {return lx;}
	/**
	 * 设置该点的位置
	 * @return 该点的位置
	 */
	public Location getloc() {return loc;}
	/**
	 * 获取该点为第几个
	 * @return 该点为第几个
	 */
	public int getwz() {return i;}
	/**
	 * 获取该点的代表物品
	 * @return 该点的代表物品
	 */
	public ItemStack getitemstack() {return is;}
	/**
	 * 设置该点的类型
	 * @param e 设置的类型
	 */
	public void  setlx(dfwpointlx e) {lx=e;}
	/**
	 * 设置该点的名称
	 * @param s 设置的名称
	 */
	public void setname(String s) {name=s;}
	/**
	 * 设置该点的位置
	 * @param l 设置的位置
	 */
	public void setloc(Location l) {loc=l;}
	/**
	 * 设置该点为第几个
	 * @param wz 第几个
	 */
	public void setwz(int wz) {i=wz;}
	/**
	 * 设置该点的代表物品
	 * @param e 代表物品（需要唯一）
	 */
	public void setitemstack(ItemStack e) {is=e;}
}
