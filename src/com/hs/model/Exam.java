package com.hs.model;

import java.util.Date;

public class Exam {
	
	private int id;
	
	private String title;
	
	private int time_limit;
	
	private Date end_time;
	
	private int fk_status;
	
	private int fk_teacher;
	
	private double single_points;
	
	private double multi_points;
	
	private double judge_points;
	
	private double total_points;
	
	private byte del_flag;

	
	
	public Exam() {
		super();
	}

	public Exam(int id, String title, int time_limit, Date end_time, int fk_status, int fk_teacher,
			double single_points, double multi_points, double judge_points, double total_points, byte del_flag) {
		super();
		this.id = id;
		this.title = title;
		this.time_limit = time_limit;
		this.end_time = end_time;
		this.fk_status = fk_status;
		this.fk_teacher = fk_teacher;
		this.single_points = single_points;
		this.multi_points = multi_points;
		this.judge_points = judge_points;
		this.total_points = total_points;
		this.del_flag = del_flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(int time_limit) {
		this.time_limit = time_limit;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public int getFk_status() {
		return fk_status;
	}

	public void setFk_status(int fk_status) {
		this.fk_status = fk_status;
	}

	public int getFk_teacher() {
		return fk_teacher;
	}

	public void setFk_teacher(int fk_teacher) {
		this.fk_teacher = fk_teacher;
	}

	public double getSingle_points() {
		return single_points;
	}

	public void setSingle_points(double single_points) {
		this.single_points = single_points;
	}

	public double getMulti_points() {
		return multi_points;
	}

	public void setMulti_points(double multi_points) {
		this.multi_points = multi_points;
	}

	public double getJudge_points() {
		return judge_points;
	}

	public void setJudge_points(double judge_points) {
		this.judge_points = judge_points;
	}

	public double getTotal_points() {
		return total_points;
	}

	public void setTotal_points(double total_points) {
		this.total_points = total_points;
	}

	public byte getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(byte del_flag) {
		this.del_flag = del_flag;
	}
	
}
