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

public class ValidatingMeldsWithoutJoker {

    List<String> checkMeld = null;
    Server server = null;

    @Given("game has started and player gained initial points")
    public void game_has_started_and_player_gained_initial_points() {
        // Write code here that turns the phrase above into concrete actions
        server = new Server();
        server.distributeTilesToPlayers();
        server.initial30Points[0] = true;
    }

    @When("player1 attempts to play B3 B4 as run")
    public void player1_attempts_to_play_b3_b4_as_run() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "B3", server);
        Utils.fixHand(0, "B4", server);

        server.playAMeld("{B3 B4}", 0);
    }

    @Then("game outputs invalid meld")
    public void game_outputs_invalid_meld() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(server.meldValidity);
    }

    @When("player1 attempts to play B3 B4 G5 as run")
    public void player1_attempts_to_play_b3_b4_g5_as_run() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "B3", server);
        Utils.fixHand(0, "B4", server);
        Utils.fixHand(0, "G5", server);

        server.playAMeld("{B3 B4 G5}", 0);
    }

    @When("player1 attempts to play R9 R10 R11 R12 R3 as run")
    public void player1_attempts_to_play_r9_r10_r11_r12_r3_as_run() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R9", server);
        Utils.fixHand(0, "R10", server);
        Utils.fixHand(0, "R11", server);
        Utils.fixHand(0, "R12", server);
        Utils.fixHand(0, "R3", server);

        server.playAMeld("{R9 R10 R11 R12 R3}", 0);

    }

    @When("player1 attempts to play B3 B4 B5 as run")
    public void player1_attempts_to_play_b3_b4_b5_as_run() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "B3", server);
        Utils.fixHand(0, "B4", server);
        Utils.fixHand(0, "B5", server);

        server.playAMeld("{B3 B4 B5}", 0);
    }

    @Then("game outputs updated player hand AND updated table for B3 B4 B5")
    public void game_outputs_updated_player_hand_and_updated_table_for_b3_b4_b5() {
        // Write code here that turns the phrase above into concrete actions

        assertTrue(server.meldValidity);

        assertFalse(Utils.checkHand(0, "B3", server));
        assertFalse(Utils.checkHand(0, "B4", server));
        assertFalse(Utils.checkHand(0, "B5", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("B3", "B4", "B5")
        );

        assertTrue(Utils.checkTable(checkMeld, server));
    }

    @When("player1 attempts to play R9 R10 R11 R12 R13 as run")
    public void player1_attempts_to_play_r9_r10_r11_r12_r13_as_run() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R9", server);
        Utils.fixHand(0, "R10", server);
        Utils.fixHand(0, "R11", server);
        Utils.fixHand(0, "R12", server);
        Utils.fixHand(0, "R13", server);

        server.playAMeld("{R9 R10 R11 R12 R13}", 0);
    }

    @Then("game outputs updated player hand AND updated table for R9 R10 R11 R12 R13")
    public void game_outputs_updated_player_hand_and_updated_table_for_r9_r10_r11_r12_r13() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(server.meldValidity);

        assertFalse(Utils.checkHand(0, "R9", server));
        assertFalse(Utils.checkHand(0, "R10", server));
        assertFalse(Utils.checkHand(0, "R11", server));
        assertFalse(Utils.checkHand(0, "R12", server));
        assertFalse(Utils.checkHand(0, "R13", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R9", "R10", "R11", "R12", "R13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }

    @When("player1 attempts to play R7 B7 as set")
    public void player1_attempts_to_play_r7_b7_as_set() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R7", server);
        Utils.fixHand(0, "B7", server);

        server.playAMeld("{R7 B7}", 0);

    }

    @When("player1 attempts to play R4 G4 R4 as set")
    public void player1_attempts_to_play_r4_g4_r4_as_set() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R4", server);
        Utils.fixHand(0, "G4", server);
        Utils.fixHand(0, "R4", server);

        server.playAMeld("{R4 G4 R4}", 0);
    }

    @When("player1 attempts to play R1 B5 G1 O1 as set")
    public void player1_attempts_to_play_r1_b5_g1_o1_as_set() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R1", server);
        Utils.fixHand(0, "B5", server);
        Utils.fixHand(0, "G1", server);
        Utils.fixHand(0, "O1", server);

        server.playAMeld("{R1 B5 G1 O1}", 0);
    }

    @When("player1 attempts to play R7 B7 G7 as set")
    public void player1_attempts_to_play_r7_b7_g7_as_set() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R7", server);
        Utils.fixHand(0, "B7", server);
        Utils.fixHand(0, "G7", server);

        server.playAMeld("{R7 B7 G7}", 0);
    }

    @Then("game outputs updated player hand AND updated table for R7 B7 G7")
    public void game_outputs_updated_player_hand_and_updated_table_for_r7_b7_g7() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(server.meldValidity);

        assertFalse(Utils.checkHand(0, "R7", server));
        assertFalse(Utils.checkHand(0, "B7", server));
        assertFalse(Utils.checkHand(0, "G7", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R7", "B7", "G7")
        );

        assertTrue(Utils.checkTable(checkMeld, server));
    }

    @When("player1 attempts to play R1 B1 G1 O1 as set")
    public void player1_attempts_to_play_r1_b1_g1_o1_as_set() {
        // Write code here that turns the phrase above into concrete actions
        Utils.fixHand(0, "R1", server);
        Utils.fixHand(0, "B1", server);
        Utils.fixHand(0, "G1", server);
        Utils.fixHand(0, "O1", server);

        server.playAMeld("{R1 B1 G1 O1}", 0);
    }

    @Then("game outputs updated player hand AND updated table for R1 B1 G1 O1")
    public void game_outputs_updated_player_hand_and_updated_table_for_r1_b1_g1_o1() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(server.meldValidity);

        assertFalse(Utils.checkHand(0, "R1", server));
        assertFalse(Utils.checkHand(0, "B1", server));
        assertFalse(Utils.checkHand(0, "G1", server));
        assertFalse(Utils.checkHand(0, "O1", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R1", "B1", "G1", "O1")
        );

        assertTrue(Utils.checkTable(checkMeld, server));
    }

}