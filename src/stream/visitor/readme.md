# Goal
Using streams to speed up a pricing engine being run against a shopping cart.
By default calling the pricing engine is implemented using the Visitor Design Pattern.

For use in Naimuri insight/blog post.

# Implementation Notes

## Validity of this Test
ParallelStream fits the problem space perfectly. Actual time savings will depend on the implementation details of each 
visitor, but the overall time should not be much longer that the costliest visit operation, assuming that there are
network calls, database interaction, file IO, etc as part of the most complex method. The design pattern does not need to
be tweaked at all to make the use of a ParallelStream effective.

## Elements Cut From The GoF Example
It's clear from the class diagram that I didn't add a second type of visitor. Sure I could have made a reporting visitor,
or something simular, but I don't feel it would have inustrated anything unique to the pricing visitor. Likewise, the 
structure we are stepping through is simply a list, you could see this as being any type of datastructure. The GoF book
doesn't go into detail here because it is out of the scope of the book, so neither did I. However, it should be noted
that only collections that extend the [java.util interface](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html "Collection Interface JavaDoc")
can initiate a ParallelStream.

## Example Back End
I have made a play spring boot project that is a partial implementation of the back end to this example. The 'problem' being it
also includes my experimentation on other topics suct as SQLDialects, and Kotlin: [pricing-engine](https://github.com/PhilOfCalth/pricing-engine)

## Findings
1. ParallellStreams are exceptionally effective at turning a loop into a multithreaded operation.
2. Large stream code can get complex and hard to read quickly
3. There are signifigant optimixations in the speed of a stream between Java 8 and Java 12
4. Loops are faster than streams on almost every ocasion that does not benefit from multithreading
