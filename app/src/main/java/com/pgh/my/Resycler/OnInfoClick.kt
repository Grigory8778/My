package com.pgh.my.Resycler

import android.view.View

interface OnInfoClick {
    fun onClickListener(view: View, lat: String, lon: String)
}