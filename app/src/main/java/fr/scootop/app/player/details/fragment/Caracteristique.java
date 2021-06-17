package fr.scootop.app.player.details.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import fr.scootop.R;
import fr.scootop.RadarActivity;
import fr.scootop.app.comparator.ComparatorActivity;
import fr.scootop.app.radarcharts.custom.RadarMarkerView;

public class Caracteristique extends Fragment {


    private RadarChart chart;
    private static final int PERMISSION_STORAGE = 0;
    public Button CompareBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.row_fiche_player_carateristique, container,false);

        chart = view.findViewById(R.id.chart1);
        chart.setBackgroundColor(Color.rgb(60, 65, 82));

        chart.getDescription().setEnabled(false);

        chart.setWebLineWidth(1f);
        chart.setWebColor(Color.LTGRAY);
        chart.setWebLineWidthInner(1f);
        chart.setWebColorInner(R.color.colorPrimary);
        chart.setWebAlpha(100);

        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
        MarkerView mv = new RadarMarkerView(getActivity().getApplicationContext(), R.layout.radar_markerview);
        mv.setChartView(chart); // For bounds control
        chart.setMarker(mv); // Set the marker to the chart

        setData();

        chart.animateXY(1400, 1400, Easing.EaseInOutQuad);

        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(9f);
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter() {

            private final String[] mActivities = new String[]{"Technique", "Athletique", "Physique", "Mental", "Speed"};


            @Override
            public String getFormattedValue(float value) {
                return mActivities[(int) value % mActivities.length];
            }
        });

        xAxis.setTextColor(Color.WHITE);

        YAxis yAxis = chart.getYAxis();
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(9f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        yAxis.setDrawLabels(false);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        CompareBtn = view.findViewById(R.id.CompareButton);

        CompareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ComparateIntent = new Intent(getActivity().getApplicationContext(), ComparatorActivity.class);
                startActivity(ComparateIntent);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull  MenuInflater inflater) {

        inflater.inflate(R.menu.radar2,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    public static Caracteristique getInstance(){

    Caracteristique caracteristiqueFragment = new Caracteristique();
    return caracteristiqueFragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.actionToggleValues: {
                for (IDataSet<?> set : chart.getData().getDataSets())
                    set.setDrawValues(!set.isDrawValuesEnabled());

                chart.invalidate();
                break;
            }
            case R.id.actionToggleHighlight: {
                if (chart.getData() != null) {
                    chart.getData().setHighlightEnabled(!chart.getData().isHighlightEnabled());
                    chart.invalidate();
                }
                break;
            }

            case R.id.actionToggleFilled: {

                ArrayList<IRadarDataSet> sets = (ArrayList<IRadarDataSet>) chart.getData()
                        .getDataSets();

                for (IRadarDataSet set : sets) {
                    if (set.isDrawFilledEnabled())
                        set.setDrawFilled(false);
                    else
                        set.setDrawFilled(true);
                }
                chart.invalidate();
                break;
            }

            case R.id.actionToggleYLabels: {

                chart.getYAxis().setEnabled(!chart.getYAxis().isEnabled());
                chart.invalidate();
                break;
            }

        }
        return true;
    }




    private void setData() {

        float mul = 80;
        float min = 20;
        int cnt = 5;

        ArrayList<RadarEntry> entries1 = new ArrayList<>();
        ArrayList<RadarEntry> entries2 = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < cnt; i++) {
            float val1 = (float) (Math.random() * mul) + min;
            entries1.add(new RadarEntry(val1));

            float val2 = (float) (Math.random() * mul) + min;
            entries2.add(new RadarEntry(val2));
        }

        RadarDataSet set1 = new RadarDataSet(entries1, "Moussa SISSOKO");
        set1.setColor(Color.rgb(103, 110, 129));
        set1.setFillColor(Color.rgb(103, 110, 129));
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(false);

        RadarDataSet set2 = new RadarDataSet(entries2, "Renato SANCHEZ");
        set2.setColor(Color.rgb(121, 162, 175));
        set2.setFillColor(Color.rgb(121, 162, 175));
        set2.setDrawFilled(true);
        set2.setFillAlpha(180);
        set2.setLineWidth(2f);
        set2.setDrawHighlightCircleEnabled(true);
        set2.setDrawHighlightIndicators(false);

        ArrayList<IRadarDataSet> sets = new ArrayList<>();
        sets.add(set1);
        sets.add(set2);

        RadarData data = new RadarData(sets);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);

        chart.setData(data);
        chart.invalidate();

    }


    protected void requestStoragePermission(View view) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Snackbar.make(view, "Write permission is required to save image to gallery", Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_STORAGE);
                        }
                    }).show();
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Permission Required!", Toast.LENGTH_SHORT)
                    .show();
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_STORAGE);
        }
    }

    protected void saveToGallery(Chart chart, String name) {
        if (chart.saveToGallery(name + "_" + System.currentTimeMillis(), 70))
            Toast.makeText(getActivity().getApplicationContext(), "Saving SUCCESSFUL!",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getActivity().getApplicationContext(), "Saving FAILED!", Toast.LENGTH_SHORT)
                    .show();
    }

    protected void saveToGallery() {
        saveToGallery(chart, "RadarChartActivity");
    }



}
