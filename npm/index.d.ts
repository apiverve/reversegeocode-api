declare module '@apiverve/reversegeocode' {
  export interface reversegeocodeOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface reversegeocodeResponse {
    status: string;
    error: string | null;
    data: ReverseGeocodeData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface ReverseGeocodeData {
      zipcode:          null | string;
      stateAbbr:        null | string;
      city:             null | string;
      state:            null | string;
      distance:         number | null;
      latitudeClosest:  null | string;
      longitudeClosest: null | string;
      countryCode:      null | string;
      latitude:         number | null;
      longitude:        number | null;
      estimatedCity:    boolean | null;
      nearestCities:    (null | string)[];
  }

  export default class reversegeocodeWrapper {
    constructor(options: reversegeocodeOptions);

    execute(callback: (error: any, data: reversegeocodeResponse | null) => void): Promise<reversegeocodeResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: reversegeocodeResponse | null) => void): Promise<reversegeocodeResponse>;
    execute(query?: Record<string, any>): Promise<reversegeocodeResponse>;
  }
}
