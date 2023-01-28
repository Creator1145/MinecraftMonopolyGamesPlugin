package com.Creator.Dfw;
/**
 * ´ó¸»ÎÌµÄ×´Ì¬
 * @author Creator
 *
 */
public class dfwstate {
private String name;
private int time;
private String in;
public dfwstate(String n,int t,String Internal_name) {in=Internal_name;name=n;time=t;}
public int gettime() {return time;}
public String getInternal_name() {return in;}
public String getname() {return name;}
}
