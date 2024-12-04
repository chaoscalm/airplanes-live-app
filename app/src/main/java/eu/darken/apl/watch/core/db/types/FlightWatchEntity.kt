package eu.darken.apl.watch.core.db.types

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import eu.darken.apl.main.core.aircraft.Callsign
import eu.darken.apl.watch.core.WatchId

@Entity(
    tableName = "watch_flight",
    foreignKeys = [
        ForeignKey(
            entity = BaseWatchEntity::class,
            parentColumns = ["id"],
            childColumns = ["id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FlightWatchEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: WatchId,
    @ColumnInfo(name = "callsign") val callsign: Callsign,
) : WatchType {
    companion object {
        const val TYPE_KEY = "flight"
    }
}