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
        /// The latitude of the coordinates
        /// </summary>
        [JsonProperty("lat")]
        public double Lat { get; set; }

        /// <summary>
        /// The longitude of the coordinates
        /// </summary>
        [JsonProperty("lon")]
        public double Lon { get; set; }

        /// <summary>
        /// Add a geocodes object with the point's geohash, plus code (Open Location Code) and degrees-minutes-seconds notation
        /// </summary>
        [JsonProperty("geocodes")]
        public bool? Geocodes { get; set; }
    }
}
