package delatorre5510.spring19.cop4656.floridapoly.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NoteTakingController extends AppCompatActivity {

    TextView welcome;
    Button save;
    EditText input;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_taker);

        welcome = (TextView)findViewById(R.id.welcomeText);
        save = (Button)findViewById(R.id.saveButton);
        input = (EditText)findViewById(R.id.noteInput);
        cancel = (Button)findViewById(R.id.cancelButton);

        welcome.setText("Hello " + getText(R.string.name) + ", please enter your name");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = input.getText().toString().trim();
                if(userInput.length() == 0){
                    Toast.makeText(getApplicationContext(), "Where's the note?!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent newNoteIntent = new Intent(NoteTakingController.this, MainActivity.class);
                    newNoteIntent.putExtra("Note", userInput);
                    startActivity(newNoteIntent);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
