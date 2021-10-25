package stepDefinitionFiles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.Server;
import project.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Initial30WithJoker {

    List<String> checkMeld = null;
    Server server = null;

    @Given("game has started with joker")
    public void game_has_started_with_joker() {
        // Write code here that turns the phrase above into concrete actions
        server = new Server();
        server.distributeTilesToPlayers();
    }

    @When("player1 attempts to play R8 R9 * as initial run")
    public void player1_attempts_to_play_r8_r9_as_initial_run() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R8", server);
        Utils.fixHand(0, "R9", server);
        Utils.fixHand(0, "*", server);

        server.playAMeld("{R8 R9 *}", 0);
    }

    @Then("game outputs insufficient total for initial tiles with joker")
    public void game_outputs_insufficient_total_for_initial_tiles_with_joker() {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(false, server.initial30Points[0]);
        assertEquals("insufficient total for initial tiles", server.initial30PointsOutput);
    }

    @When("player1 attempts to play * R10 R11 as initial run")
    public void player1_attempts_to_play_r10_r11_as_initial_run() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "*", server);
        Utils.fixHand(0, "R10", server);
        Utils.fixHand(0, "R11", server);

        server.playAMeld("{* R10 R11}", 0);
    }

    @Then("game outputs updated player hand AND updated table for * R10 R11")
    public void game_outputs_updated_player_hand_and_updated_table_for_r10_r11() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(Utils.checkHand(0, "*", server));
        assertFalse(Utils.checkHand(0, "R10", server));
        assertFalse(Utils.checkHand(0, "R11", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("*", "R10", "R11")
        );

        assertTrue(Utils.checkTable(checkMeld, server));
        assertTrue(server.initial30Points[0]);
        assertEquals("hand and table updated", server.initial30PointsOutput);
    }

    @When("player1 attempts to play R8 R9 * R11 as initial run")
    public void player1_attempts_to_play_r8_r9_r11_as_initial_run() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R8", server);
        Utils.fixHand(0, "R9", server);
        Utils.fixHand(0, "*", server);
        Utils.fixHand(0, "R11", server);

        server.playAMeld("{R8 R9 * R11}", 0);
    }

    @Then("game outputs updated player hand AND updated table for R8 R9 * R11")
    public void game_outputs_updated_player_hand_and_updated_table_for_r8_r9_r11() {
        // Write code here that turns the phrase above into concrete actions

        assertFalse(Utils.checkHand(0, "R8", server));
        assertFalse(Utils.checkHand(0, "R9", server));
        assertFalse(Utils.checkHand(0, "*", server));
        assertFalse(Utils.checkHand(0, "R11", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R8", "R9", "*", "R11")
        );

        assertTrue(Utils.checkTable(checkMeld, server));
        assertTrue(server.initial30Points[0]);
        assertEquals("hand and table updated", server.initial30PointsOutput);

    }

    @When("player1 attempts to play R10 B10 * as initial set")
    public void player1_attempts_to_play_r10_b10_as_initial_set() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R10", server);
        Utils.fixHand(0, "B10", server);
        Utils.fixHand(0, "*", server);

        server.playAMeld("{R10 B10 *}", 0);
    }

    @Then("game outputs updated player hand AND updated table for R10 B10 *")
    public void game_outputs_updated_player_hand_and_updated_table_for_r10_b10() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(Utils.checkHand(0, "R10", server));
        assertFalse(Utils.checkHand(0, "B10", server));
        assertFalse(Utils.checkHand(0, "*", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R10", "B10", "*")
        );

        assertTrue(Utils.checkTable(checkMeld, server));
        assertTrue(server.initial30Points[0]);
        assertEquals("hand and table updated", server.initial30PointsOutput);
    }

    @When("player1 attempts to play R10 * G10 O10 as initial set")
    public void player1_attempts_to_play_r10_g10_o10_as_initial_set() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R10", server);
        Utils.fixHand(0, "*", server);
        Utils.fixHand(0, "G10", server);
        Utils.fixHand(0, "O10", server);

        server.playAMeld("{R10 * G10 O10}", 0);
    }

    @Then("game outputs updated player hand AND updated table for R10 * G10 O10")
    public void game_outputs_updated_player_hand_and_updated_table_for_r10_g10_o10() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(Utils.checkHand(0, "R10", server));
        assertFalse(Utils.checkHand(0, "*", server));
        assertFalse(Utils.checkHand(0, "G10", server));
        assertFalse(Utils.checkHand(0, "O10", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R10", "*", "G10", "O10")
        );

        assertTrue(Utils.checkTable(checkMeld, server));
        assertTrue(server.initial30Points[0]);
        assertEquals("hand and table updated", server.initial30PointsOutput);
    }

}