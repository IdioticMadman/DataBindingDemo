package com.robert.databindingdemo

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableInt

class User : BaseObservable() {
    @get:Bindable
    var firstName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }
    @get:Bindable
    var lastName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }
    var age = ObservableInt()
}