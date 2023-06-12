Kotlin SQLite Not Alma Uygulaması
---------------------------------
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

Bu proje, Kotlin programlama dili ve SQLite veritabanını kullanarak basit bir not alma uygulamasını temsil etmektedir. Bu uygulama kullanıcının not eklemesini, notları görüntülemesini ve not başlıklarına tıklayarak ayrıntılarına erişmesini sağlar.

Özellikler
----------
Kullanıcı not ekleyebilir ve kaydedebilir.
Kaydedilen notların başlıkları listelenir.
Kullanıcı bir not başlığına tıkladığında, o notun ayrıntıları görüntülenir.

Kurulum
--------
1. Projeyi indirin veya kopyalayın.
2. Android Studio'yu açın ve projeyi içe aktarın.
3. Gerekli bağımlılıkları ve bileşenleri yükleyin.
4. SQLite veritabanını kullanabilmek için, projenin `build.gradle` dosyasına aşağıdaki bağımlılığı ekleyin:

implementation 'androidx.sqlite:sqlite-ktx:2.2.0'

5. Uygulamayı bir Android cihazında veya emülatörde çalıştırın.

Kullanım
--------
Uygulama başladığında ana ekran görüntülenir.
Ana ekran üzerinde "Not Ekle" düğmesine tıklayarak yeni bir not ekleyin.
Not başlığı ve detayını girin, ardından "Kaydet" düğmesine tıklayın.
Kaydedilen not başlıkları ana ekranda listelenir.
Bir not başlığına tıklayarak, o notun ayrıntılarına erişebilirsiniz.

Katkıda Bulunma
---------------
1. Bu projeyi klonlayın.
2. İstenilen değişiklikleri yapın veya yeni özellikler ekleyin.
3. Değişikliklerinizi açıklayan birleştirme isteği (pull request) oluşturun.
