package id.sch.smktelkom_mlg.visionet.daftarsiswaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.sch.smktelkom_mlg.visionet.daftarsiswaapp.model.Siswa;

public class InputActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_PHOTO = 99;
    @BindView(R.id.editTextNama)
    EditText etNama;
    @BindView(R.id.editTextAlamat)
    EditText etAlamat;

    /*@BindView(R.id.imageViewFoto)
    ImageView ivFoto;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonSImpan)
    public void doSimpan() {
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();

        boolean valid = true;
        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat belum diisi");
            valid = false;
        }

        if (valid) {
            Siswa siswa = new Siswa();
            siswa.nama = nama;
            siswa.alamat = alamat;

            Intent intent = new Intent();
            intent.putExtra(MainActivity.SISWA, siswa);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
/*

    @OnClick(R.id.imageViewFoto)
    public void capturePhoto()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent, REQUEST_CODE_PHOTO);
    }
*/

  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PHOTO && resultCode == RESULT_OK)
        {
            Bitmap bitmap = data.getParcelableExtra("data");
            ivFoto.setImageBitmap(bitmap);
        }
    }
*/

}
