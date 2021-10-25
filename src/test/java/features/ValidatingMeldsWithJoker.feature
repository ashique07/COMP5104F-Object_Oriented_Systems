@validatingMeldsWithJoker

Feature: Validating Melds with Joker
  One player attempts to play valid and invalid melds (including Joker) after getting initial 30 points

  Background:
    Given game has started with Joker and player gained initial points

  @test1
  Scenario Outline: validatingMelds-1run
    When player1 attempts to play <run> as run
    Then game outputs <output>

    Examples:
      |run|output|
      |B3 *|invalid meld with joker|
      |* B4 G5|invalid meld with joker|
      |R9 R10 * R12 R3|invalid meld with joker|
      |B3 * B5|updated player hand AND updated table for B3 * B5|
      |R9 R10 R11 * R13|updated player hand AND updated table for R9 R10 R11 * R13|

  @test2
  Scenario Outline: validatingMelds-1set
    When player1 attempts to play <set> as set
    Then game outputs <output>

    Examples:
      |set|output|
      |R7 *|invalid meld with joker|
      |R4 * R4|invalid meld with joker|
      |* B5 G1 O1|invalid meld with joker|
      |R7 * G7|updated player hand AND updated table for R7 * G7|
      |R1 B1 G1 *|updated player hand AND updated table for R1 B1 G1 *|