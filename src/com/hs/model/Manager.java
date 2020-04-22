package com.hs.model;

public class Manager {
	 private int id;
	    private String username;
	    private String password;
	    private Byte modified;
		public Manager(int id, String username, String password, Byte modified) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.modified = modified;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Byte getModified() {
			return modified;
		}
		public void setModified(Byte modified) {
			this.modified = modified;
		}
		public Manager() {
			super();
		}
	    
}
