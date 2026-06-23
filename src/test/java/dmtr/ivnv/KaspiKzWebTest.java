package dmtr.ivnv;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import dmtr.ivnv.data.Localizations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class KaspiKzWebTest extends TestBase {
    @EnumSource(Localizations.class)
    @ParameterizedTest
    @Tag("WEB")
    @DisplayName("На главной kaspi.kz есть возможность переключить локализацию")
    void kaspiSiteShouldHaveLocalizations (Localizations localization) {
        open("");
        $(".lang-switcher").shouldHave(text(Localizations.description);
    }
}
