package ph.me.roomdilidydomdom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "species")
public class Species {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String description;
    public int aimSpeed;
    public int reloadSpeed;
    public int moveSpeed;
    public int health;
    public String startingWeapon;

    public Species(String name, String description, int aimSpeed, int reloadSpeed, int moveSpeed, int health, String startingWeapon) {
        this.name = name;
        this.description = description;
        this.aimSpeed = aimSpeed;
        this.reloadSpeed = reloadSpeed;
        this.moveSpeed = moveSpeed;
        this.health = health;
        this.startingWeapon = startingWeapon;
    }

    @Override
    public String toString() {
        return "\n" + name + "\n" + description + "\nAim Speed: " + aimSpeed + "%\nReload Speed: " + reloadSpeed + "%\nMove Speed: " + moveSpeed + "%\nHealth: " + health + "\nStarting Weapon: " + startingWeapon + "\n";
    }
}