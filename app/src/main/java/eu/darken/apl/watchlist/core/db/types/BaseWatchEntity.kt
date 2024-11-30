package eu.darken.apl.watchlist.core.db.types

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import eu.darken.apl.watchlist.core.WatchId
import eu.darken.apl.watchlist.core.makeWatchId
import java.time.Instant

@Entity(tableName = "watch_base")
data class BaseWatchEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: WatchId = makeWatchId(),
    @ColumnInfo(name = "created_at") val createdAt: Instant = Instant.now(),
    @ColumnInfo(name = "type") val watchType: String,

    @ColumnInfo(name = "user_note") val userNote: String = "",

    @ColumnInfo(name = "location_latitude") val latitude: Double? = null,
    @ColumnInfo(name = "location_longitude") val longitude: Double? = null,
    @ColumnInfo(name = "location_radius") val radius: Float? = null,
)
