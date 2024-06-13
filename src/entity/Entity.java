package entity;

public class Entity {
    private int id;

    public Entity(int id){
        this.id = id;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  // overide equals to check only id
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Entity entity = (Entity) obj;
    return id == entity.id;
  }
}
