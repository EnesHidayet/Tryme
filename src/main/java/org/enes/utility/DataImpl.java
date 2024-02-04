package org.enes.utility;

import org.apache.catalina.User;
import org.enes.entity.*;
import org.enes.repository.KullaniciRepository;
import org.enes.repository.SepetRepository;
import org.enes.service.*;
import org.enes.utility.enums.EBeden;
import org.enes.utility.enums.ECinsiyet;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {
    private final KullaniciService kullaniciService;
    private final UrunService urunService;
    private final MarkaService markaService;
    private final AdresService adresService;
    private final SepetService sepetService;
    private final ResimService resimService;
    private final ModelService modelService;
    private final KategoriService kategoriService;
    private final AltKategoriService altKategoriService;
    private final UrunOzellikleriService urunOzellikleriService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        createKullanici();
        createUrun();
    }

    public void createKullanici(){
        Adres adres = Adres.builder()
                .il("Amasya")
                .ilce("Merkez")
                .adres("x mahallesi")
                .aciklama("Ev")
                .build();

        adresService.save(adres);

        Sepet sepet = Sepet.builder()
                .build();

        sepetService.save(sepet);

        Resim resim = Resim.builder()
                .resimUrl("enes.jpeg")
                .build();
        resimService.save(resim);

        Kullanici kullanici = Kullanici.builder()
                .ad("Enes")
                .soyad("ASLAN")
                .kullaniciAdi("eha")
                .email("eha@gmail.com")
                .password("enes1234")
                .rePassword("enes1234")
                .telefon("5555555555")
                .cinsiyet(ECinsiyet.ERKEK)
                .anaResimUrl("enes.jpeq")
                .adresler(List.of(adres.getId()))
                .anaResimUrl("enesMain.jpeq")
                .resimler(List.of(resim.getId()))
                .sepetId(sepet.getId())
                .build();

        kullaniciService.save(kullanici);

        //////////////////////////////////////////////////////

        Adres adres1 = Adres.builder()
                .il("Ankara")
                .ilce("Etimesgut")
                .adres("y mahallesi")
                .aciklama("Ev")
                .build();

        adresService.save(adres1);

        Sepet sepet1 = Sepet.builder()
                .build();

        sepetService.save(sepet1);

        Resim resim1 = Resim.builder()
                .resimUrl("ayşe.jpeg")
                .build();
        resimService.save(resim1);

        Kullanici kullanici1 = Kullanici.builder()
                .ad("Ayşe")
                .soyad("YILMAZ")
                .kullaniciAdi("ayşo")
                .email("ayşe@gmail.com")
                .password("ayşe1234")
                .rePassword("ayşe1234")
                .telefon("444444444")
                .cinsiyet(ECinsiyet.KADIN)
                .anaResimUrl("ayşe.jpeq")
                .adresler(List.of(adres1.getId()))
                .anaResimUrl("ayşeMain.jpeq")
                .resimler(List.of(resim1.getId()))
                .sepetId(sepet1.getId())
                .build();

        kullaniciService.save(kullanici1);

    }

    public void createUrun(){
        Resim resim = Resim.builder()
                .resimUrl("pantolon.jpeg")
                .build();
        resimService.save(resim);

        Model model = Model.builder()
                .modelAdi("GenişX")
                .build();
        modelService.save(model);


        Model model1 = Model.builder()
                .modelAdi("ÇicekliX")
                .build();
        modelService.save(model1);

        Marka marka = Marka.builder()
                .markaAdi("Mavi")
                .model(List.of(model.getId(),model1.getId()))
                .build();
        markaService.save(marka);

        AltKategori altKategori = AltKategori.builder()
                .altKategoriAdi("Pantolon")
                .build();
        altKategoriService.save(altKategori);

        AltKategori altKategori1 = AltKategori.builder()
                .altKategoriAdi("Elbise")
                .build();
        altKategoriService.save(altKategori1);

        AltKategori altKategori2 = AltKategori.builder()
                .altKategoriAdi("SweatShirt")
                .build();
        altKategoriService.save(altKategori2);

        AltKategori altKategori3 = AltKategori.builder()
                .altKategoriAdi("Kazak")
                .build();
        altKategoriService.save(altKategori3);

        Kategori kategori = Kategori.builder()
                .kategoriAdi("Giyim")
                .altKategori(List.of(altKategori.getId(),altKategori1.getId(),altKategori2.getId(),altKategori3.getId()))
                .build();
        kategoriService.save(kategori);

        UrunOzellikleri urunOzellikleri = UrunOzellikleri.builder()
                .kumasTipi("Kot")
                .kumasRengi("Siyah")
                .aciklama("Güzel bir pantolon")
                .geriDonusturulebilirMi(true)
                .beden(EBeden.L)
                .cinsiyet(ECinsiyet.ERKEK)
                .build();
        urunOzellikleriService.save(urunOzellikleri);

        Urun urun = Urun.builder()
                .urunAdi("Pantolon")
                .aciklama("Güzel bir pantolon")
                .fiyat(1250D)
                .stok(15)
                .anaResimUrl("pantolonMain.jpeg")
                .markaId(marka.getId())
                .modelId(model.getId())
                .altKategoriId(altKategori.getId())
                .kategoriId(kategori.getId())
                .resim(List.of(resim.getId()))
                .urunOzellikleriId(urunOzellikleri.getId())
                .build();
        urunService.save(urun);

        ///////////////////////////////////////////////////////////

        Resim resim1 = Resim.builder()
                .resimUrl("elbise.jpeg")
                .build();
        resimService.save(resim1);

        UrunOzellikleri urunOzellikleri1 = UrunOzellikleri.builder()
                .kumasTipi("Saten")
                .kumasRengi("Beyaz")
                .desenliMi(true)
                .aciklama("Güzel bir elbise")
                .geriDonusturulebilirMi(true)
                .beden(EBeden.M)
                .cinsiyet(ECinsiyet.KADIN)
                .build();
        urunOzellikleriService.save(urunOzellikleri1);

        Urun urun1 = Urun.builder()
                .urunAdi("Elbise")
                .aciklama("Güzel bir elbise")
                .fiyat(5000D)
                .stok(15)
                .anaResimUrl("ElbiseMain.jpeg")
                .markaId(marka.getId())
                .modelId(model1.getId())
                .altKategoriId(altKategori1.getId())
                .kategoriId(kategori.getId())
                .resim(List.of(resim1.getId()))
                .urunOzellikleriId(urunOzellikleri1.getId())
                .build();
        urunService.save(urun1);

        ///////////////////////////////////////////////

        Resim resim2 = Resim.builder()
                .resimUrl("pantolon.jpeg")
                .build();
        resimService.save(resim2);

        UrunOzellikleri urunOzellikleri2 = UrunOzellikleri.builder()
                .kumasTipi("Kot")
                .kumasRengi("Kırmızı")
                .desenliMi(true)
                .aciklama("Güzel bir pantolon")
                .geriDonusturulebilirMi(true)
                .beden(EBeden.XL)
                .cinsiyet(ECinsiyet.KADIN)
                .build();
        urunOzellikleriService.save(urunOzellikleri2);

        Urun urun2 = Urun.builder()
                .urunAdi("Pantolon")
                .aciklama("Güzel bir pantolon")
                .fiyat(3250D)
                .stok(15)
                .anaResimUrl("pantolonMain.jpeg")
                .markaId(marka.getId())
                .modelId(model.getId())
                .altKategoriId(altKategori.getId())
                .kategoriId(kategori.getId())
                .resim(List.of(resim2.getId()))
                .urunOzellikleriId(urunOzellikleri2.getId())
                .build();
        urunService.save(urun2);

        /////////////////////////////////////////////////////////////

        Resim resim3 = Resim.builder()
                .resimUrl("elbise.jpeg")
                .build();
        resimService.save(resim3);

        UrunOzellikleri urunOzellikleri3 = UrunOzellikleri.builder()
                .kumasTipi("Saten")
                .kumasRengi("Siyah")
                .desenliMi(true)
                .aciklama("Güzel bir elbise")
                .geriDonusturulebilirMi(true)
                .beden(EBeden.L)
                .cinsiyet(ECinsiyet.KADIN)
                .build();
        urunOzellikleriService.save(urunOzellikleri3);

        Model model2 = Model.builder()
                .modelAdi("VakkoGang")
                .build();
        modelService.save(model2);

        Model model3 = Model.builder()
                .modelAdi("VakkoCix")
                .build();
        modelService.save(model3);

        Marka marka1 = Marka.builder()
                .markaAdi("Vakko")
                .model(List.of(model2.getId()))
                .build();
        markaService.save(marka1);

        Urun urun3 = Urun.builder()
                .urunAdi("Elbise")
                .aciklama("Güzel bir elbise")
                .fiyat(7000D)
                .stok(15)
                .anaResimUrl("ElbiseMain.jpeg")
                .markaId(marka1.getId())
                .modelId(model2.getId())
                .altKategoriId(altKategori1.getId())
                .kategoriId(kategori.getId())
                .resim(List.of(resim3.getId()))
                .urunOzellikleriId(urunOzellikleri3.getId())
                .build();
        urunService.save(urun3);

        ///////////////////////////////////////////////////////

        Resim resim4 = Resim.builder()
                .resimUrl("sweatshirt.jpeg")
                .build();
        resimService.save(resim4);

        UrunOzellikleri urunOzellikleri4 = UrunOzellikleri.builder()
                .kumasTipi("Polyester")
                .kumasRengi("Mor")
                .desenliMi(true)
                .aciklama("Güzel bir sweatshirt")
                .geriDonusturulebilirMi(true)
                .beden(EBeden.XL)
                .cinsiyet(ECinsiyet.ERKEK)
                .build();
        urunOzellikleriService.save(urunOzellikleri4);

        Urun urun4 = Urun.builder()
                .urunAdi("SweatShirt")
                .aciklama("Güzel bir sweatshirt")
                .fiyat(550D)
                .stok(15)
                .anaResimUrl("sweatMain.jpeg")
                .markaId(marka1.getId())
                .modelId(model3.getId())
                .altKategoriId(altKategori2.getId())
                .kategoriId(kategori.getId())
                .resim(List.of(resim4.getId()))
                .urunOzellikleriId(urunOzellikleri4.getId())
                .build();
        urunService.save(urun4);


        ///////////////////////////////////////////////////////

        Resim resim5 = Resim.builder()
                .resimUrl("sweatshirt.jpeg")
                .build();
        resimService.save(resim5);

        UrunOzellikleri urunOzellikleri5 = UrunOzellikleri.builder()
                .kumasTipi("Pamuk")
                .kumasRengi("Beyaz")
                .desenliMi(true)
                .aciklama("Güzel bir sweatshirt")
                .geriDonusturulebilirMi(true)
                .beden(EBeden.L)
                .cinsiyet(ECinsiyet.KADIN)
                .build();
        urunOzellikleriService.save(urunOzellikleri5);

        Model model4 = Model.builder()
                .modelAdi("WaikikiStyle")
                .build();
        modelService.save(model4);

        Marka marka2= Marka.builder()
                .markaAdi("LCW")
                .model(List.of(model4.getId()))
                .build();
        markaService.save(marka2);

        Urun urun5 = Urun.builder()
                .urunAdi("SweatShirt")
                .aciklama("Güzel bir sweatshirt")
                .fiyat(990D)
                .stok(15)
                .anaResimUrl("SweatMain.jpeg")
                .markaId(marka2.getId())
                .modelId(model4.getId())
                .altKategoriId(altKategori2.getId())
                .kategoriId(kategori.getId())
                .resim(List.of(resim5.getId()))
                .urunOzellikleriId(urunOzellikleri5.getId())
                .build();
        urunService.save(urun5);

        ////////////////////////////////////////////////////////

        Resim resim6 = Resim.builder()
                .resimUrl("Kazak.jpeg")
                .build();
        resimService.save(resim6);

        UrunOzellikleri urunOzellikleri6 = UrunOzellikleri.builder()
                .kumasTipi("Pamuk")
                .kumasRengi("Beyaz")
                .desenliMi(true)
                .aciklama("Güzel bir Kazak")
                .geriDonusturulebilirMi(true)
                .beden(EBeden.L)
                .cinsiyet(ECinsiyet.KADIN)
                .build();
        urunOzellikleriService.save(urunOzellikleri6);

        Model model5 = Model.builder()
                .modelAdi("DefactoStyle")
                .build();
        modelService.save(model5);

        Marka marka3= Marka.builder()
                .markaAdi("Defacto")
                .model(List.of(model5.getId()))
                .build();
        markaService.save(marka3);

        Urun urun6 = Urun.builder()
                .urunAdi("Kazak")
                .aciklama("Güzel bir Kazak")
                .fiyat(478D)
                .stok(15)
                .anaResimUrl("Kazak.jpeg")
                .markaId(marka3.getId())
                .modelId(model5.getId())
                .altKategoriId(altKategori3.getId())
                .kategoriId(kategori.getId())
                .resim(List.of(resim6.getId()))
                .urunOzellikleriId(urunOzellikleri6.getId())
                .build();
        urunService.save(urun6);
    }
}
