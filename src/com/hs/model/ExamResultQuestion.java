package com.hs.model;

public class ExamResultQuestion {
	 private int id;
	    private Boolean is_right;
	    private String wrong_answer;
	    private int fk_examResult;
	    private int fk_question;
	    private int fk_qtype;
	    private Byte del_flag;
		public ExamResultQuestion(int id, Boolean is_right, String wrong_answer, int fk_examResult, int fk_question,
				int fk_qtype, Byte del_flag) {
			super();
			this.id = id;
			this.is_right = is_right;
			this.wrong_answer = wrong_answer;
			this.fk_examResult = fk_examResult;
			this.fk_question = fk_question;
			this.fk_qtype = fk_qtype;
			this.del_flag = del_flag;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Boolean getIs_right() {
			return is_right;
		}
		public void setIs_right(Boolean is_right) {
			this.is_right = is_right;
		}
		public String getWrong_answer() {
			return wrong_answer;
		}
		public void setWrong_answer(String wrong_answer) {
			this.wrong_answer = wrong_answer;
		}
		public int getFk_examResult() {
			return fk_examResult;
		}
		public void setFk_examResult(int fk_examResult) {
			this.fk_examResult = fk_examResult;
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
		public Byte getDel_flag() {
			return del_flag;
		}
		public void setDel_flag(Byte del_flag) {
			this.del_flag = del_flag;
		}
		public ExamResultQuestion() {
			super();
		}

}
