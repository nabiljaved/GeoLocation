package com.nabeeltech.geolocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewMap extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;
    Double lat, lng;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);

        extras = getIntent().getExtras();
        lat = extras.getDouble("latitute");
        lng = extras.getDouble("longitute");

        mapView = findViewById(R.id.mapView);
        Bundle mapViewBundle = null;
        if(mapViewBundle==null){
            mapViewBundle = savedInstanceState.getBundle(getResources().getString(R.string.google_map_key));
        }
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng currentplace = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(currentplace).title("Marker in karachi"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentplace, 15.0f));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(currentplace));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Bundle mapViewBundle = outState.getBundle(getResources().getString(R.string.google_map_key));
        if(mapViewBundle==null){
            mapViewBundle = new Bundle();
            outState.putBundle(getResources().getString(R.string.google_map_key), mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
