package com.example.pp;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GyogyszertarKeresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszertarKeresFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;
    private LatLng currentLocation;

    public GyogyszertarKeresFragment() {
        // Required empty public constructor
    }

    public static GyogyszertarKeresFragment newInstance() {
        GyogyszertarKeresFragment fragment = new GyogyszertarKeresFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gyogyszertar_keres, container, false);

        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // A googleMap készen áll a használatra. Itt adhatja hozzá a kívánt térképi elemeket.
        /*String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + currentLocation.latitude + "," + currentLocation.longitude + "&radius=5000&type=pharmacy&key=" + "AIzaSyBlRYsVtIkknjJ6PZ88e9PymA5MaWzbtPk";
        new FetchPlaces().execute(url);*/
    }
    private class FetchPlaces extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                String url = strings[0];
                URL obj = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
                conn.setReadTimeout(5000);
                conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
                conn.addRequestProperty("User-Agent", "Mozilla/5.0");
                conn.addRequestProperty("Referer", "https://maps.googleapis.com/");
                int responseCode = conn.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    return response.toString();
                } else {
                    return "{'error':'Response code: " + responseCode + "'}";
                }
            } catch (IOException e) {
                return e.toString();
            }
        }
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                if (jsonObject.has("error")) {
                    Toast.makeText(getActivity(), "Error: " + jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                } else {
                    JSONArray results = jsonObject.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject result = results.getJSONObject(i);
                        if (result.has("geometry")) {
                            JSONObject geometry = result.getJSONObject("geometry");
                            if (geometry.has("location")) {
                                JSONObject location = geometry.getJSONObject("location");
                                LatLng latLng = new LatLng(location.getDouble("lat"), location.getDouble("lng"));
                                mMap.addMarker(new MarkerOptions().position(latLng).title(result.getString("name")));
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                Toast.makeText(getActivity(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }


}