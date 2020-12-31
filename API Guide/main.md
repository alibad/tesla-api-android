# Intro
The Tesla API has three main behaviors:
* [Initialize](#initialize)
* [State](state.md)
* [Commands](commands.md)

The base URI for all requests is `https://owner-api.teslamotors.com/`.

We leveraged this [documentation](https://github.com/timdorr/tesla-api) and re-categorized it into 3 high level categories. In addition, we've included cURL commands for convenience. See [note on cURL commands](#curl-commands) for additional context.

Note that we cover "most" but not all APIs. 

# Initialize

There are a few simple steps to follow in order to "connect" to your Tesla car and start interacting with it via API calls. 
1. [Authenticate](#authenticate), by providing user name and password and getting back a token in return. You can use this token going forward for all API calls until it expires.
2. [Get the vehicle Id](#get-all-vehicles-data). The API is designed to work in case you have multiple vehicles, so in order to interact with most Tesla APIs, you need to retrieve that vehicle Id.
3. [Wake up the car](#wake-up). Before telling the car what to do (ex: unlock doors), you need to wake it up first. 

# Authentication
The authentication process for the Tesla API

## Authenticate

The initial authentication process is via [an OAuth 2.0 Password Grant](https://oauth.net/2/grant-types/password/) with the same credentials used for tesla.com and the mobile apps.

### POST `/oauth/token?grant_type=password`

The current client ID and secret are [available here](https://pastebin.com/pS7Z6yyP).

You will get back an `access_token` which is treated as [an OAuth 2.0 Bearer Token](https://oauth.net/2/bearer-tokens/). This token is passed along in an `Authorization` header with all future requests:

```http
Authorization: Bearer {access_token}
```

The access token has a 45 day expiration.

### Request parameters

| Field           | Type             | Example                | Description                                       |
| :-------------- | :--------------- | :--------------------- | :------------------------------------------------ |
| `grant_type`    | String, required | `password`             | The type of OAuth grant. Always "password"        |
| `client_id`     | String, required | `abc`                  | The OAuth client ID                               |
| `client_secret` | String, required | `123`                  | The OAuth client secret                           |
| `email`         | String, required | `elon@teslamotors.com` | The email for the authenticating Tesla account    |
| `password`      | String, required | `edisonsux`            | The password for the authenticating Tesla account |

### Mac cURL Request
```shell script
curl -X POST  -H 'Content-Type: application/json' -d '{"grant_type": "password", "client_id": "81527cff06843c8634fdc09e8ac0abefb46ac849f38fe1e431c2ef2106796384", "client_secret": "c7257eb71a564034f9419ee651c7d0e5f7aa6bfbd18bafb5c5c033b093bb2fa3", "email": "myemail@email.com","password": "mypassword"}' 'https://owner-api.teslamotors.com/oauth/token'
```

### Windows cURL Request
```shell script
curl -X POST  -H "Content-Type: application/json" -d "{\"grant_type\": \"password\", \"client_id\": \"81527cff06843c8634fdc09e8ac0abefb46ac849f38fe1e431c2ef2106796384\", \"client_secret\": \"c7257eb71a564034f9419ee651c7d0e5f7aa6bfbd18bafb5c5c033b093bb2fa3\", \"email\": \"myemail@email.com\",\"password\": \"mypassword\"}" "https://owner-api.teslamotors.com/oauth/token"
```

### Request JSON

```json
{
  "grant_type": "password",
  "client_id": "abc",
  "client_secret": "123",
  "email": "elon@teslamotors.com",
  "password": "edisonsux"
}
```

### Response

```json
{
  "access_token": "abc123",
  "token_type": "bearer",
  "expires_in": 3888000,
  "refresh_token": "cba321",
  "created_at": 1538359034
}
```

#### Invalid Response
```json
{"response":"authorization_required_for_txid_`24f857d7e437cab7f18c3f1869ea04ab`"}
```

## Refresh Token

You can use the `refresh_token` from the Password Grant to do [an OAuth 2.0 Refresh Token Grant](https://oauth.net/2/grant-types/refresh-token/) and obtain a new access token. Note: This will invalidate the previous access token.

### POST `/oauth/token?grant_type=refresh_token`

### Request parameters

| Field           | Type             | Example         | Description                                               |
| :-------------- | :--------------- | :-------------- | :-------------------------------------------------------- |
| `grant_type`    | String, required | `refresh_token` | The type of OAuth grant. Always "refresh_token"           |
| `client_id`     | String, required | `abc`           | The OAuth client ID                                       |
| `client_secret` | String, required | `123`           | The OAuth client secret                                   |
| `refresh_token` | String, required | `cba321`        | The refresh token returned from a previous token request. |

### Mac cURL Request

```shell script
curl -X POST  -H 'Content-Type: application/json' -d '{"grant_type": "refresh_token", "client_id": "81527cff06843c8634fdc09e8ac0abefb46ac849f38fe1e431c2ef2106796384", "client_secret": "c7257eb71a564034f9419ee651c7d0e5f7aa6bfbd18bafb5c5c033b093bb2fa3", "refresh_token": "<your_refresh_token>"}' 'https://owner-api.teslamotors.com/oauth/token'
```

### Windows cURL Request

```shell script
curl -X POST  -H "Content-Type: application/json" -d "{\"grant_type\": \"refresh_token\", \"client_id\": \"81527cff06843c8634fdc09e8ac0abefb46ac849f38fe1e431c2ef2106796384\", \"client_secret\": \"c7257eb71a564034f9419ee651c7d0e5f7aa6bfbd18bafb5c5c033b093bb2fa3\", \"refresh_token\": \"<your_refresh_token>\"}" "https://owner-api.teslamotors.com/oauth/token"
```

### Request JSON

```json
{
  "grant_type": "refresh_token",
  "client_id": "abc",
  "client_secret": "123",
  "refresh_token": "cba321"
}
```

### Response

```json
{
  "access_token": "<your_access_token>",
  "token_type": "bearer",
  "expires_in": 3888000,
  "refresh_token": "<your_refresh_token>",
  "created_at": 1538359034
}
```

# Vehicles

A logged in user can have multiple vehicles under their account. This resource is primarily responsible for listing the vehicles and the basic details about them.

#### `vehicle_id` vs `id`

One potentially confusing part of Tesla's API is the switching use of the `id` and `vehicle_id` of the car. The `id` field is an identifier for the car on the owner-api endpoint. The `vehicle_id` field is for identifying the car across different endpoints, such as the streaming or Autopark APIs.

For the state and command APIs, you should be using the `id` field. If your JSON parser doesn't support large numbers (&gt;32 bit), then you can use the `id_s` field for a string version of the ID.

## Get all Vehicles data

### GET `/api/1/vehicles`

Retrieve a list of your owned vehicles (includes vehicles not yet shipped!)

### Mac cURL Request
```shell script
curl --request GET --header 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles'
```

### Windows cURL Request
```shell script
curl --request GET --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles"
```

### Request parameters

None

### Response

The id field below is the one we care about when making the state and command API calls to the car.

```json
{
  "response": [
    {
      "id": 12345678901234567,
      "vehicle_id": 1234567890,
      "vin": "5YJSA11111111111",
      "display_name": "Nikola 2.0",
      "option_codes": "MDLS,RENA,AF02,APF1,APH2,APPB,AU01,BC0R,BP00,BR00,BS00,CDM0,CH05,PBCW,CW00,DCF0,DRLH,DSH7,DV4W,FG02,FR04,HP00,IDBA,IX01,LP01,ME02,MI01,PF01,PI01,PK00,PS01,PX00,PX4D,QTVB,RFP2,SC01,SP00,SR01,SU01,TM00,TP03,TR00,UTAB,WTAS,X001,X003,X007,X011,X013,X021,X024,X027,X028,X031,X037,X040,X044,YFFC,COUS",
      "color": null,
      "tokens": ["abcdef1234567890", "1234567890abcdef"],
      "state": "online",
      "in_service": false,
      "id_s": "12345678901234567",
      "calendar_enabled": true,
      "api_version": 7,
      "backseat_token": null,
      "backseat_token_updated_at": null
    }
  ],
  "count": 1
}
```

# Wake Up

Although "wake" is a command, we categorize it here as part of initialize because the car needs to be woken up before any other state or command query can be made.

### POST `/api/1/vehicles/{id}/wake_up`

Wakes up the car from a sleeping state.

The API will return a response immediately, however it could take several seconds before the car is actually online and ready to receive other commands.
One way to deal with this is to call this endpoint in a loop until the returned state says "online", with a timeout to give up. In some cases, the wake up can be slow, so consider using a timeout of atleast 30 seconds.

### Mac cURL Request

```shell script
curl -X POST --header 'Authorization: Bearer <auth_token_goes_here>' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/wake_up'
```
### Windows cURL Request

```shell script
curl --request GET --header "Authorization: Bearer <auth_token_goes_here>" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/wake_up"
```

### Request

None

### Response

```json
{
  "response": {
    "id": 12345678901234567,
    "user_id": 12345,
    "vehicle_id": 1234567890,
    "vin": "5YJSA11111111111",
    "display_name": "Nikola 2.0",
    "option_codes": "MDLS,RENA,AF02,APF1,APH2,APPB,AU01,BC0R,BP00,BR00,BS00,CDM0,CH05,PBCW,CW00,DCF0,DRLH,DSH7,DV4W,FG02,FR04,HP00,IDBA,IX01,LP01,ME02,MI01,PF01,PI01,PK00,PS01,PX00,PX4D,QTVB,RFP2,SC01,SP00,SR01,SU01,TM00,TP03,TR00,UTAB,WTAS,X001,X003,X007,X011,X013,X021,X024,X027,X028,X031,X037,X040,X044,YFFC,COUS",
    "color": null,
    "tokens": ["abcdef1234567890", "1234567890abcdef"],
    "state": "online",
    "in_service": false,
    "id_s": "12345678901234567",
    "calendar_enabled": true,
    "api_version": 7,
    "backseat_token": null,
    "backseat_token_updated_at": null
  }
}
```

# Curl Commands
For convenience, and since this is one of the easiest ways for developers to instantly interact with APIs, I have included cURL command examples for each API. 

cURL comes pre-installed on Linux, Mac, and Windows 10 version 1803 and above. 

## Token
You will notice a string like the following passed in the Authorization header in the examples. Make sure to use your own token generated by calling [Autheticate](#Authenticate). It should look something like this:
f2b43a656568e6610890000f4555555c120f7c2be511185944e2da8b4444470b

## Vehcile Id
You will notice a vehicle Id like the following in sample requests. Make sure to replace it with your own vehicle id by calling [Get Vehicle List](#Get Vehicle List). It should look something like this:
16413331114222161

## Platform

Given that we are passing JSON payload in the command line, and given how Windows command prompt differs from Unix/Mac terminal, a cURL command written for Mac needs some adjustment to run on Windows. Mainly, Windows command line quote escaping works differently.

For example, if we look at the API call to set the speed limit. Here is a cURL command for Linux/Mac

```shell script
curl -X POST -H "Authorization: Bearer <auth_token_goes_here>" -H 'Content-Type: application/json' -d '{"limit_mph": "65"}' 'https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_set_limit'
```

If you run this on Windows, you will get this error:

```shell script
curl: (6) Could not resolve host: application
curl: (3) [globbing] unmatched close brace/bracket in column 3
curl: (1) Protocol "'https" not supported or disabled in libcurl
```

In order to be able to run them on Windows, replace single quotes with double quotes and for JSON, escape double quotes. 

```shell script
curl -X POST  -H "Authorization: Bearer <auth_token_goes_here>" -H "Content-Type: application/json" -d "{\"limit_mph\": \"65\"}" "https://owner-api.teslamotors.com/api/1/vehicles/16459778504118161/command/speed_limit_set_limit"
```

In all our examples, we provide both the Linux/Mac and Windows versions to make your life easier.
