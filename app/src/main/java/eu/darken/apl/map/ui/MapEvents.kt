package eu.darken.apl.map.ui

import eu.darken.apl.watch.core.types.AircraftWatch

sealed interface MapEvents {

    data object RequestLocationPermission : MapEvents
    data object HomeMap : MapEvents
    data class WatchAdded(val watch: AircraftWatch.Status) : MapEvents

}