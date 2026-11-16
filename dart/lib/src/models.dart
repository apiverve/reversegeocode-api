/// Response models for the Reverse Geocode API.

/// API Response wrapper.
class ReversegeocodeResponse {
  final String status;
  final dynamic error;
  final ReversegeocodeData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  ReversegeocodeResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory ReversegeocodeResponse.fromJson(Map<String, dynamic> json) => ReversegeocodeResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? ReversegeocodeData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Reverse Geocode API.

class ReversegeocodeData {
  String? zipcode;
  String? stateAbbr;
  String? city;
  String? state;
  num? distance;
  String? latitudeClosest;
  String? longitudeClosest;
  String? countryCode;
  num? latitude;
  num? longitude;
  bool? estimatedCity;
  List<String>? nearestCities;
  String? timezone;
  String? county;
  String? countyFips;
  ReversegeocodeDataGeocodes? geocodes;

  ReversegeocodeData({
    this.zipcode,
    this.stateAbbr,
    this.city,
    this.state,
    this.distance,
    this.latitudeClosest,
    this.longitudeClosest,
    this.countryCode,
    this.latitude,
    this.longitude,
    this.estimatedCity,
    this.nearestCities,
    this.timezone,
    this.county,
    this.countyFips,
    this.geocodes,
  });

  factory ReversegeocodeData.fromJson(Map<String, dynamic> json) => ReversegeocodeData(
      zipcode: json['zipcode'],
      stateAbbr: json['state_abbr'],
      city: json['city'],
      state: json['state'],
      distance: json['distance'],
      latitudeClosest: json['latitudeClosest'],
      longitudeClosest: json['longitudeClosest'],
      countryCode: json['countryCode'],
      latitude: json['latitude'],
      longitude: json['longitude'],
      estimatedCity: json['estimatedCity'],
      nearestCities: (json['nearestCities'] as List?)?.cast<String>(),
      timezone: json['timezone'],
      county: json['county'],
      countyFips: json['countyFips'],
      geocodes: json['geocodes'] != null ? ReversegeocodeDataGeocodes.fromJson(json['geocodes']) : null,
    );
}

class ReversegeocodeDataGeocodes {
  String? geohash;
  String? plusCode;
  ReversegeocodeDataGeocodesDms? dms;

  ReversegeocodeDataGeocodes({
    this.geohash,
    this.plusCode,
    this.dms,
  });

  factory ReversegeocodeDataGeocodes.fromJson(Map<String, dynamic> json) => ReversegeocodeDataGeocodes(
      geohash: json['geohash'],
      plusCode: json['plusCode'],
      dms: json['dms'] != null ? ReversegeocodeDataGeocodesDms.fromJson(json['dms']) : null,
    );
}

class ReversegeocodeDataGeocodesDms {
  String? latitude;
  String? longitude;

  ReversegeocodeDataGeocodesDms({
    this.latitude,
    this.longitude,
  });

  factory ReversegeocodeDataGeocodesDms.fromJson(Map<String, dynamic> json) => ReversegeocodeDataGeocodesDms(
      latitude: json['latitude'],
      longitude: json['longitude'],
    );
}

class ReversegeocodeRequest {
  double lat;
  double lon;
  bool? geocodes;

  ReversegeocodeRequest({
    required this.lat,
    required this.lon,
    this.geocodes,
  });

  Map<String, dynamic> toJson() => {
      'lat': lat,
      'lon': lon,
      if (geocodes != null) 'geocodes': geocodes,
    };
}
