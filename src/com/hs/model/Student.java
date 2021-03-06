package com.hs.model;

public class Student {
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private Integer fk_clazz;

    private Byte modified;

    private Byte del_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

   
    public Integer getFk_clazz() {
		return fk_clazz;
	}

	public void setFk_clazz(Integer fk_clazz) {
		this.fk_clazz = fk_clazz;
	}

	public Byte getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(Byte del_flag) {
		this.del_flag = del_flag;
	}

	public Byte getModified() {
        return modified;
    }

    public void setModified(Byte modified) {
        this.modified = modified;
    }

    public Byte getDelFlag() {
        return del_flag;
    }

    public void setDelFlag(Byte del_flag) {
        this.del_flag = del_flag;
    }
}