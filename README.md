<p align="center">
    <img src="https://applitools.com/wp-content/uploads/2020/08/Selenium_Hex-1.svg" width="50">
  &nbsp;&nbsp;&nbsp;
 <img src="https://gorsel.isbank.com.tr/sttk/StaticFiles/Isbank/images/logo/isbankDlogo.png" width="105">
  &nbsp;&nbsp;&nbsp;
</p>

<p align="center">

  <img src="https://img.shields.io/badge/Cucumber-BDD-23d160?style=flat-square&logo=cucumber" />
  <img src="https://img.shields.io/badge/Allure-Report-orange?logo=allure" />
  <img src="https://img.shields.io/badge/JUnit-4.13.2-blue?logo=junit5" />
  <img src="https://img.shields.io/badge/Apache POI-Excel-green?logo=apache" />
</p>

<h1 align="center">🧪 İs Bankası Web UI Otomasyon Projesi</h1>


## 📂 İçindekiler

- [📘 Proje Açıklaması](#-proje-açıklaması)
- [🚀 Kullanılan Teknolojiler](#-kullanılan-teknolojiler)
- [📁 Proje Yapısı](#-proje-yapısı)
- [📁 Test Senaryolari](#-test-senaryolari)
- [📊 Extent Reports
- [🙏 Teşekkürler](#-teşekkürler)



## 📘 Proje Açıklaması

Bu proje, **İs Bankası Web arayüzü** üzerinde uçtan uca testlerin otomasyonunu sağlamak amacıyla oluşturulmuştur.  
Modern test mühendisliği yaklaşımlarından biri olan **BDD (Behavior Driven Development)** yaklaşımı kullanılmıştır.
Kullanılan test mimarisi içerisinde:
* ✅ Selenium WebDriver ile web etkileşimleri gerçekleştirilmekte,
* ✅ TestNg ile testlerin entegrasyonu sağlanmakta,
* ✅ Extent Reporter ile detaylı test çıktıları görsel olarak sunulmakta,



## 🚀 Kullanılan Teknolojiler

| Teknoloji      | Versiyon | Açıklama |
|----------------|----------|----------|
| Java           | 19       | Test dili |
| Maven          | 3.9+     | Build aracı |
| Selenium       | 4.1      | WebDriver |
| TestNg         | 7.4      | Test runner |
| ExtentReports  | 5.1.1    | HTML test raporları |


## 📁 Proje Yapısı

## 📁 Proje Yapısı

```text
src/
├── main/
│   ├── java/
│   │   ├── Base/
│   │   │   ├── BasePage.java
│   │   │   ├── ExtentManager.java
│   │   │   ├── Hooks.java
│   │   │   └── WebDriverInstance.java
│   │   ├── drivers/
│   │   │   ├── chromedriver/
│   │   │   └── geckodriver/
│   │   ├── helpers/
│   │   │   ├── ConfigReader.java
│   │   │   ├── LoanCalculator.java
│   │   │   ├── ScrollHelper.java
│   │   │   └── WaitHelper.java
│   │   ├── org/example/
│   │   └── pageObjects/
│   │       ├── DepositCalculationPage.java
│   │       ├── Homepage.java
│   │       └── LoanCalculationPage.java
│   └── resources/
│       ├── config.properties
│       └── Listeners.java
├── test/
   ├── java/test/
   │   ├── DepositCalculationTest.java
   │   └── LoanCalculationTest.java
   └── resources/
       └── config.properties


### 📁 Geliştirme Notları

* Proje **Page Object Model (POM)** mimarisiyle yapılandırılmıştır. Sayfa aksiyonları `pageObjects/` klasöründe, yardımcı sınıflar ise `helpers/` altında toplanmıştır.
* `WaitHelper`, `ScrollHelper`, `LoanCalculator` gibi yardımcı sınıflar ile tekrar eden işlemler modüler hale getirilmiştir.
* `config.properties` dosyası üzerinden tarayıcı tipi, timeout gibi konfigürasyonlar yönetilebilir.
* `ExtentReports` ile HTML formatında detaylı test raporları oluşturulmaktadır.
* Her test adımında ekran görüntüsü alma özelliği entegre edilmiştir (başarılı veya başarısız fark etmeksizin).
* TestNG framework'ü kullanılmakta olup, test sınıfları `test/java/test/` dizininde yer almaktadır.
* `resources/` klasöründeki yapılandırmalar sayesinde proje esnek ve sürdürülebilir hale getirilmiştir.

---



## 🙏 Teşekkürler



<br/>




