Feature: Kart CRUD işlemleri test özellikleri

  Scenario: Bir kart başarıyla kaydedilmelidir.
    Given "C-1" kartı var iken
    When  "C-1" kartı post edildiğinde
    Then Kart başarıyla kaydedilir

  Scenario: Tüm kayıtlı kartlar başarıyla listelenmelidir.
    When Tüm kartlar için Get request'i atıldığında
    Then Tüm kartlar başarıyla listelenir

  Scenario: Kart başarıyla silinmeldir.
    Given "C-1" kartı var iken
    When "C-1" kartına silme isteği atıldığında
    Then Kart başarıyla silinir.

  Scenario: Kart başarıyla güncellenmelidir.
    Given "C-1" kartı var iken
    When "C-1" kartında güncellemeler yapıldığında
    Then Kart başarı ile güncellenir

  Scenario: Kart kaydında hata vermelidir.
    Given "C-1" kartı var iken"
    When "C-1" kartı başvuran'ı boş post edildiğinde
    Then Hata verilir

  Scenario: Kart kaydında hata vermelidir.
    Given "C-1" kartı var iken"
    When "C-1" kartı şehir-olanak'ı boş post edildiğinde
    Then Hata verilir

  Scenario: Kart kaydında hata vermelidir.
    Given "C-1" kartı var iken"
    When "C-1" kartı şehir-olanak'ı boş post edildiğinde
    Then Hata verilir
