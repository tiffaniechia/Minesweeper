# Minesweeper

Aim was to build the minesweeper game with object calisthenics as rules.
Pairing done with vinh

## Object Calisthenics (Rules): 
1) ONE level of indentation per method
2) Do not use 'else'
3) Wrap all primitives and strings
4) First class collections
5) One dot per line
6) Do not abbreviate
7) Keep all entities small (No class over 50 lines and no package over 10 files)
8) No classes with more than two instance variables
9) No getters/setters/properties

## The Minesweeper game: 
Minesweeper is a single player puzzle game.
The objective of the game is to clear aboard containing hidden 'mines' without detonating them,
with help from clues about the number of neighbouring mines in each field.

Your program will setup the game and present a board to the player, with a command line input: 

```
Board setup [size, number of mines]:
  1 2 3
1 # # #
2 # # #
3 # # #

Please select field [x, y, action]:
```

Action can be one of the following:
D - Dig
F - Flag
C - Clear the flag, the field should be shown as masjed again (#).

Once a field is dug, the outcome can be: 

A field with no surrounding mines (field 1,1):

```
  1 2 3
1 . # #
2 # # #
3 # # #

```

A field with some surrounding mines, it needs to indicate how many mines surrounds it (field 2,1): 

```
  1 2 3
1 . 2 #
2 # # #
3 # # #

```

The game finishes when: 

The play wins by clearing the board and indicating where the mines are correctly: 

```
  1 2 3
1 . 2 F
2 . 3 F
3 . 2 F

```

The player loses by digging into a mine. 



