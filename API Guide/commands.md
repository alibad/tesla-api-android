# Alerts

## Honk Horn Command

### Mac cURL Request
```shell script
curl --request POST --header 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/honk_horn'
```

### Windows cURL Request
```shell script
curl --request POST --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/honk_horn"
```

### Response
{"response":{"reason":"","result":true}}

## Flash Lights Command

### Mac cURL Request
```shell script
curl --request POST --header 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/flash_lights'
```

### Windows cURL Request
```shell script
curl --request POST --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/flash_lights"
```

### Response
{"response":{"reason":"","result":true}}

# Entry

## Remote Start Drive

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:password, REQUIRED, String
The password to the authenticated my.teslamotors.com account.

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"password": "edisonsux"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/remote_start_drive'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"password\": \"edisonsux\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/remote_start_drive"
```

### Response
{"response":null,"error":"Authorization Required for txid `5b1d0fbb5ba30953a0b06a7678f0d935`","error_description":""}
{"response":{"reason":"already on","result":false}}
{"response":{"reason":"","result":true}}

## Lock Doors Command

### Mac cURL Request
```shell script
curl --request POST --header 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/door_lock'
```

### Windows cURL Request
```shell script
curl --request POST --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/door_lock"
```

### Response
{"response":{"reason":"","result":true}}

## Unlock Doors Command

### Mac cURL Request
```shell script
curl --request POST --header 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/door_unlock'
```

### Windows cURL Request
```shell script
curl --request POST --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/door_unlock"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

## Window Control Command

Controls the windows. Will vent or close all windows simultaneously.

`lat` and `lon` values must be near the current location of the car for
`close` operation to succeed.  For `vent`, the `lat` and `lon` values are
ignored, and may both be `0` (which has been observed from the app itself).

### Parameters

| Parameter | Example | Description                                                                 |
| :-------- | :------ | :-------------------------------------------------------------------------- |
| command   | close   | What action to take with the windows. Allows the values `vent` and `close`. |
| lat       | 0       | Your current latitude.  See Notes above.                                    |
| lon       | 0       | Your current longitude.  See Notes above.                                   |

### Mac cURL Request

To vent the windows:
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' -d '{\'command\': \'vent\', \'lat\': \'0\', \'lon\': \'0\'}' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/window_control'
```

To close the windows:
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' -d '{\'command\': \'close\', \'lat\': \'0\', \'lon\': \'0\'}' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/window_control'
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

### Windows cURL Request

To vent the windows:
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"command\": \"vent\", \"lat\": \"0\", \"lon\": \"0\"}" "https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/window_control"
```

To close the windows:
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"command\": \"close\", \"lat\": \"0\", \"lon\": \"0\"}" "https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/window_control"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

## Sun Roof Command

Controls the sunroof (Model S). Will vent or close the sunroof.

### Parameters

| Parameter | Example | Description                                                                 |
| :-------- | :------ | :-------------------------------------------------------------------------- |
| state     | open    | What action to take with the sunroof. Allows the values `open` and `closed`. |

### Mac cURL Request

To vent the sunroof:
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' -d '{\'state\': \'open\'}' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/window_control'
```

To close the sunroof:
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' -d '{\'state\': \'closed\'}' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/window_control'
```

### Windows cURL Request

To vent the sunroof:
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"state\": \"open\"}" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/window_control"
```

To close the sunroof:
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"state\": \"closed\"}" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/window_control"
```

### Response
TODO

## Actuate Trunk Command

### Parameters

| Parameter   | Example | Description
| :--------   | :------ | :--------------------------------------------------------------------------
| which_trunk | front   |   Which trunk to open/close. rear and front are the only options. On the Model S and X, it will also close the rear trunk.

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' -d '{"which_trunk": "front"}' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/actuate_trunk'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{"which_trunk": "front"}" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/actuate_trunk"
```

### Response
{"response":{"reason":"","result":true}}

## Set Sentry Mode

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:on, REQUIRED, true/false
Turns sentry mode on or off. True to turn on, false to turn off.

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"on": "true"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_sentry_mode'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"on\": \"false\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_sentry_mode"
```

### Response
{"response":{"reason":"","result":true}}

# Climate

## Start HVAC System Command

### Mac cURL Request
```shell script
curl --request POST --header 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/auto_conditioning_start'
```

### Windows cURL Request
```shell script
curl --request POST --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/auto_conditioning_start"
```

### Response
{"response":{"reason":"","result":true}}

## Stop HVAC System Command

### Mac cURL Request
```shell script
curl --request POST --header 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/auto_conditioning_stop'
```

### Windows cURL Request
```shell script
curl --request POST --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/auto_conditioning_stop"
```

### Response
{"response":{"reason":"","result":true}}

## Set Temperature Command

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:driver_temp, REQUIRED, number
Desired driver temperature in Celsius

:passenger_temp, REQUIRED, number
Desired passenger temperature in Celsius

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"driver_temp": "20", "passenger_temp": "21"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_temps'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"driver_temp\": \"20\", \"passenger_temp\": \"21\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_temps"
```

### Response
{"response":{"reason":"","result":true}}

## Set Preconditioning Max Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/set_preconditioning_max'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/set_preconditioning_max"
```

### Response
{"response":{"reason":"","result":true}}

## Remote Seat Heater Request Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' -d '{"heater":1, "level":1}' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/remote_seat_heater_request'
```

### Windows cURL Request
```shell script
curl --request POST --header "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{"heater":1, "level":1}" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/remote_seat_heater_request"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

If the climate control is off, the command would result in this response.
```json
{"response":{"reason":"cabin comfort remote settings not enabled","result":false}}
```
=======
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{"0": "3", "1": "3", "2": "3", "3": "3", "4": "3"}" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/remote_seat_heater_request"
```

### Response
{"response":{"reason":"","result":true}}
>>>>>>> Stashed changes

## Remote Steering Wheel Heater Request Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/remote_steering_wheel_heater_request'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/remote_steering_wheel_heater_request"
```
### Response
```json
{
  "reason": "",
  "result": true
}
```

If the car is not equipped with a heated steering wheel, the command would result in this response.
```json
{"response":{"reason":"cabin comfort remote settings not enabled","result":false}}
```

# Charge

## Set Charge Limit

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:percent, REQUIRED, number
Percentage of charge to set the vehicle to. Ex: 70

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"percent": "77"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_charge_limit'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"percent\": \"77\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_charge_limit"
```

### Response
{"response":{"reason":"","result":true}}

## Set Charge Limit to Max Range

### POST Body Parameters

NA

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_max_range'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_max_range"
```

### Response
{"response":{"reason":"","result":true}}

{"response":{"reason":"already_max_range","result":false}}

## Set Charge Limit to Standard

### POST Body Parameters

NA

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_standard'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_standard"
```

### Response
{"response":{"reason":"","result":true}}

{"response":{"reason":"already_standard","result":false}}

## Open Charge Port

### POST Body Parameters

NA

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_port_door_open'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_port_door_open"
```

### Response
{"response":{"reason":"","result":true}}
{"response":{"reason":"already open","result":false}}

## Close Charge Port

### POST Body Parameters

NA

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_port_door_close'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_port_door_close"
```

### Response
{"response":{"reason":"","result":true}}
{"response":{"reason":"already closed","result":false}}

## Start Charging

If the car is plugged in but not currently charging, this will start it charging.

### POST Body Parameters

NA

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_start'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_start"
```

### Response
{"response":{"reason":"","result":true}}
{"response":null,"error":"vehicle unavailable: {:error=>\"vehicle unavailable:\"}","error_description":""}

## Stop Charging

If the car is currently charging, this will stop it.

### POST Body Parameters

NA

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_stop'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/charge_stop"
```

### Response
{"response":{"reason":"","result":true}}
{"response":null,"error":"vehicle unavailable: {:error=>\"vehicle unavailable:\"}","error_description":""}

# Speed Limit

## Set Speed Limit

Sets the maximum speed allowed when Speed Limit Mode is active.

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:limit_mph, REQUIRED, ex: 65
The speed limit in MPH. Must be between 50-90.

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"limit_mph": "65"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_set_limit'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"limit_mph\": \"65\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_set_limit"
```

### Response
{"response":{"reason":"","result":true}}
{"response":null,"error":"vehicle unavailable: {:error=>\"vehicle unavailable:\"}","error_description":""}

## Speed Limit Activate

Activates Speed Limit Mode at the currently set speed.

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:pin, REQUIRED, ex: 1234
The existing PIN, if previously set, or a new 4 digit PIN.

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"pin": "1234"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_activate'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"pin\": \"1234\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_activate"
```

### Response
{"response":{"reason":"","result":true}}

## Speed Limit Deactivate

Deactivates Speed Limit Mode if it is currently active.

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:pin, REQUIRED, ex: 1234
The 4 digit PIN used to activate Speed Limit Mode.

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"pin": "1234"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_deactivate'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"pin\": \"1234\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_deactivate"
```

### Response
{"response":{"reason":"","result":true}}

## Speed Limit Clear Pin

Clears the currently set PIN for Speed Limit Mode.

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:pin, REQUIRED, ex: 1234
The 4 digit PIN used to activate Speed Limit Mode.

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"pin": "1234"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_clear_pin'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"pin\": \"1234\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_clear_pin"
```

### Response
{"response":{"reason":"","result":true}}
{"response":{"reason":"no_pin_set","result":false}}

# Device Assistant

## Share Command

Sends a location for the car to start navigation or play a video in theatre mode.

When the car is in park mode, you can send video url to play. When the car is moving, you can send a location/address to go to.

These docs take from the Android app, which sends the data in JSON form. However, a [URL-encoded](https://en.wikipedia.org/wiki/Percent-encoding) POST body will work as well. The basic format to a request looks like this:

```json
{
  "type": "share_ext_content_raw",
  "value": {
    "android.intent.extra.TEXT": "123 Main St, City, ST 12345\n\nhttps://goo.gl/maps/X"
  },
  "locale": "en-US",
  "timestamp_ms": "1539465730"
}
```

Note: This API was previously `navigation_request`, but has been updated to support video links as well.

### Parameters

| Parameter                        | Example                     | Description                                                    |
| :------------------------------- | :-------------------------- | :------------------------------------------------------------- |
| type                             | share_ext_content_raw       | Must be `share_ext_content_raw`.                               |
| locale                           | en-US                       | The locale for the navigation request. [ISO 639-1 standard language codes](https://www.andiamo.co.uk/resources/iso-language-codes/)                        |
| timestamp_ms                     | 1539465730                  | The current UNIX timestamp.                                    |
| value[android.intent.extra.TEXT] | 123 Main St, City, ST 12345 | The address or video URL to set as the navigation destination. |

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{ "type": "share_ext_content_raw", "value": { "android.intent.extra.TEXT": "123 Main St, City, ST 12345\n\nhttps://goo.gl/maps/X" }, "locale": "en-US", "timestamp_ms": "1539465730" }' 'https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/share'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"type\": \"share_ext_content_raw\", \"value\": { \"android.intent.extra.TEXT\": \"123 Main St, City, ST 12345\n\nhttps://goo.gl/maps/X\" }, \"locale\": \"en-US\", \"timestamp_ms\": \"1601840213\"}" "https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/share"
```

### Response

```json
{"response":{"result":true,"queued":false}}
```

## Upcoming Calendar Entries Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/upcoming_calendar_entries'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/upcoming_calendar_entries"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

# Software Update

## Schedule Software Update Command

Schedules a software update to be installed, if one is available.

### Parameters

| Parameter  | Example | Description                                                                            |
| :--------- | :------ | :------------------------------------------------------------------------------------- |
| offset_sec | 7200    | How many seconds in the future to schedule the update. Set to 0 for immediate install. |

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"offset_sec": "7200"}' 'https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/schedule_software_update'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"offset_sec\": \"7200\"}" "https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/schedule_software_update"
```

### Response

When there is not update to schedule
```json
{"response":{"reason":"update_not_available","result":false}}
```

On success:
```json
{"response":{"expected_duration_sec":1500,"reason":"","result":true,"scheduled_time_ms":1608842622476,"status":"scheduled","warning_time_remaining_ms":120000}}
```

## Cancel Software Update Command

Cancels a software update, if one is scheduled and has not yet started.

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/cancel_software_update'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/47454545211476819/command/cancel_software_update"
```

### Response

Response when vehicle is not awake.
```json
{"response":null,"error":"vehicle unavailable: {:error=>\"vehicle unavailable:\"}","error_description":""}
```

Response when there is no update scheduled
```json
{"response":{"reason":"no_update_scheduled","result":false}}
```

On success:
```json
{
  "reason": "",
  "result": true
}
```

# Media

## Toggle Playback Command

Toggles the media between playing and paused. For the radio, this mutes or unmutes the audio.

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_toggle_playback'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_toggle_playback"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

If the user is not present in the car, all media commands would result in this response.
```json
{"response":{"reason":"user_not_present","result":false}}
```

## Next Track Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_next_track'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_next_track"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

## Prev Track Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_prev_track'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_prev_track"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

## Next Fav Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_next_fav'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_next_fav"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

## Prev Fav Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_prev_fav'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_prev_fav"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

## Volume up Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_volume_up'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_volume_up"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

## Volume Down Command

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_volume_down'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/media_volume_down"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```

# Valet Mode

## Set Valet Mode

Activates or deactivates Valet Mode. 

### POST Body Parameters

Warning: some online documentation suggests to pass parameters as query strings, but that will not work. Pass it in the POST body.

:on, REQUIRED, true/false
true to activate, false to deactivate.

password, OPTIONAL, ex: 1234
A PIN to deactivate Valet Mode. Please see note about the password parameter.

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"on": "true"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_valet_mode'
```

```
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"on": "true", "password": "1234"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_valet_mode'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"on\": \"false\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_valet_mode"
```

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"on\": \"true\", \"password\": \"1234\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/set_valet_mode"
```

### Response
{"response":{"reason":"","result":true}}
{"response":{"reason":"already off","result":false}}
{"response":{"reason":"already on","result":false}}

## Reset Valet Pin

Clears the currently set PIN for Valet Mode when deactivated. A new PIN will be required when activating from the car screen. See the note above about activating via the API without a PIN set.

### POST Body Parameters

NA

### Mac cURL Request
```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/reset_valet_pin'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/reset_valet_pin"
```

### Response
{"response":{"reason":"","result":true}}

# Wake Uo

## Wake Up Command

Wakes up the car from a sleeping state.

### Mac cURL Request
```shell script
curl -X POST  -H 'Authorization: Bearer <auth_token_goes_here>' -H 'Content-Type: application/json' 'https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/wake_up'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" "https://owner-api.teslamotors.com/api/1/vehicles/<vehicle_id_goes_here>/command/wake_up"
```

### Response
```json
{
  "reason": "",
  "result": true
}
```