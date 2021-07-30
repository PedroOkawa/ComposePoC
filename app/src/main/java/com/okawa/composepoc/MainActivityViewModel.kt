package com.okawa.composepoc

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.okawa.composepoc.livedata.SingleLiveEvent
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {

    private val _uiEvent = SingleLiveEvent<UiEvent>()
    val uiEvent: LiveData<UiEvent> = _uiEvent

    fun openLive() {
        _uiEvent.postValue(UiEvent.GoToLive)
    }

    fun openSchedule() {
        _uiEvent.postValue(UiEvent.GoToSchedule)
    }

    fun close() {
        _uiEvent.postValue(UiEvent.Close)
    }

    sealed class UiEvent {
        object GoToLive: UiEvent()
        object GoToSchedule: UiEvent()
        object Close: UiEvent()
    }
}