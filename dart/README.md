# Reverse Geocode API - Dart/Flutter Client

Reverse Geocode converts latitude and longitude coordinates into US, Canada and Australia location details. Pass geographic coordinates to retrieve the corresponding city, state, postal code, country code, time zone and US county. Paid plans can add the point's geohash, plus code and degrees-minutes-seconds notation.

[![pub package](https://img.shields.io/pub/v/apiverve_reversegeocode.svg)](https://pub.dev/packages/apiverve_reversegeocode)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Reverse Geocode API](https://apiverve.com/marketplace/reversegeocode?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_reversegeocode: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_reversegeocode/apiverve_reversegeocode.dart';

void main() async {
  final client = ReversegeocodeClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'lat': 40.714224,
      'lon': -73.961452,
      'geocodes': true
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "zipcode": "11211",
    "state_abbr": "NY",
    "city": "Brooklyn",
    "state": "New York",
    "distance": 0.6501757300758664,
    "latitudeClosest": "40.712090",
    "longitudeClosest": "-73.95427",
    "countryCode": "US",
    "latitude": 40.714224,
    "longitude": -73.961452,
    "estimatedCity": true,
    "nearestCities": [
      "Brooklyn",
      "Brooklyn Park",
      "East Brooklyn",
      "Brooklyn Center",
      "Brooklyn Heights"
    ],
    "timezone": "America/New_York",
    "county": "Kings County",
    "countyFips": "36047",
    "geocodes": {
      "geohash": "dr5rsgyct",
      "plusCode": "87G8P27Q+MC",
      "dms": {
        "latitude": "40°42'51.2\"N",
        "longitude": "73°57'41.2\"W"
      }
    }
  }
}
```

## API Reference

- **API Home:** [Reverse Geocode API](https://apiverve.com/marketplace/reversegeocode?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/reversegeocode](https://docs.apiverve.com/ref/reversegeocode?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
