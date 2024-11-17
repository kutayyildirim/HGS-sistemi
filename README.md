HGS yolcu geçiş sistemi
Bu proje, Java konsol uygulaması olarak geliştirilmiş bir HGS (Hızlı Geçiş Sistemi) yönetim sistemidir. Kullanıcıların araç bilgilerini kaydedebileceği, güzergah seçimi yapabileceği ve bakiye yönetimi gerçekleştirebileceği dinamik bir yapıya sahiptir. Ayrıca, farklı araç sınıfları ve güzergahlar için değişken fiyatlandırma desteklenmektedir. Çeşitli yanlış girdiyi engellemek için kontrol bloklarıda eklenmiştir.

Özellikler
Kullanıcı Kaydı:
Kullanıcılar ad, soyad, kimlik numarası, araç tipi ve başlangıç bakiyesi girerek hesap oluşturabilir.

Dinamik Fiyatlandırma:
Seçilen araç sınıfına göre güzergah ücretleri değişir.

Güzergah Yönetimi:
Önceden tanımlı güzergahlar üzerinden geçiş yapılabilir.

Geçiş Kayıtları:
Kullanıcının yaptığı tüm geçişler tarih, giriş ve çıkış gişeleri, ücret bilgisiyle birlikte kaydedilir.

Bakiye Yönetimi:
Geçiş ücretleri bakiyeden düşülür ve bakiye yetersizse işlem engellenir.

Sınıflar ve Açıklamaları
1. Main
Uygulamanın giriş noktasıdır. Kullanıcıdan bilgi toplar, geçiş işlemlerini başlatır ve tüm kullanıcı etkileşimlerini yönetir.

Metotlar:
calculateFee(String vehicleClass, double baseFee)
Araç sınıfına göre ücret hesaplar.
Kullanıcı girişi için döngüler ve doğrulama kontrolleri içerir.
2. Individual
Bireysel kullanıcı hesaplarını temsil eder. Geçiş ekleme, bakiye artırma/azaltma ve hesap bilgilerini görüntüleme işlevlerini içerir.

Metotlar:
addPassage(HGSPassages passage)
Kullanıcının geçiş kaydını listesine ekler.
deductBalance(double amount)
Bakiyeden ücret düşer.
displayableRoutes()
Kullanıcının tüm geçişlerini listeler.

3. HGSAccounts
Tüm HGS hesapları için ortak özellikleri tanımlar:
idNumber, firstName, lastName, vehicleClass, balance.

Metotlar:
displayAccountInfo(): Hesap bilgilerini görüntüler.
deductBalance(double amount): Bakiyeden ücret düşme işlemi.
addBalance(double amount): Bakiyeye para ekleme işlemi.

4. Passage (Geçiş)
Her bir güzergah geçişini temsil eder. Geçiş kayıtlarının tutulduğu temel sınıftır.
HGSPassages soyut sınıfından türetilmiştir.

Metotlar:
recordPassage()
Geçiş kaydını konsola yazdırır.

5. HGSPassages
Geçiş bilgilerini tanımlar:
date, entryGate, exitGate, fee.

Soyut Metotlar:
recordPassage(): Geçiş kaydını yönetmek için kullanılır.

6. DisplayableRoutes
Kullanıcının tüm geçiş güzergahlarını görüntülemek için bir arayüz sağlar.

Metotlar:
displayableRoutes(): Tüm geçişlerin detaylarını listeler.

7. DisplayableDeposite
Hesap bakiyesini ve kullanıcı bilgilerini görüntülemek için bir arayüz sağlar.

Metotlar:
displayableDeposite(): Hesap bakiyesini ve kullanıcı bilgilerini ekrana yazdırır.
