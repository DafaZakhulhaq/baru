package id.sch.smktelkom_mlg.visionet.daftarsiswaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.visionet.daftarsiswaapp.adapter.SiswaAdapter;
import id.sch.smktelkom_mlg.visionet.daftarsiswaapp.model.Siswa;
import id.sch.smktelkom_mlg.visionet.daftarsiswaapp.util.DummyData;

public class MainActivity extends AppCompatActivity implements SiswaAdapter.ISiswaAdapter {
    public static final String SISWA = "siswa";
    public static final int REQUEST_CODE = 88;
    SiswaAdapter adapter;
    ArrayList<Siswa> list;
    int itemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                addSiswa();
            }
        });


        if (Siswa.getAll().size() == 0)
            DummyData.isiDataSiswa();
        initRecyclerView();

    }

/*

    @OnClick(R.id.imageButton)
    public void hapus(final int position ) {

        final Siswa siswa = list.get(position);
        list.remove(position);
        adapter.notifyDataSetChanged();

        RecyclerView rvSiswa = (RecyclerView) findViewById(R.id.recyclerViewSiswa);
        Snackbar.make(rvSiswa,"Batal Menghapus ?",Snackbar.LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        refreshData();
                        //list.add(position,siswa);
                        //adapter.notifyDataSetChanged();
                    }
                })
                .setCallback(new Snackbar.Callback()
                {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event)
                    {
                        super.onDismissed(snackbar, event);
                        if(event != DISMISS_EVENT_ACTION)
                        {
                            refreshData();
                            Siswa siswa = list.get(position);
                            siswa.delete();
                            refreshData();
                        }
                    }
                })
                .show();

    }
*/


    @Override
    public void doDelete(final int position) {

        final Siswa siswa = list.get(position);
        list.remove(position);
        adapter.notifyDataSetChanged();
        RecyclerView rvSiswa = (RecyclerView) findViewById(R.id.recyclerViewSiswa);
        Snackbar.make(rvSiswa, "Batal Menghapus ?", Snackbar.LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshData();
                        //list.add(position,siswa);
                        //adapter.notifyDataSetChanged();
                    }
                })
                .setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                        if (event != DISMISS_EVENT_ACTION) {
                            refreshData();
                            Siswa siswa = list.get(position);
                            siswa.delete();
                            refreshData();
                        }
                    }
                })
                .show();
    }


    private void addSiswa() {

        startActivityForResult(new Intent(this, InputActivity.class), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Siswa siswa = (Siswa) data.getSerializableExtra(MainActivity.SISWA);
                siswa.save();
                //list.add(siswa);
                refreshData();
            }
        }
    }

    private void refreshData() {
        list.clear();
        list.addAll(Siswa.getAll());
        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        RecyclerView rvSiswa = (RecyclerView) findViewById(R.id.recyclerViewSiswa);
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        rvSiswa.setLayoutManager(llManager);
        list = new ArrayList<>();
        list.addAll(Siswa.getAll());
        adapter = new SiswaAdapter(this, list);
        rvSiswa.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClick(Siswa siswa) {
        Intent intent = new Intent(this, DetailSiswaActivity.class);
        intent.putExtra(SISWA,siswa);
        startActivity(intent);
    }


    @Override
    public void itemLongClick(final int position) {
/*
        final Siswa siswa = list.get(position);
        list.remove(position);
        adapter.notifyDataSetChanged();

        RecyclerView rvSiswa = (RecyclerView) findViewById(R.id.recyclerViewSiswa);
        Snackbar.make(rvSiswa,"Batal Menghapus ?",Snackbar.LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        refreshData();
                        //list.add(position,siswa);
                        //adapter.notifyDataSetChanged();
                    }
                })
                .setCallback(new Snackbar.Callback()
                {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event)
                    {
                        super.onDismissed(snackbar, event);
                        if(event != DISMISS_EVENT_ACTION)
                        {
                            refreshData();
                            Siswa siswa = list.get(position);
                            siswa.delete();
                            refreshData();
                        }
                    }
                })
                .show();
*/
    }

}
