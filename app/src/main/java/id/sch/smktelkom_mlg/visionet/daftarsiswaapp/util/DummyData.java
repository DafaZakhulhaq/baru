package id.sch.smktelkom_mlg.visionet.daftarsiswaapp.util;

import java.util.ArrayList;
import java.util.Date;

import id.sch.smktelkom_mlg.visionet.daftarsiswaapp.model.Siswa;

/**
 * Created by hyuam on 24/09/2016.
 */

public class DummyData {
    public static ArrayList<Siswa> getDataSiswa() {
        ArrayList<Siswa> list = new ArrayList<>();

        Siswa siswa = new Siswa();
        siswa.nama = "Agus";
        siswa.kelas = "XIRPL1";
        siswa.noAbsen = 12;
        siswa.nis = "1211/1212.121";
        siswa.tempatLahir = "Malang";
        siswa.tglLahir = new Date(1998, 12, 5);
        siswa.alamat = "Jl. sdsdsds 23";
        siswa.foto = "";

        list.add(siswa);

        siswa = new Siswa("Budi", "XIRPL1", (byte) 11, "1211/1212.090",
                "Malang", new Date(1997, 11, 15), "Jl. sdsds 12", "");

        list.add(siswa);

        return list;
    }

    public static void isiDataSiswa() {
        Siswa siswa = new Siswa();
        siswa.nama = "Agus";
        siswa.kelas = "XIRPL1";
        siswa.noAbsen = 12;
        siswa.nis = "1211/1212.121";
        siswa.tempatLahir = "Malang";
        siswa.tglLahir = new Date(1998, 12, 5);
        siswa.alamat = "Jl. sdsdsds 23";
        siswa.foto = "";
        siswa.save();

        siswa = new Siswa("Budi", "XIRPL1", (byte) 11, "1211/1212.090",
                "Malang", new Date(1997, 11, 15), "Jl. sdsds 12", "");
        siswa.save();
    }
}
