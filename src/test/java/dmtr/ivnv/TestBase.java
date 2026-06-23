package dmtr.ivnv;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://kaspi.kz";
    }
}
