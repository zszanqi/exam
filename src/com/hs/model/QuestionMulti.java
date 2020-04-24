package com.hs.model;

public class QuestionMulti {
    private Integer id;

    private String title;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String answer;

    private Double score;

    private Integer fk_teacher;

    private Integer fk_qtype;

    private Byte del_flag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getFk_teacher() {
		return fk_teacher;
	}

	public void setFk_teacher(Integer fk_teacher) {
		this.fk_teacher = fk_teacher;
	}

	public Integer getFk_qtype() {
		return fk_qtype;
	}

	public void setFk_qtype(Integer fk_qtype) {
		this.fk_qtype = fk_qtype;
	}

	public Byte getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(Byte del_flag) {
		this.del_flag = del_flag;
	}

}