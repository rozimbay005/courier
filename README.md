# Rozimbay — Courier App (Jetpack Compose)

Aurora/glassmorphism bento-grid dizaynining native Android (Kotlin + Jetpack
Compose) versiyasi — web (React) variantidagi bilan bir xil rang va
tarkib tuzilishi.

## APK qanday olinadi (Android Studio shart emas)

1. Ushbu papkadagi barcha fayllarni GitHub'dagi yangi repoga yuklang
   (yoki mavjud repoga, `wifi-transfer-app`dagi kabi "Upload files" orqali).
   `.github/workflows/build.yml` fayli albatta repo ildizida
   `.github/workflows/` papkasida bo'lishi kerak (GitHub web upload paytida
   yashirin `.github` papkasi ba'zan tushib qolishi mumkin — shunga e'tibor
   bering).
2. GitHub repo sahifasida **Actions** bo'limiga o'ting — push qilingandan
   keyin "Build APK" workflow avtomatik ishga tushadi.
3. Workflow tugagach, natija ichidan **rozimbay-debug-apk** artifaktini
   yuklab oling — ichida `app-debug.apk` bo'ladi.
4. APK'ni telefoningizga o'tkazib o'rnating (noma'lum manbalardan o'rnatishga
   ruxsat bering).

## Shriftlarni bir xil qilish (ixtiyoriy)

Hozir tizim shrifti ishlatilmoqda. Web versiyadagi Outfit/Inter shriftlarini
aynan bir xil qilish uchun:

1. Google Fonts'dan `Outfit` va `Inter` `.ttf` fayllarini yuklab oling.
2. `app/src/main/res/font/` papkasini yarating, fayllarni shu yerga qo'ying
   (fayl nomlari kichik harf va pastki chiziq bilan, masalan `outfit_bold.ttf`).
3. `ui/theme/Type.kt` faylidagi `HeadFamily` / `BodyFamily` qatorlarini
   `FontFamily(Font(R.font.outfit_bold, FontWeight.Bold), ...)` ko'rinishiga
   almashtiring.

## Struktura

- `MainActivity.kt` — kirish nuqtasi
- `ui/HomeScreen.kt` — bento-grid ekran + pastki navigatsiya
- `ui/theme/` — ranglar (aurora/glass palitra) va tipografiya

## Keyingi qadamlar

- Har bir bento kartochkani alohida ekranga (`Buyurtma berish`, `Kuryer
  kabineti` va h.k.) bog'lash uchun Navigation Compose qo'shish
- Haqiqiy backend (rozimbay.uz API) bilan ulash — hozircha barcha
  ma'lumotlar statik
