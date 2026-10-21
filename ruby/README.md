# Reverse Geocode API - Ruby Gem

Reverse Geocode converts latitude and longitude coordinates into US and Canada location details. Pass geographic coordinates to retrieve the corresponding city, state, postal code, and country code.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_reversegeocode'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_reversegeocode
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_reversegeocode'

# Initialize the client
client = APIVerve::Reversegeocode::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  lat: 40.714224,
  lon: -73.961452
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ lat: 40.714224, lon: -73.961452 })
  puts response["data"]
rescue APIVerve::Reversegeocode::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Reversegeocode::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Reversegeocode::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/reversegeocode?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/reversegeocode?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/reversegeocode?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
