package com.sf.weather.ui.main

interface Contract {
    interface View {
    }

    interface MainPresenter {
        fun getAdapter(): MeiziListAdapter
    }
}