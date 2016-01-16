package com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.service;

import com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.RTInterface.RTService;
import com.example.logic_error.comingsoon.config.Config;

import retrofit.RestAdapter;

/**
 * Created by logic_error on 1/11/16.
 */
public class RottenTomatoes {


    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder().setEndpoint(Config.API_URL).build();
    private static final RTService SERVICE = REST_ADAPTER.create(RTService.class);

    public static RTService getService() {
        return SERVICE;
    }
}
