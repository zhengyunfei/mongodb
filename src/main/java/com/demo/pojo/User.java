package com.demo.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2117883650009210549L;
	
	@Id  
    String id;  
    String name;  
    int age;  
      
      
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
    @Override  
    public String toString() {  
        return "{USER:{id:"+this.id+",name:"+this.name+",age:"+this.age+"}}";  
    }  
}
