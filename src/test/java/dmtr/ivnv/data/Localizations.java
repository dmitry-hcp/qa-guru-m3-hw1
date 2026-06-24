package dmtr.ivnv.data;

public enum Localizations {
    RU(
            "Рус",
            "Сервисы Kaspi.kz",
            "Интернет-магазин на Kaspi.kz",
            "Продукты Kaspi.kz",
            "Для Бизнеса",
            "Принимайте оплату с Kaspi Pay",
            "Стать Партнером",
            "Сканируйте, чтобы перейти в приложение Kaspi.kz"
    ),
    KZ(
            "Қаз",
            "Kaspi.kz өнімдері",
            "Kaspi.kz-тегі интернет-дүкен",
            "Kaspi.kz өнімдері",
            "Бизнеске",
            "Kaspi Pay арқылы төлем қабылдаңыз",
            "Серіктес болыңыз",
            "Kaspi.kz қосымшасына өту үшін кодты сканерлеңіз"
    );

    public final String local;
    public final String mainTitle;
    public final String kaspiShopTitle;
    public final String productsTitle;
    public final String entrepreneursTitle;
    public final String terminalTitle;
    public final String stayPartnerTitle;
    public final String appQrTitle;

    Localizations(
            String local,
            String mainTitle,
            String kaspiShopTitle,
            String productsTitle,
            String entrepreneursTitle,
            String terminalTitle,
            String stayPartnerTitle,
            String appQrTitle

    ) {
        this.local = local;
        this.mainTitle = mainTitle;
        this.kaspiShopTitle = kaspiShopTitle;
        this.productsTitle = productsTitle;
        this.entrepreneursTitle = entrepreneursTitle;
        this.terminalTitle = terminalTitle;
        this.stayPartnerTitle = stayPartnerTitle;
        this.appQrTitle = appQrTitle;
    }
}
