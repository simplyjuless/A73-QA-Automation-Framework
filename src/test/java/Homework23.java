package POM;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {
    //public static Actions actions = null;
    String newPlayListName = "Gym";

    @Test
    public void renamePlaylist() {
        //String oldName = "Test Pro Playlist";
        //String newName = "Gym";
        String expectedRenameMessage = "Updated playlist \"" + "Gym" + "\"";

        // Initialize POM pages
        Loginpage loginPage = new Loginpage(driver);
        Homepage homepage = new Homepage(driver);

        //Login
        loginPage.login("julia.munoz@testpro.io", "Ltdan25!");

        //Rename playlist using PageFactory methods
        homepage.doubleClickPlaylist();
        homepage.enterNewPlaylistName("Gym");

        //Assert success msg
        Assert.assertEquals(
                homepage.getRenamePlaylistSuccessMsg(),
                expectedRenameMessage,
                "Playlist rename failed!"
        );

    }
}
