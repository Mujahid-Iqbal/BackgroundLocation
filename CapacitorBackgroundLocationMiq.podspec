Pod::Spec.new do |s|
  s.name             = 'CapacitorBackgroundLocationMiq'
  s.version          = '0.0.3'
  s.summary          = 'Capacitor plugin for background location tracking'
  s.license          = 'MIT'
  s.author           = 'Mujahid Iqbal'
  s.homepage         = 'https://github.com/Mujahid-Iqbal/BackgroundLocation' # ✅ Add this line
  s.source           = { :path => '.' }
  s.source_files     = 'ios/Sources/**/*.{swift,h,m,c}'
  s.requires_arc     = true
  s.platform         = :ios, '11.0'
  s.dependency       'Capacitor'
end
