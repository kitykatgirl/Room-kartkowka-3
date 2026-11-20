# sawian room project

![Badge](https://img.shields.io/badge/EVIL_Katie-Certified-red)
![Badge](https://img.shields.io/badge/Certified-Hood_classic-blue)
![Badge](https://img.shields.io/badge/W-Goon-green)
 
## Here is how you can do this:

### Step 1:
Put this in your gradle file in dependencies:

    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

### Step 2:
Make a class for your table item.
Example for the start of the db class:

    @Entity(tableName = "mytable")
    public class Item {
      @PrimaryKey(autoGenerate = true)
      public int id;
      
add a constructor too

### Step 3:
Make a DAO interface for your table with your SQL queries:
Example:

    @Dao//Ming
    public interface ItemDAO {
      @Insert
      public void InsertItemToDB(Item item);
      @Insert
      public void InsertMultipleItemsToDB(Item... items);
      @Delete
      public void DeleteFromDB(Item item);
      @Update
      public void UpdateItem(Item item);
      @Query("SELECT * FROM mytable")
      public void ReturnAllItems();
    }

### Step 4:
make a ItemDatabase.java class:

    @Database(entities = {Item.class}, version = 1)
    public abstract class ItemDatabase extends RoomDatabase {
      public abstract ItemDAO returnItemsDAO();
    }

### Step 5:
Connect your db to ActivityMain:

    ItemDatabase itemDatabase = Room.databaseBuilder(getApplicationContext(),ItemDatabase.class,"items_db").allowMainThreadQueries().build();

I also reccomend putting the items into a list so its easy to work with:

    List<Item> itemsList = ItemDatabase.returnItemsDAO().returnAllItems();

### Step 6:
apreciate your genius for getting this to work.

## This has been an EVIL Katie Certified - Hood Classic

![Badge](https://img.shields.io/badge/meow%20mrrp-FFB6C1)
