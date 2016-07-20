package com.example.renesansz.databinding;

public class MainActivityPresenter {

    private MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {

        this.view = view;

    }

    public void onShowData(TemperatureData temperatureData) {

        view.showData(temperatureData);

    }

}
