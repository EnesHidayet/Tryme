package org.enes.constants;

public class RestApiUrl {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";
    private static final String ROOT = DEV+VERSION;

    public static final String KULLANICI=ROOT+"/kullanici";
    public static final String ADRES=ROOT+"/adres";
    public static final String ALTKATEGORI=ROOT+"/alt-kategori";
    public static final String KATEGORI=ROOT+"/kategori";
    public static final String MARKA=ROOT+"/marka";
    public static final String MODEL=ROOT+"/model";
    public static final String RESIMLER=ROOT+"/resimler";
    public static final String SEPET=ROOT+"/sepet";
    public static final String URUNOZELLIKLERI=ROOT+"/urun-ozellikleri";
    public static final String URUN=ROOT+"/urun";

    public static final String SAVE="/save";
    public static final String REGISTER="/register";
    public static final String LOGIN="/login";

    public static final String FIND_ALL="/find-all";

    public static final String FIND_BY_ID="/find-by-id";
    public static final String FIND_ALL_BY_CINSIYET="/find-all-by-cinsiyet";
    public static final String FIND_ALL_BY_BEDEN="/find-all-by-beden";
    public static final String FIND_ALL_BY_CINSIYET_AND_BEDEN="/find-all-by-cinsiyet-and-beden";
    public static final String FIND_BY_URUN_ADI="/find-by-urun-adi";
    public static final String FIND_ALL_BY_FIYAT="/find-all-by-fiyat";
    public static final String FIND_ALL_BY_MARKA="/find-all-by-marka";
    public static final String FIND_ALL_BY_MODEL="/find-all-by-model";
    public static final String FIND_ALL_BY_KATEGORI="/find-all-by-kategori";
    public static final String FIND_ALL_BY_ALT_KATEGORI="/find-all-by-altkategori";
    public static final String ADD_URUN="/add_urun";



    public static final String DELETE="/delete";
}
