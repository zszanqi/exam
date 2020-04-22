package com.hs.model;
public class TeacherClazz {
    private Integer id;

    private Integer fk_teacher;

    private Integer fk_clazz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFk_teacher() {
		return fk_teacher;
	}

	public void setFk_teacher(Integer fk_teacher) {
		this.fk_teacher = fk_teacher;
	}

	public Integer getFk_clazz() {
		return fk_clazz;
	}

	public void setFk_clazz(Integer fk_clazz) {
		this.fk_clazz = fk_clazz;
	}

   
}