# Hamming_Code_Project
This repository contains the source code to implement non-systematic Hamming Code to detect double-bit and correct single-bit errors in a data. These codes were written as part of my CSE320 final project.

In data communications, Hamming codes are
a family of linear-error correcting codes. Since
they generally have a dmin value of 3,
Hamming codes can detect up to two-bit
errors or correct one-bit errors without
detection of uncorrected errors.

We can also refer to Hamming codes as a class
of binary linear codes. For each integer r≥2,
there is a code with data word length n=2<sup>r</sup>-1
and codeword length k=2<sup>r</sup> -r-1.

The key to the Hamming Code is the use of extra parity bits (redundant bits) to allow the
identification of a single error. In order to turn a data word into a codeword, a special
algorithm needs to be followed which is as follows:

<ol>
<li> The bit positions that are powers of two are to be assigned as parity bits. (positions 1, 2, 4,
  8 etc.) </li><br>
  
<li> The remaining bit positions are for the data to be encoded. (positions 3, 5, 6, 7, 9, 10 etc.)</li><br>

<li> Each parity bit calculates the parity for some of the bits in the code word. The position of
the parity bit determines the sequence of bits that it alternately checks and skips.

<b>Position 1</b>: starting from position 1, check 1 bit, skip 1 bit, check 1 bit, skip 1 bit, etc.
(1,3,5,7,9,11,13,15,...)

<b>Position 2</b>: starting from position 2, check 2 bits, skip 2 bits, check 2 bits, skip 2 bits, etc.
(2,3,6,7,10,11,14,15,...)

<b>Position 4</b>: starting from position 4, check 4 bits, skip 4 bits, check 4 bits, skip 4 bits, etc.
(4,5,6,7,12,13,14,15,…)

<b>Position 8</b>: starting from position 8, check 8 bits, skip 8 bits, check 8 bits, skip 8 bits, etc.
(8,9,10,11,12,13,14,15,24,25,26,27,28,29,30,31,…)</li>

<li> Set a parity bit to 1 if the total number of ones in the positions it checks is odd. Set a parity bit to 0 if the total number of ones in the positions it checks is even. </li>
</ol>

Upon receiving the codeword, the receiver checks for any errors by verifying each check bit.
If the received codeword has no errors, the parity bits are discarded and the data word
accepted. If there is any error, the receiver corrects that error to extract the data word that
was sent. However, keep in mind that since the value of dmin is 3, the receiver can correct only
1 error (although it can detect up to 2 errors) and so, if there are multiple incorrect bits, the
receiver would not be able to efficiently correct the codeword.

In order to correct an erroneous codeword, the receiver would need to verify each check bit
and calculate which bit was wrong. To do so, the receiver needs to check each parity bit and
add the positions that are wrong which would ultimately give the position for the incorrect bit.
The receiver can then just invert that bit, discard the parity bits and get the initial data word
sent.
