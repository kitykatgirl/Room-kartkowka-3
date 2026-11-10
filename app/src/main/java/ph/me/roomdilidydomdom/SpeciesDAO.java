package ph.me.roomdilidydomdom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao//Ming
public interface SpeciesDAO {
    @Insert
    public void insertSpeciesToDB(Species species);
    @Insert
    public void insertMultipleSpeciesToDB(Species... species);
    @Delete
    public void deleteFromDB(Species species);
    @Update
    public void updateSpecies(Species species);
    @Query("SELECT * FROM species")
    public List<Species> returnAllSpecies();
    @Query("SELECT * FROM Species WHERE LOWER(startingWeapon) = LOWER(:weapon)")
    public List<Species> returnSpeciesByStarterWeapon(String weapon);
}
