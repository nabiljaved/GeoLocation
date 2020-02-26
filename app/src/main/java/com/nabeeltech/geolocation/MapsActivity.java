package com.nabeeltech.geolocation;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double lat, lng;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        extras = getIntent().getExtras();
        lat = extras.getDouble("latitute");
        lng = extras.getDouble("longitute");

        Toast.makeText(this, "lat :"+lat+"  "+"lng : "+lng, Toast.LENGTH_SHORT).show();
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
}
