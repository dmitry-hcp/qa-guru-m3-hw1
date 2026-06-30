package dmtr.ivnv;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

import dmtr.ivnv.data.Localizations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class KaspiKzWebTest extends TestBase {
    @BeforeEach
    void setUp() {
        open("");
    }

    @DisplayName("На главной kaspi.kz есть возможность выбрать локализацию")
    @Tag("WEB")
    @ParameterizedTest(name = "есть вариант {0}")
    @ValueSource(strings = {"Рус", "Қаз"})
    void kaspiSiteShouldHaveLocalizations(String localization) {
        $$(".lang-switcher__item").findBy(text(localization)).shouldBe(visible);
    }

    @DisplayName("Основные разделы локализованы верно")
    @Tag("WEB")
    @ParameterizedTest
    @EnumSource(Localizations.class)
    void kaspiSiteMainSectionsShouldBeLocalizedCorrectly(Localizations localization) {
        $$(".lang-switcher__item").findBy(text(localization.local)).click();
        $(".services__main-title").shouldBe(visible).shouldHave(text(localization.mainTitle));
        $(".kaspi-shop__title").shouldBe(visible).shouldHave(text(localization.kaspiShopTitle));
        $(".products__title").shouldBe(visible).shouldHave(text(localization.productsTitle));
        $(".entrepreneurs__title").shouldBe(visible).shouldHave(text(localization.entrepreneursTitle));
        $(".terminal__title").shouldBe(visible).shouldHave(text(localization.terminalTitle));
        $(".stay-partner__title").shouldBe(visible).shouldHave(text(localization.stayPartnerTitle));
        $(".app-qr__title").shouldBe(visible).shouldHave(text(localization.appQrTitle));
    }

    static Stream<Arguments> kaspiSitServicesCardNamesShouldBeLocalizedCorrectly() {
        return Stream.of(
                Arguments.of(
                        Localizations.RU,
                        List.of("Магазин", "Travel", "Переводы", "Акции",
                                "Платежи", "Объявления", "Мой Банк", "Госуслуги",
                                "Гид")
                ),
                Arguments.of(
                        Localizations.KZ,
                        List.of("Жеке Банк", "Travel", "Аударым", "Науқандар",
                                "Төлемдер", "Хабарландыру", "Мемлекеттік қызметтер", "Гид",
                                "Kaspi.kz-тегі интернет-дүкен")

                )
        );
    }

    @DisplayName("Имена карточек карусели сервисов локалиованы верно")
    @Tag("WEB")
    @MethodSource
    @ParameterizedTest
    void kaspiSitServicesCardNamesShouldBeLocalizedCorrectly(Localizations localization, List<String> servicesCardNames) {
        $$(".lang-switcher__item").findBy(text(localization.local)).click();
        $$(".services-card__name").should(containExactTextsCaseSensitive(servicesCardNames));
    }
}
