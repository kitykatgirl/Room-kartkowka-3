package ph.me.roomdilidydomdom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Species.class}, version = 1)
public abstract class SpeciesDatabase extends RoomDatabase {
    public abstract SpeciesDAO returnSpeciesDAO();
}
