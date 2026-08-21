package main.java.model.entities;

import java.io.Serializable;

public class Department implements Serializable {

  private static final long serialVersionUID= 1L;

  private Integer id;
  private String name;

  public Department() {}

  public Department(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public Integer getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) 
      return true;
    if (object == null)
      return false;
    if (getClass() != object.getClass())
      return false;
    Department other = (Department) object;
    if (id == null) {
      if (other.id != null) 
        return false;
    } else if (!id.equals(other.id)) 
      return false;
    
    return true;
  }

  @Override
  public String toString() {
    return "Department [id=" + id + ", name=" + name + "]";
  }
}
