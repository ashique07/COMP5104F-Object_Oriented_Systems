@initial30WithJoker

Feature: Initial 30 points with Joker
  To demonstrate getting initial 30 points with 1 run or 1 set

  Background:
    Given game has started with joker

  @test1
  Scenario Outline: i30-1run
    When player1 attempts to play <run> as initial run
    Then game outputs <output>

    Examples:
      |run|output|
      |R8 R9 *|insufficient total for initial tiles with joker|
      |* R10 R11|updated player hand AND updated table for * R10 R11|
      |R8 R9 * R11|updated player hand AND updated table for R8 R9 * R11|

  @test2
  Scenario Outline: i30-1set
    When player1 attempts to play <set> as initial set
    Then game outputs <output>

    Examples:
      |set|output|
      |R10 B10 *|updated player hand AND updated table for R10 B10 *|
      |R10 * G10 O10|updated player hand AND updated table for R10 * G10 O10|