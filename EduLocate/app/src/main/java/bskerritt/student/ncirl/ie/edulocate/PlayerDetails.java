package bskerritt.student.ncirl.ie.edulocate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// https://www.youtube.com/watch?v=EM2x33g4syY
public class PlayerDetails extends AppCompatActivity {

    EditText etName;
    Button playBtn;

    DatabaseReference dbPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);

        etName = (EditText) findViewById(R.id.enterName);
        playBtn = (Button) findViewById(R.id.playGameBtn);

        dbPlayers = FirebaseDatabase.getInstance().getReference("players");

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();

                if (!TextUtils.isEmpty(name)) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(PlayerDetails.this, "Please enter your name!", Toast.LENGTH_SHORT).show();
                }

                addPlayer();
            }
        });
    }

    private void addPlayer() {
        String name = etName.getText().toString().trim();

        if (!TextUtils.isEmpty(name)) {

            String id = dbPlayers.push().getKey();
            Player player = new Player(id, name, false);
            dbPlayers.child(id).setValue(player);
            etName.setText("");
            Toast.makeText(this, "Player added!", Toast.LENGTH_SHORT).show();
        }
    }
}
