package id.sch.smktelkom_mlg.visionet.daftarsiswaapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smktelkom_mlg.visionet.daftarsiswaapp.model.Siswa;

public class DetailSiswaActivity extends AppCompatActivity {
    @BindView(R.id.textViewData)
    TextView tvSiswa;
    @BindView(R.id.imageViewFoto)
    ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_siswa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        Siswa siswa = (Siswa) getIntent().getSerializableExtra(MainActivity.SISWA);
        tvSiswa.setText(siswa.nama + "\n"
                + siswa.kelas + "/" + siswa.noAbsen + "\n"
                + siswa.tempatLahir + ","
                + DateFormat.format("dd MMMMM yyyy", siswa.tglLahir) + "\n"
                + siswa.nis + "\n"
                + siswa.alamat + "\n");

        setTitle(siswa.nama);

        ivFoto.setImageResource(R.mipmap.ic_launcher);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
