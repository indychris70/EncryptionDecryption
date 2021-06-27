# Encryption-Decryption

## About
Privacy is an important matter is the realm of the Internet. When sending a message, you want to be sure that no-one but the addressee with the key can read it. The entirety of the modern Web is encrypted - take https for example! Don’t stay behind: hop on the encryption/decryption train and learn the essential basics while implementing this simple project.

## Learning outcomes
Gradually get familiar with Java, paying special attention to working with files and the command line.

## This project is a part of the following tracks
Java DeveloperJava Junior Developer (Web, Spring)Java Developer 2.0

### Link:
https://hyperskill.org/projects/46

## Requirements

### Stage #1
Take a hard coded String: "we found a treasure!" and print the encrypted value after applying the "Mirror" algorithm:

#### Mirror Algorithm
 
The "Mirror" encryption algorithm finds the index of each character in the ordered range (a-z) 
and replaces it with the character at the corresponding index in the reversed ordered range (z-a).

Only input characters in the range of (a-z) are encrypted. All others are output unchanged.

The expected output after encrypting with the Mirror algorithm is "dv ulfmw z givzhfiv!"

### Stage #2
Take input from standard input, which includes a String to be encrypted and an Integer Key value. 
Encrypt the input string using the OffsetN algorithm and print the encrypted value.

#### OffsetN Algorithm

The "OffsetN" encryption algorithm finds the index of each character in the ordered range (a-z)
and replaces it with the character at the position "index + offset" of the same range. If "index + offset"
is out of range, wrap around to the beginning.

Example: input character is 'w' and offset is 5. Encrypted value will be 'b' (offset 5 from 'w': 'x', 'y', 'z', 'a', 'b').

## Stages
### Stage #1: Encrypted!
Link: https://hyperskill.org/projects/46/stages/245/implement

### Stage #2: Knowledge is key
Link: https://hyperskill.org/projects/46/stages/246/implement