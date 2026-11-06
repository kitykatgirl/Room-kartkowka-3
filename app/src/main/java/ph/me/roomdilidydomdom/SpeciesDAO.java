package ph.me.roomdilidydomdom;

import androidx.room3.Dao;
import androidx.room3.Delete;
import androidx.room3.Insert;
import androidx.room3.Query;
import androidx.room3.Update;

@Dao//Ming
public interface SpeciesDAO {
    @Insert
    public void InsertSpeciesToDB(Species species);
    @Insert
    public void InsertMultipleSpeciesToDB(Species... species);
    @Delete
    public void DeleteFromDB(Species species);
    @Update
    public void UpdateSpecies(Species species);
    @Query("SELECT * FROM species")
    public void ReturnAllSpecies();
    @Query("SELECT * FROM Species WHERE LOWER(startingWeapon) = LOWER(:weapon)")
    public void ReturnSpeciesByStarterWeapon();
}
