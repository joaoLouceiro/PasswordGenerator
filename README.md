# PasswordGenerator

Simple CLI application that generates a random password according to the user's choices.

## Workflow
The user is prompted to select which characters he/she wants on his/hers password (upper case, lower case, numbers and symbols);
After choosing at least one of the options, the user has to select a password length between 8 and 32 characters long;

# Branch management
As this is a small refresher, there will be two working branches, to experiment with different solutions.

## emptyConstructor
*emptyContructor* has a functioning version using a Password class with, you guessed it, an empty Constructor.
Password Generation is handled by using the classes' accessor methods to first set the required properties (which character types the user wants and length) and then calling the object's public generatePassword() method to generate a String based on it's properties.

## fullConstructor
*fullContructor* works by storing the required values in temporary variables and then passing them on to a constructor which will generate the String automatically.
Access to the final String is done via a getPassword() method.
