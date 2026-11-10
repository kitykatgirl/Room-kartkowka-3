package ph.me.roomdilidydomdom;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextDescription, editTextAimSpeed, editTextReloadSpeed, editTextMoveSpeed, editTextHealth;
    Spinner spinnerWeapon;
    Button buttonAdd, buttonUpdate;
    ListView listViewSpecies;
    List<Species> speciesList;
    ArrayAdapter<Species> adapter;
    int updaterId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            // TODO:
            // 1. database in app inspect
            // 2. input data from form
            // 3. show from listview
            // 3.5 show only some items (like from checkbox or sum idunno)
            // 4. long press listview deleting
            // 5. short press update
            // 6. alertDialog to confirm deletion
            // 7. Meow meow meow meow meow meow meow meow meow meow :3c
        });
        editTextName = findViewById(R.id.editTextName);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextAimSpeed = findViewById(R.id.editTextAimSpeed);
        editTextReloadSpeed = findViewById(R.id.editTextReloadSpeed);
        editTextMoveSpeed = findViewById(R.id.editTextMoveSpeed);
        editTextHealth = findViewById(R.id.editTextHealth);
        spinnerWeapon = findViewById(R.id.spinnerWeapon);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        listViewSpecies = findViewById(R.id.listViewSpecies);

        SpeciesDatabase speciesDatabase = Room.databaseBuilder(getApplicationContext(),SpeciesDatabase.class,"species_db").allowMainThreadQueries().build();

        speciesList = speciesDatabase.returnSpeciesDAO().returnAllSpecies();

        adapter = new ArrayAdapter<Species>(this, android.R.layout.simple_list_item_1, speciesList);
        listViewSpecies.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Species species = new Species(
                        editTextName.getText().toString(),
                        editTextDescription.getText().toString(),
                        Integer.parseInt(editTextAimSpeed.getText().toString()),
                        Integer.parseInt(editTextReloadSpeed.getText().toString()),
                        Integer.parseInt(editTextMoveSpeed.getText().toString()),
                        Integer.parseInt(editTextHealth.getText().toString()),
                        spinnerWeapon.getSelectedItem().toString()
                );
                speciesDatabase.returnSpeciesDAO().insertSpeciesToDB(species);

                speciesList.add(species);

                adapter.notifyDataSetChanged();
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Species species = new Species(
                        editTextName.getText().toString(),
                        editTextDescription.getText().toString(),
                        Integer.parseInt(editTextAimSpeed.getText().toString()),
                        Integer.parseInt(editTextReloadSpeed.getText().toString()),
                        Integer.parseInt(editTextMoveSpeed.getText().toString()),
                        Integer.parseInt(editTextHealth.getText().toString()),
                        spinnerWeapon.getSelectedItem().toString()
                );
                species.id = updaterId;

                buttonUpdate.setVisibility(View.GONE);
                buttonAdd.setVisibility(View.VISIBLE);

                speciesDatabase.returnSpeciesDAO().updateSpecies(species);

                speciesList = speciesDatabase.returnSpeciesDAO().returnAllSpecies();
                adapter.notifyDataSetChanged();
            }
        });

        listViewSpecies.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                speciesDatabase.returnSpeciesDAO().deleteFromDB(speciesList.get(i));

                speciesList.remove(i);

                adapter.notifyDataSetChanged();

                return false;
            }
        });

        listViewSpecies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Species species = speciesDatabase.returnSpeciesDAO().returnAllSpecies().get(i);

                editTextName.setText(species.name.toString());
                editTextDescription.setText(species.description.toString());
                editTextAimSpeed.setText("" + species.aimSpeed);
                editTextReloadSpeed.setText("" + species.reloadSpeed);
                editTextMoveSpeed.setText("" + species.moveSpeed);
                editTextHealth.setText("" + species.health);
                updaterId = species.id;

                buttonUpdate.setVisibility(View.VISIBLE);
                buttonAdd.setVisibility(View.GONE);
            }
        });


    }
}