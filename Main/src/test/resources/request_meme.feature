Feature: Test Meme Request
Scenario Outline: Meme Dank or Normie
Given I would liek to git some dank stuff
When I try to git '<meme>' meme
Then I should see it is as dank as '<danklevel>'

Examples:
| meme			| danklevel |
| LennyFace		| 1337	    |
| Dolan			| 69	    |
| Doge			| 666	    |
