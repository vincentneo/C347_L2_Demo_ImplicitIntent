package sg.edu.rp.c347.id19007966.demoimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonEmail, buttonRP;
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEmail = findViewById(R.id.buttonEmail);
        buttonRP = findViewById(R.id.buttonRP);
        editTextMessage = findViewById(R.id.editTextMessage);

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                String[] emailAddress = {"vincent-neo@outlook.sg"};
                String subject = "Test Email from C347";
                String contents = editTextMessage.getText().toString();

                emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, contents);

                emailIntent.setType("message/rfc822");

                startActivity(Intent.createChooser(emailIntent, "Choose an email client: "));
            }
        });

        buttonRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("https://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

    }
}