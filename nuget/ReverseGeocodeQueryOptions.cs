using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.ReverseGeocode
{
    /// <summary>
    /// Query options for the Reverse Geocode API
    /// </summary>
    public class ReverseGeocodeQueryOptions
    {
        /// <summary>
        /// The latitude of the coordinates (e.g., 40.714224)
        /// Example: 40.714224
        /// </summary>
        [JsonProperty("lat")]
        public string Lat { get; set; }

        /// <summary>
        /// The longitude of the coordinates (e.g., -73.961452)
        /// Example: -73.961452
        /// </summary>
        [JsonProperty("lon")]
        public string Lon { get; set; }
    }
}
