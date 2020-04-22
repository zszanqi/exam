package com.hs.model;

import java.util.Date;

public class ExamResult {
	private int id;
	private double point;
	private Date time;
	private String exam_title;
	private int fk_exam;
	private int fk_student;
	private byte del_flag;
	
	public ExamResult() {
		super();
	}

	public ExamResult(int id, double point, Date time, String exam_title, int fk_exam, int fk_student, byte del_flag) {
		super();
		this.id = id;
		this.point = point;
		this.time = time;
		this.exam_title = exam_title;
		this.fk_exam = fk_exam;
		this.fk_student = fk_student;
		this.del_flag = del_flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getExam_title() {
		return exam_title;
	}

	public void setExam_title(String exam_title) {
		this.exam_title = exam_title;
	}

	public int getFk_exam() {
		return fk_exam;
	}

	public void setFk_exam(int fk_exam) {
		this.fk_exam = fk_exam;
	}

	public int getFk_student() {
		return fk_student;
	}

	public void setFk_student(int fk_student) {
		this.fk_student = fk_student;
	}

	public byte getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(byte del_flag) {
		this.del_flag = del_flag;
	}
	
}
