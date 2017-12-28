package com.yaroslavtupalo.nasa_neows.model.moshi

import android.annotation.SuppressLint
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by Yaroslav on 22.12.2017.
 */

data class CloseApproachDatum (
        @Json(name = "close_approach_date")
        var closeApproachDate: String,
        @Json(name = "epoch_date_close_approach")
        var epochDateCloseApproach: Long,
        @Json(name = "relative_velocity")
        var relativeVelocity: RelativeVelocity,
        @Json(name = "miss_distance")
        var missDistance: MissDistance,
        @Json(name = "orbiting_body")
        var orbitingBody: String
)

data class EstimatedDiameter(
        @Json(name = "kilometers")
        var kilometers: Kilometers,
        @Json(name = "meters")
        var meters: Meters,
        @Json(name = "miles")
        var miles: Miles,
        @Json(name = "feet")
        var feet: Feet
)

data class Example(
        @Json(name = "links")
        var links: Links,
        @Json(name = "neo_reference_id")
        var neoReferenceId: String,
        @Json(name = "name")
        var name: String,
        @Json(name = "nasa_jpl_url")
        var nasaJplUrl: String,
        @Json(name = "absolute_magnitude_h")
        var absoluteMagnitudeH: Double,
        @Json(name = "estimated_diameter")
        var estimatedDiameter: EstimatedDiameter,
        @Json(name = "is_potentially_hazardous_asteroid")
        var isPotentiallyHazardousAsteroid: Boolean,
        @Json(name = "close_approach_data")
        var closeApproachData: List<CloseApproachDatum>? = null,
        @Json(name = "orbital_data")
        var orbitalData: OrbitalData
)

data class Feet (
        @Json(name = "estimated_diameter_min")
        var estimatedDiameterMin: Double,
        @Json(name = "estimated_diameter_max")
        var estimatedDiameterMax: Double
)

data class Kilometers (
        @Json(name = "estimated_diameter_min")
        var estimatedDiameterMin: Double,
        @Json(name = "estimated_diameter_max")
        var estimatedDiameterMax: Double
)

data class Links (
        @Json(name = "self")
        var self: String
)

data class Meters (
        @Json(name = "estimated_diameter_min")
        var estimatedDiameterMin: Double,
        @Json(name = "estimated_diameter_max")
        var estimatedDiameterMax: Double
)

data class Miles (
        @Json(name = "estimated_diameter_min")
        var estimatedDiameterMin: Double,
        @Json(name = "estimated_diameter_max")
        var estimatedDiameterMax: Double
)

data class MissDistance (
        @Json(name = "astronomical")
        var astronomical: String,
        @Json(name = "lunar")
        var lunar: String,
        @Json(name = "kilometers")
        var kilometers: String,
        @Json(name = "miles")
        var miles: String
)

data class OrbitalData (
        @Json(name = "orbit_id")
        var orbitId: String,
        @Json(name = "orbit_determination_date")
        var orbitDeterminationDate: String,
        @Json(name = "orbit_uncertainty")
        var orbitUncertainty: String,
        @Json(name = "minimum_orbit_intersection")
        var minimumOrbitIntersection: String,
        @Json(name = "jupiter_tisserand_invariant")
        var jupiterTisserandInvariant: String,
        @Json(name = "epoch_osculation")
        var epochOsculation: String,
        @Json(name = "eccentricity")
        var eccentricity: String,
        @Json(name = "semi_major_axis")
        var semiMajorAxis: String,
        @Json(name = "inclination")
        var inclination: String,
        @Json(name = "ascending_node_longitude")
        var ascendingNodeLongitude: String,
        @Json(name = "orbital_period")
        var orbitalPeriod: String,
        @Json(name = "perihelion_distance")
        var perihelionDistance: String,
        @Json(name = "perihelion_argument")
        var perihelionArgument: String,
        @Json(name = "aphelion_distance")
        var aphelionDistance: String,
        @Json(name = "perihelion_time")
        var perihelionTime: String,
        @Json(name = "mean_anomaly")
        var meanAnomaly: String,
        @Json(name = "mean_motion")
        var meanMotion: String,
        @Json(name = "equinox")
        var equinox: String
)

data class RelativeVelocity (
        @Json(name = "kilometers_per_second")
        var kilometersPerSecond: String,
        @Json(name = "kilometers_per_hour")
        var kilometersPerHour: String,
        @Json(name = "miles_per_hour")
        var milesPerHour: String
)