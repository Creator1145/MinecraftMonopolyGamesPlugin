package com.Creator.Dfw;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
/**
 * ���̲���ĵص㵥λ
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
	 * ��ȡ�õ������
	 * @return �õ������
	 */
	public String getname() {return name;}
	/**
	 * ��ȡ�õ������
	 * @return �õ������
	 */
	public dfwpointlx getlx() {return lx;}
	/**
	 * ���øõ��λ��
	 * @return �õ��λ��
	 */
	public Location getloc() {return loc;}
	/**
	 * ��ȡ�õ�Ϊ�ڼ���
	 * @return �õ�Ϊ�ڼ���
	 */
	public int getwz() {return i;}
	/**
	 * ��ȡ�õ�Ĵ�����Ʒ
	 * @return �õ�Ĵ�����Ʒ
	 */
	public ItemStack getitemstack() {return is;}
	/**
	 * ���øõ������
	 * @param e ���õ�����
	 */
	public void  setlx(dfwpointlx e) {lx=e;}
	/**
	 * ���øõ������
	 * @param s ���õ�����
	 */
	public void setname(String s) {name=s;}
	/**
	 * ���øõ��λ��
	 * @param l ���õ�λ��
	 */
	public void setloc(Location l) {loc=l;}
	/**
	 * ���øõ�Ϊ�ڼ���
	 * @param wz �ڼ���
	 */
	public void setwz(int wz) {i=wz;}
	/**
	 * ���øõ�Ĵ�����Ʒ
	 * @param e ������Ʒ����ҪΨһ��
	 */
	public void setitemstack(ItemStack e) {is=e;}
}
