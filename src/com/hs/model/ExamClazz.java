package com.hs.model;

public class ExamClazz {
	private int id;
	private int fk_exam;
	private int fk_clazz;
	private byte del_flag;
	public ExamClazz() {
		super();
	}
	public ExamClazz(int id, int fk_exam, int fk_clazz, byte del_flag) {
		super();
		this.id = id;
		this.fk_exam = fk_exam;
		this.fk_clazz = fk_clazz;
		this.del_flag = del_flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFk_exam() {
		return fk_exam;
	}
	public void setFk_exam(int fk_exam) {
		this.fk_exam = fk_exam;
	}
	public int getFk_clazz() {
		return fk_clazz;
	}
	public void setFk_clazz(int fk_clazz) {
		this.fk_clazz = fk_clazz;
	}
	public byte getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(byte del_flag) {
		this.del_flag = del_flag;
	}
	
	
}
