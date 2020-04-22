package com.hs.model;

public class Grade {
	 private int id;
	    private String name;
	    private Byte del_flag;
		public Grade(int id, String name, Byte del_flag) {
			super();
			this.id = id;
			this.name = name;
			this.del_flag = del_flag;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Byte getDel_flag() {
			return del_flag;
		}
		public void setDel_flag(Byte del_flag) {
			this.del_flag = del_flag;
		}
		public Grade() {
			super();
		}
	    
}
