
# Problem:
 Fortunately for you, the minions aren't exactly advanced cryptographers.
 In their code, every lowercase letter [a..z] is replaced with the corresponding one in [z..a], while every other character (including
 uppercase letters and punctuation) is left untouched.  That is, 'a'
 becomes 'z', 'b' becomes 'y', 'c' becomes 'x', etc.  For instance,
 the word ""vmxibkgrlm"", when decoded, would become ""encryption""
 
 Note:
 ASCII value a = 97, z= 122.
 There are 26 letters in English alphabets `a` to `z`.
 
 Read the blog at https://codenit.com/google-foobar-first-codechallenge-caesar-cipher
 
 Further findings after submission of the problem:
 
 The **Atbash Cipher** is a simple substitution cipher that relies on
 transposing all the letters in the alphabet such that the resulting
 alphabet is backwards. The first letter is replaced with the last
 letter, the second with the second-last, and so on.
 
 An Atbash cipher for the Latin alphabet would be as follows:
 
 ```text
 Plain:  abcdefghijklmnopqrstuvwxyz
 Cipher: zyxwvutsrqponmlkjihgfedcba
 ```
 
 It is a very weak cipher because it only has one possible key, and it is
 a simple monoalphabetic substitution cipher. However, this may not have
 been an issue in the cipher's time.
 
 Ciphertext is written out in groups of fixed length, the traditional group size
 being 5 letters, and punctuation is excluded. This is to make it harder to guess
 things based on word boundaries.
 
 ## Examples
 
 - Encoding `test` gives `gvhg`
 - Decoding `gvhg` gives `test`
 - Decoding `gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt` gives `thequickbrownfoxjumpsoverthelazydog`