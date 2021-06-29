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

### Stage #3
Use the same basic algorithm as Stage #2, but also include the following requirements:
* Must be able to decode encrypted messages, given the encrypted message and the key.
* Encrypt/Decrypt all characters in the Basic Latin subset of Unicode characters (ref: https://en.wikipedia.org/wiki/List_of_Unicode_characters#Basic_Latin).

### Stage #4
Get the input from command line arguments instead of via standard input.

### Stage #5
Add the ability to read from and write to files. 

## Stages
### Stage #1: Encrypted!
Link: https://hyperskill.org/projects/46/stages/245/implement

### Stage #2: Knowledge is key
Link: https://hyperskill.org/projects/46/stages/246/implement

### Stage #3: Decrypted!
Link: https://hyperskill.org/projects/46/stages/247/implement

### Stage #4: I command you
Link: https://hyperskill.org/projects/46/stages/248/implement

### Stage #5: X-files
Link: https://hyperskill.org/projects/46/stages/249/implement