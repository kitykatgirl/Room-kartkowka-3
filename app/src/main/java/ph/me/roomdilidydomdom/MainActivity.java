package ph.me.roomdilidydomdom;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }
}