package id.sch.smktelkom_mlg.visionet.daftarsiswaapp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hyuam on 24/09/2016.
 */

@Table(name = "Siswa")
public class Siswa extends Model implements Serializable {
    @Column
    public String nama;
    @Column
    public String alamat;
    @Column
    public String foto;

    public Siswa() {
        super();
    }

    public Siswa(String nama, String alamat, String foto) {
        super();
        this.nama = nama;
        this.alamat = alamat;
        this.foto = foto;
    }

    public static List<Siswa> getAll() {
        return new Select()
                .from(Siswa.class)
                .orderBy("nama ASC")
                .execute();
    }
}
