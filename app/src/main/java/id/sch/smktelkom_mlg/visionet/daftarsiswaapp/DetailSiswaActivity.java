package id.sch.smktelkom_mlg.visionet.daftarsiswaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
   /*             + siswa.kelas + "/" + siswa.noAbsen + "\n"
                + siswa.tempatLahir + ","
                + DateFormat.format("dd MMMMM yyyy", siswa.tglLahir) + "\n"
                + siswa.nis + "\n"
   */ + siswa.alamat + "\n");

        setTitle(siswa.nama);

        ivFoto.setImageResource(R.drawable.ic_assignment_black_24dp);

    }
}
