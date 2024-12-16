package com.example.simpleweatherapp.domain.mapper

import com.example.simpleweatherapp.data.model.*
import com.example.simpleweatherapp.domain.model.*

fun WeatherModelDto.toDomainModel(): WeatherModel {
    return WeatherModel(
        current = current.toDomainModel(),
        location = location.toDomainModel()
    )
}

fun CurrentDto.toDomainModel(): Current {
    return Current(
        cloud = cloud,
        condition = condition.toDomainModel(),
        dewpoint_c = dewpoint_c,
        dewpoint_f = dewpoint_f,
        feelslike_c = feelslike_c,
        feelslike_f = feelslike_f,
        gust_kph = gust_kph,
        gust_mph = gust_mph,
        heatindex_c = heatindex_c,
        heatindex_f = heatindex_f,
        humidity = humidity,
        is_day = is_day,
        last_updated = last_updated,
        last_updated_epoch = last_updated_epoch,
        precip_in = precip_in,
        precip_mm = precip_mm,
        pressure_in = pressure_in,
        pressure_mb = pressure_mb,
        temp_c = temp_c,
        temp_f = temp_f,
        uv = uv,
        vis_km = vis_km,
        vis_miles = vis_miles,
        wind_degree = wind_degree,
        wind_dir = wind_dir,
        wind_kph = wind_kph,
        wind_mph = wind_mph,
        windchill_c = windchill_c,
        windchill_f = windchill_f
    )
}

fun ConditionDto.toDomainModel(): Condition {
    return Condition(
        code = code,
        icon = icon,
        text = text
    )
}

fun LocationDto.toDomainModel(): Location {
    return Location(
        country = country,
        lat = lat,
        localtime = localtime,
        localtime_epoch = localtime_epoch,
        lon = lon,
        name = name,
        region = region,
        tz_id = tz_id
    )
}
