package ph.me.roomdilidydomdom;

import androidx.room3.Database;
import androidx.room3.RoomDatabase;

@Database(entities = {Species.class}, version = 1)
public abstract class SpeciesDatabase extends RoomDatabase {
    public abstract SpeciesDAO returnSpeciesDAO();
}
