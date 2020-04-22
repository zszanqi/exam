package com.hs.model;

public class Clazz {
	private int id;
	private int cno;
	private int fk_grade;
	private int fk_major;
	private byte del_flag;
	
	public Clazz() {
		super();
	}

	public Clazz(int id, int cno, int fk_grade, int fk_major, byte del_flag) {
		super();
		this.id = id;
		this.cno = cno;
		this.fk_grade = fk_grade;
		this.fk_major = fk_major;
		this.del_flag = del_flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getFk_grade() {
		return fk_grade;
	}

	public void setFk_grade(int fk_grade) {
		this.fk_grade = fk_grade;
	}

	public int getFk_major() {
		return fk_major;
	}

	public void setFk_major(int fk_major) {
		this.fk_major = fk_major;
	}

	public byte getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(byte del_flag) {
		this.del_flag = del_flag;
	}
	
}
