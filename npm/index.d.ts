declare module '@apiverve/reversegeocode' {
  export interface reversegeocodeOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface reversegeocodeResponse {
    status: string;
    error: string | null;
    data: ReverseGeocodeData;
    code?: number;
  }


  interface ReverseGeocodeData {
      zipcode:              string;
      stateAbbr:            string;
      city:                 string;
      state:                string;
      distance:             number;
      latitudeClosest:      string;
      longitudeClosest:     string;
      countryCode:          string;
      latitudeClosestCity:  null;
      longitudeClosestCity: null;
      latitude:             number;
      longitude:            number;
      estimatedCity:        boolean;
      nearestCities:        string[];
  }

  export default class reversegeocodeWrapper {
    constructor(options: reversegeocodeOptions);

    execute(callback: (error: any, data: reversegeocodeResponse | null) => void): Promise<reversegeocodeResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: reversegeocodeResponse | null) => void): Promise<reversegeocodeResponse>;
    execute(query?: Record<string, any>): Promise<reversegeocodeResponse>;
  }
}
