package com.example.demo.Model;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class GeoIpLocationService {

    private DatabaseReader databaseReader;


    public GeoIpLocationService() throws IOException {

        File database = new File("location/GeoLiteCity.mmdb");

        databaseReader = new  DatabaseReader.Builder(database).build();
    }


    public  GeoIP getLocation(String iP) throws IOException, GeoIp2Exception {
        InetAddress iPAddress = InetAddress.getByName(iP);
        CityResponse response = databaseReader.city(iPAddress);

        String cityName = response.getCity().getName();
        String latitude = response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();

        return  new GeoIP(iP,cityName,latitude,longitude);
    }

}

