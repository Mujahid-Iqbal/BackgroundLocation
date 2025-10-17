Pod::Spec.new do |s|
  s.name = 'CapacitorBackgroundLocationMiq'
  s.version = '0.0.1'
  s.summary = 'Capacitor Background Location Plugin'
  s.license = 'MIT'
  s.author = 'Mujahid Iqbal'
  s.homepage = 'https://github.com/Mujahid-Iqbal/BackgroundLocation'
  s.source = { :git => 'https://github.com/Mujahid-Iqbal/BackgroundLocation.git', :tag => 'v0.0.1' }
  s.source_files = 'ios/Sources/**/*.{swift,h,m,c}'
  s.ios.deployment_target = '12.0'
  s.dependency 'Capacitor'
end
