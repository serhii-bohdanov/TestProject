package UI;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @BeforeEach
    void setUpEach() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void tearDownEach() {
        page.close();
        context.close();
    }

    @AfterAll
    static void tearDown() {
        playwright.close();
    }

    @Test
    void testUI() {
        // Your UI test logic here
        page.navigate("https://www.example.com/");
        assertEquals("Example Domain", page.title());
    }
}
