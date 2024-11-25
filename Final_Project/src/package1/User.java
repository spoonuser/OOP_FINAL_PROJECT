package package1;

import java.util.Scanner;

public  class User {
	 private String name;
	    private int age;
	    private String login;
	    private String password;
	    public String type;
	    
	    public User(String name, int age, String login, String password, String type){
	    	this.name = name;
	    	this.age = age;
	    	this.login = login;
	    	this.password = password;
	    	this.type = type;
	    }
	
	    public String get_password() {
	        return password;
	    }
	    public String get_login() {
	        return login;
	    }
	    public String get_name() {
	        return name;
	    }
	    public String get_type() {
	    	return type;
	    }
}
