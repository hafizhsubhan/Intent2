package id.sch.smktelkom_mlg.learn.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class InputActivity extends AppCompatActivity {

    public static final String NAMA = "Nama";
    public static final String TAHUN_LAHIR = "TahunLahir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        findViewById(R.id.buttonFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNama = (EditText) findViewById(R.id.editTextNama);
                EditText etThnLhr = (EditText) findViewById(R.id.editTextThnLhr);
                String nama = etNama.getText().toString();
                String ThnLhrStr = etThnLhr.getText().toString();

                int ThnLhr = ThnLhrStr.isEmpty() ?
                        Calendar.getInstance().get(Calendar.YEAR) :
                        Integer.parseInt(ThnLhrStr);

                Intent intent = new Intent();
                intent.putExtra(NAMA, nama);
                intent.putExtra(TAHUN_LAHIR, ThnLhr);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
