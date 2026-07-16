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
    }
}
