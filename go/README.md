# Reverse Geocode API - Go Client

Reverse Geocode is a simple tool for getting the location of a set of coordinates. Only supports USA and Canada Coordinates. It returns the city, state, and more.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Reverse Geocode API](https://apiverve.com/marketplace/reversegeocode?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/reversegeocode-api/go
```

---

## Configuration

Before using the Reverse Geocode API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Reverse Geocode API documentation is found here: [https://docs.apiverve.com/ref/reversegeocode](https://docs.apiverve.com/ref/reversegeocode?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/reversegeocode-api/go"
)

func main() {
    // Create a new client
    client := reversegeocode.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "lat": 40.714224,
        "lon": -73.961452
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

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
    "latitudeClosestCity": null,
    "longitudeClosestCity": null,
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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
