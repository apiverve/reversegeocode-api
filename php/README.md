# Reverse Geocode API - PHP Package

Reverse Geocode converts latitude and longitude coordinates into US and Canada location details. Pass geographic coordinates to retrieve the corresponding city, state, postal code, and country code.

## Installation

Install via Composer:

```bash
composer require apiverve/reversegeocode
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Reversegeocode\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'lat' => 40.714224,
    'lon' => -73.961452
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Reversegeocode\Client;
use APIVerve\Reversegeocode\Exceptions\APIException;
use APIVerve\Reversegeocode\Exceptions\ValidationException;

try {
    $response = $client->execute(['lat' => 40.714224, 'lon' => -73.961452]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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
    ]
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/reversegeocode?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/reversegeocode?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/reversegeocode?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
