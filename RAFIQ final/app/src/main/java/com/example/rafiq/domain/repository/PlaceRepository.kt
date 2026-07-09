package com.example.rafiq.domain.repository

import com.example.rafiq.data.local.EquippedPlaceEntity
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    fun getAllPlaces(): Flow<List<EquippedPlaceEntity>>
    suspend fun insertPlace(place: EquippedPlaceEntity)
}
