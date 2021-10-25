@validatingMeldsWithoutJoker

Feature: Validating Melds without Joker
  One player attempts to play valid and invalid melds after getting initial 30 points

  Background:
    Given game has started and player gained initial points

  @test1
  Scenario Outline: validatingMelds-1run
    When player1 attempts to play <run> as run
    Then game outputs <output>

    Examples:
      |run|output|
      |B3 B4|invalid meld|
      |B3 B4 G5|invalid meld|
      |R9 R10 R11 R12 R3|invalid meld|
      |B3 B4 B5|updated player hand AND updated table for B3 B4 B5|
      |R9 R10 R11 R12 R13|updated player hand AND updated table for R9 R10 R11 R12 R13|

  @test2
  Scenario Outline: validatingMelds-1set
    When player1 attempts to play <set> as set
    Then game outputs <output>

    Examples:
      |set|output|
      |R7 B7|invalid meld|
      |R4 G4 R4|invalid meld|
      |R1 B5 G1 O1|invalid meld|
      |R7 B7 G7|updated player hand AND updated table for R7 B7 G7|
      |R1 B1 G1 O1|updated player hand AND updated table for R1 B1 G1 O1|