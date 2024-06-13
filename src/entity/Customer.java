package entity;

public class Customer extends Entity {
  private String name;
  private String email;

  public Customer(String name, String email) {
    super(0);
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + getId() +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

}
