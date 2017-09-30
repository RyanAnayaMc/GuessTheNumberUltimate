# GuessTheNumberUltimate
Just a test program that uses Java to make a guessing game with three different, customizable game modes. I made this because in my programming class, we made a normal guess the number game with integers from 1 through 5. I felt like expanding it, so I made this.

## The Code
The program is fairly simple. It uses `JOptionPane` for a basic GUI interface to ask the user for their guesses and settings, selecting modes, and reporting whether or not they were successful. There's lots of `if` statements as well in order to process input in different ways. The last interesting bit is the use of the `DecimalFormat` class exclusively in the Decimal game mode in order to reduce the decimal to the size the user wants it to be.

## Building
Just throw the source code into whatever Java workspace you like using and compile it there. Otherwise, you can just head over to the [releases page](https://github.com/RyanAnayaMc/GuessTheNumberUltimate/releases/).

# Modes
## Integer
A simple mode where the user guesses a random integer. The user can input a difficulty integer as well which affects the range of numbers that can be chosen. For instance, 6 would be integers from 1 through 6. _Probably the most practical mode to play._
## Character
Similar to Integer mode but uses letters of the alphabet. There are two options for this mode: single case and double case. Single case is the easy one, where the characters will all be converted to uppercase. In double case, your option and the correct option can be either uppercase or lowercase. _Great if you are tired of guessing numbers._
## Decimal
Similar to integer mode but generates a decimal instead of an integer. The user can input two difficulty options. The first affects the range of numbers, similar to the Integer mode. A second option affects how many decimal places the answer will have. _Play this if you really hate winning._
