package delatorre5510.spring19.cop4656.floridapoly.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button takeNoteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takeNoteButton = findViewById(R.id.button);

        Intent noteIntent = getIntent();
        if(noteIntent != null){
            String note = noteIntent.getStringExtra("Note");
            Toast.makeText(getApplicationContext(),note , Toast.LENGTH_LONG).show();
        }


        takeNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noteTaker = new Intent(MainActivity.this, NoteTakingController.class);
                startActivity(noteTaker);
            }
        });
    }
}
