package com.hs.model;

public class ExamQuestions {
	private int s;
	private int fk_exam;
	private int fk_question;
	private int fk_qtype;
	private byte del_flag;
	
	public ExamQuestions() {
		super();
	}

	public ExamQuestions(int s, int fk_exam, int fk_question, int fk_qtype, byte del_flag) {
		super();
		this.s = s;
		this.fk_exam = fk_exam;
		this.fk_question = fk_question;
		this.fk_qtype = fk_qtype;
		this.del_flag = del_flag;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getFk_exam() {
		return fk_exam;
	}

	public void setFk_exam(int fk_exam) {
		this.fk_exam = fk_exam;
	}

	public int getFk_question() {
		return fk_question;
	}

	public void setFk_question(int fk_question) {
		this.fk_question = fk_question;
	}

	public int getFk_qtype() {
		return fk_qtype;
	}

	public void setFk_qtype(int fk_qtype) {
		this.fk_qtype = fk_qtype;
	}

	public byte getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(byte del_flag) {
		this.del_flag = del_flag;
	}
	
}
