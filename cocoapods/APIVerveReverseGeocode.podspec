Pod::Spec.new do |s|
  s.name             = 'APIVerveReverseGeocode'
  s.version          = '1.2.3'
  s.summary          = 'Reverse Geocode converts latitude and longitude coordinates into US and Canada location details.'
  s.description      = <<-'DESC'
Reverse Geocode converts latitude and longitude coordinates into US and Canada location details. Pass geographic coordinates to retrieve the corresponding city, state, postal code, and country code.

This iOS/macOS SDK provides a convenient way to access the Reverse Geocode from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/reversegeocode?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/reversegeocode-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveReverseGeocode/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
