import POM.Koel_Homepage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    public String url = "https://qa.koel.app/";

    @Test
    public void loginValidEmailPassword() {
        // Navigate to login page
        driver.get(url);

        // Initialize LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        Koel_Homepage koelHomePage = loginPage.login("julia.munoz@testpro.io", "Ltdan25!");

        // Verify Koel homepage elements
        Assert.assertTrue(koelHomePage.isProfileLinkVisible(), "Profile link not visible!");
        Assert.assertTrue(koelHomePage.isAboutButtonVisible(), "About Koel button not visible!");
        Assert.assertTrue(koelHomePage.isRecentlyPlayedVisible(), "Recently played section missing!");
        Assert.assertTrue(koelHomePage.isRecentlyPlayedViewAllVisible(), "View All button missing in Recently Played!");
        Assert.assertTrue(koelHomePage.isRecentlyAddedAlbumVisible(), "Recently added albums missing!");
        Assert.assertTrue(koelHomePage.isRecentlyAddedDownloadVisible(), "Download icon missing in recently added!");
        Assert.assertTrue(koelHomePage.isRecentlyAddedShuffleVisible(), "Shuffle icon missing in recently added!");
        Assert.assertTrue(koelHomePage.isSearchFieldVisible(), "Search bar not found!");

        // Verify Your Music panel pages
        Assert.assertTrue(koelHomePage.isHomePageTabVisible(), "Home tab missing in Your Music panel!");
        Assert.assertTrue(koelHomePage.isCurrentQueueTabVisible(), "Current Queue tab missing!");
        Assert.assertTrue(koelHomePage.isAllSongsTabVisible(), "All Songs tab missing!");
        Assert.assertTrue(koelHomePage.isAlbumsTabVisible(), "Albums tab missing!");
        Assert.assertTrue(koelHomePage.isArtistsTabVisible(), "Artists tab missing!");

        // Verify Playlists panel
        Assert.assertTrue(koelHomePage.isCreatePlaylistButtonVisible(), "New playlist button missing!");
        Assert.assertTrue(koelHomePage.isCreateSmartPlaylistButtonVisible(), "New Smart Playlist button missing!");
        Assert.assertTrue(koelHomePage.isFavoritesPlaylistVisible(), "Favorites playlist missing!");
        Assert.assertTrue(koelHomePage.isRecentlyPlayedPlaylistVisible(), "Recently Played playlist missing!");
        Assert.assertTrue(koelHomePage.isSmartPlaylistVisible(), "Smart playlist missing!");
        Assert.assertTrue(koelHomePage.isUserCreatedPlaylistVisible(), "User-created playlist missing!");

        // Optional: verify URL
        Assert.assertTrue(driver.getCurrentUrl().contains("qa.koel.app"), "URL after login is incorrect");
    }
}
