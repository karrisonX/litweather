package com.lee.litweather.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.lee.litweather.logic.model.Place
import com.lee.litweather.logic.network.LitWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = LitWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e:Exception) {
            Result.failure<List<Place>>(e)

        }
        emit(result)
    }
}