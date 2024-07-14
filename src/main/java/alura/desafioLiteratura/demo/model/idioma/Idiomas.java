package alura.desafioLiteratura.demo.model.idioma;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Idiomas {
    AF("af", "Afrikáans"),
    AM("am", "Amárico"),
    AR("ar", "Árabe"),
    AZ("az", "Azerbaiyano"),
    BE("be", "Bielorruso"),
    BG("bg", "Búlgaro"),
    BN("bn", "Bengalí"),
    BS("bs", "Bosnio"),
    CA("ca", "Catalán"),
    CEB("ceb", "Cebuano"),
    CO("co", "Corso"),
    CS("cs", "Checo"),
    CY("cy", "Galés"),
    DA("da", "Danés"),
    DE("de", "Alemán"),
    EL("el", "Griego"),
    EN("en", "Inglés"),
    EO("eo", "Esperanto"),
    ES("es", "Español"),
    ET("et", "Estonio"),
    EU("eu", "Euskera"),
    FA("fa", "Persa"),
    FI("fi", "Finlandés"),
    FR("fr", "Francés"),
    FY("fy", "Frisón"),
    GA("ga", "Irlandés"),
    GD("gd", "Gaélico escocés"),
    GL("gl", "Gallego"),
    GU("gu", "Gujarati"),
    HA("ha", "Hausa"),
    HAW("haw", "Hawaiano"),
    HE("he", "Hebreo"),
    HI("hi", "Hindi"),
    HMN("hmn", "Hmong"),
    HR("hr", "Croata"),
    HT("ht", "Criollo haitiano"),
    HU("hu", "Húngaro"),
    HY("hy", "Armenio"),
    ID("id", "Indonesio"),
    IG("ig", "Igbo"),
    IS("is", "Islandés"),
    IT("it", "Italiano"),
    IW("iw", "Hebreo"),
    JA("ja", "Japonés"),
    JW("jw", "Javanés"),
    KA("ka", "Georgiano"),
    KK("kk", "Kazajo"),
    KM("km", "Jemer"),
    KN("kn", "Canarés"),
    KO("ko", "Coreano"),
    KU("ku", "Kurdo (Kurmanji)"),
    KY("ky", "Kirguís"),
    LA("la", "Latín"),
    LB("lb", "Luxemburgués"),
    LO("lo", "Lao"),
    LT("lt", "Lituano"),
    LV("lv", "Letón"),
    MG("mg", "Malgache"),
    MI("mi", "Maorí"),
    MK("mk", "Macedonio"),
    ML("ml", "Malayalam"),
    MN("mn", "Mongol"),
    MR("mr", "Marathi"),
    MS("ms", "Malayo"),
    MT("mt", "Maltés"),
    MY("my", "Birmano"),
    NE("ne", "Nepalí"),
    NL("nl", "Neerlandés"),
    NO("no", "Noruego"),
    NY("ny", "Chichewa"),
    PA("pa", "Punyabí"),
    PL("pl", "Polaco"),
    PS("ps", "Pastún"),
    PT("pt", "Portugués"),
    RO("ro", "Rumano"),
    RW("rw", "Kinyarwanda"),
    RU("ru", "Ruso"),
    SD("sd", "Sindhi"),
    SI("si", "Cingalés"),
    SK("sk", "Eslovaco"),
    SL("sl", "Esloveno"),
    SM("sm", "Samoano"),
    SN("sn", "Shona"),
    SO("so", "Somalí"),
    SQ("sq", "Albanés"),
    SR("sr", "Serbio"),
    ST("st", "Sesotho"),
    SU("su", "Sundanés"),
    SV("sv", "Sueco"),
    SW("sw", "Suajili"),
    TA("ta", "Tamil"),
    TE("te", "Telugu"),
    TG("tg", "Tayiko"),
    TH("th", "Tailandés"),
    TL("tl", "Filipino"),
    TR("tr", "Turco"),
    UK("uk", "Ucraniano"),
    UR("ur", "Urdu"),
    UZ("uz", "Uzbeko"),
    VI("vi", "Vietnamita"),
    XH("xh", "Xhosa"),
    YI("yi", "Yidis"),
    YO("yo", "Yoruba"),
    ZU("zu", "Zulú"),
    ZH("zh", "Chino (simplificado)"),
    ZH_TW("zh-TW", "Chino (tradicional)");

    private static final Map<String, Idiomas> ABBREVIATION_TO_ENUM_MAP = Stream.of(values())
            .collect(Collectors.toMap(Idiomas::getAbreviaturas, idioma -> idioma));

    private final String abreviaturas;
    private final String nombreIdioma;

    Idiomas(String abreviaturas, String nombreIdioma) {
        this.abreviaturas = abreviaturas;
        this.nombreIdioma = nombreIdioma;
    }

    public String getAbreviaturas() {
        return abreviaturas;
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public static Idiomas from(String abreviaturas) {
        Idiomas idioma = ABBREVIATION_TO_ENUM_MAP.get(abreviaturas.toLowerCase());
        if (idioma != null) {
            return idioma;
        }
        throw new IllegalArgumentException("Idioma no disponible");
    }
}
