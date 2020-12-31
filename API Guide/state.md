# State

Although there are a few state APIs, we only bother with the "vehicle_data" endpoint since it returns most of the state data about the car.

## Vehicle Data

## GET `/api/1/vehicles/{id}/vehicle_data`

A rollup of all the `data_request` endpoints plus vehicle configuration.

_Note:_ all `*_range` values are in miles, irrespective of GUI configuration.

## Before Wake Up
The API will error out if you try to get vehicle data before [waking up](main.md#wake-up) the car.

### Mac cURL Request
```shell script
curl --request GET --header 'Authorization: Bearer <auth_token_goes_here>' 'https:/owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/vehicle_data'
```

### Windows cURL Request
```shell script
curl --request POST --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/vehicle_data"
```

### Request Parameters
None

### Response
At this point, we would get back this error because the car is not awake:

```json
{"response":null,"error":"vehicle unavailable: {:error=>\"vehicle unavailable:\"}","error_description":""}
```

## After Wake Up
After Calling [Wake Up](main.md#Wake Up), wait for several seconds until the car is actually online and ready to receive other commands. One way to deal with this is to call this endpoint in a loop until the returned state says "online", with a timeout to give up. In some cases, the wake up can be slow, so consider using a timeout of at least 30 seconds.

### Response

```json
{
  "response": {
    "id": 444599333514111111,
    "user_id": 1306154,
    "vehicle_id": 1585365901,
    "vin": "5JJJEJEA0006JJEFD",
    "display_name": "Car Name",
    "option_codes": "AD15,MDL3,PBSB,RENA,BT37,ID3W,RF3G,S3PB,DRLH,DV2W,W39B,APF0,COUS,BC3B,CH07,PC30,FC3P,FG31,GLFR,HL31,HM31,IL31,LTPB,MR31,FM3B,RS3H,SA3P,STCP,SC04,SU3C,T3CA,TW00,TM00,UT3P,WR00,AU3P,APH3,AF00,ZCST,MI00,CDM0",
    "color": null,
    "tokens": [
      "bbbaaaa673331121",
      "b29222a83331zzz1"
    ],
    "state": "online",
    "in_service": false,
    "id_s": "16161671604116161",
    "calendar_enabled": true,
    "api_version": 7,
    "backseat_token": null,
    "backseat_token_updated_at": null,
    "charge_state": {
      "battery_heater_on": false,
      "battery_level": 89,
      "battery_range": 220.22,
      "charge_current_request": 32,
      "charge_current_request_max": 32,
      "charge_enable_request": true,
      "charge_energy_added": 29.93,
      "charge_limit_soc": 90,
      "charge_limit_soc_max": 100,
      "charge_limit_soc_min": 50,
      "charge_limit_soc_std": 90,
      "charge_miles_added_ideal": 143.0,
      "charge_miles_added_rated": 143.0,
      "charge_port_cold_weather_mode": false,
      "charge_port_door_open": true,
      "charge_port_latch": "Engaged",
      "charge_rate": 0.0,
      "charge_to_max_range": false,
      "charger_actual_current": 0,
      "charger_phases": 1,
      "charger_pilot_current": 32,
      "charger_power": 0,
      "charger_voltage": 2,
      "charging_state": "Complete",
      "conn_charge_cable": "SAE",
      "est_battery_range": 200.05,
      "fast_charger_brand": "<invalid>",
      "fast_charger_present": false,
      "fast_charger_type": "ACSingleWireCAN",
      "ideal_battery_range": 220.22,
      "managed_charging_active": false,
      "managed_charging_start_time": null,
      "managed_charging_user_canceled": false,
      "max_range_charge_counter": 0,
      "minutes_to_full_charge": 0,
      "not_enough_power_to_heat": null,
      "scheduled_charging_pending": false,
      "scheduled_charging_start_time": null,
      "time_to_full_charge": 0.0,
      "timestamp": 1589242930863,
      "trip_charging": false,
      "usable_battery_level": 89,
      "user_charge_enable_request": null
    },
    "climate_state": {
      "battery_heater": false,
      "battery_heater_no_power": null,
      "climate_keeper_mode": "off",
      "defrost_mode": 0,
      "driver_temp_setting": 20.0,
      "fan_status": 0,
      "inside_temp": 22.8,
      "is_auto_conditioning_on": false,
      "is_climate_on": false,
      "is_front_defroster_on": false,
      "is_preconditioning": false,
      "is_rear_defroster_on": false,
      "left_temp_direction": 464,
      "max_avail_temp": 28.0,
      "min_avail_temp": 15.0,
      "outside_temp": 21.5,
      "passenger_temp_setting": 20.0,
      "remote_heater_control_enabled": false,
      "right_temp_direction": 464,
      "seat_heater_left": 0,
      "seat_heater_right": 0,
      "side_mirror_heaters": false,
      "timestamp": 1589242930863,
      "wiper_blade_heater": false
    },
    "drive_state": {
      "gps_as_of": 1589190229,
      "heading": 126,
      "latitude": 47.761687,
      "longitude": -122.254487,
      "native_latitude": 47.761687,
      "native_location_supported": 1,
      "native_longitude": -122.254487,
      "native_type": "wgs",
      "power": 0,
      "shift_state": null,
      "speed": null,
      "timestamp": 1589242930863
    },
    "gui_settings": {
      "gui_24_hour_time": false,
      "gui_charge_rate_units": "mi/hr",
      "gui_distance_units": "mi/hr",
      "gui_range_display": "Rated",
      "gui_temperature_units": "F",
      "show_range_units": false,
      "timestamp": 1589242930863
    },
    "vehicle_config": {
      "can_accept_navigation_requests": true,
      "can_actuate_trunks": true,
      "car_special_type": "base",
      "car_type": "model3",
      "charge_port_type": "US",
      "ece_restrictions": false,
      "eu_vehicle": false,
      "exterior_color": "MidnightSilver",
      "has_air_suspension": false,
      "has_ludicrous_mode": false,
      "key_version": 2,
      "motorized_charge_port": true,
      "plg": false,
      "rear_seat_type": null,
      "rhd": false,
      "roof_color": "Glass",
      "seat_type": null,
      "spoiler_type": "None",
      "sun_roof_installed": null,
      "third_row_seats": "<invalid>",
      "timestamp": 1589242930864,
      "use_range_badging": true,
      "wheel_type": "Pinwheel18"
    },
    "vehicle_state": {
      "api_version": 7,
      "autopark_state_v3": "standby",
      "autopark_style": "dead_man",
      "calendar_supported": true,
      "car_version": "2020.12.11.1 81280b81af0a",
      "center_display_state": 0,
      "df": 0,
      "dr": 0,
      "fd_window": 0,
      "fp_window": 0,
      "ft": 0,
      "is_user_present": false,
      "last_autopark_error": "no_error",
      "locked": true,
      "media_state": {
        "remote_control_enabled": true
      },
      "notifications_supported": true,
      "odometer": 2275.384985,
      "parsed_calendar_supported": true,
      "pf": 0,
      "pr": 0,
      "rd_window": 0,
      "remote_start": false,
      "remote_start_enabled": true,
      "remote_start_supported": true,
      "rp_window": 0,
      "rt": 0,
      "sentry_mode": false,
      "sentry_mode_available": true,
      "smart_summon_available": true,
      "software_update": {
        "download_perc": 0,
        "expected_duration_sec": 2700,
        "install_perc": 1,
        "status": "",
        "version": ""
      },
      "speed_limit_mode": {
        "active": false,
        "current_limit_mph": 85.0,
        "max_limit_mph": 90,
        "min_limit_mph": 50,
        "pin_code_set": false
      },
      "summon_standby_mode_enabled": false,
      "timestamp": 1589242930863,
      "valet_mode": false,
      "valet_pin_needed": true,
      "vehicle_name": "Car Name"
    }
  }
}
```
