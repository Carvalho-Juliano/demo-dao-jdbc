package main.java.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Seller implements Serializable{
  
  private static final long serialVersionUID= 1L;

  private Integer id;
  private String name;
  private String email;
  private LocalDateTime birthDate;
  private double baseSalary;

  private Department department;

  public Seller() {}

  public Seller(Integer id, String name, String email, LocalDateTime birthdate, double baseSalary, Department department) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birthDate = birthdate;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public LocalDateTime getBirthDate() {
    return this.birthDate;
  }

  public double getSalary() {
    return this.baseSalary;
  }

  public Department getDepartment() {
    return this.department;
  } 

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBirthDate(LocalDateTime birthdate) {
    this.birthDate = birthdate;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public void setDepartment(Department department) {
    this.department = department;
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
    Seller other = (Seller) object;
    if (id == null) {
      if (other.id != null) 
        return false;
    } else if (!id.equals(other.id)) 
      return false;
    
    return true;
  }

  @Override
  public String toString() {
    return "Seller [id=" + id + ", name=" + name + ", Email=" + email + ", birthdate=" + birthDate + ", baseSalary=" + baseSalary + ", department=" + department + "]";
  }
  
}
